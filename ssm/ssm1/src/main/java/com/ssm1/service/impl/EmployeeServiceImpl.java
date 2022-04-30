package com.ssm1.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm1.dao.DepartmentDao;
import com.ssm1.dao.PositionDao;
import com.ssm1.dto.requestDto.EmployeeListRequestDto;
import com.ssm1.dto.requestDto.ToggleEmployeeStatusRequestDto;
import com.ssm1.dto.responseDto.ActiveDepartmentListResponseDto;
import com.ssm1.dto.responseDto.ActivePositionListResponseDto;
import com.ssm1.dto.responseDto.EmployeeDto;
import com.ssm1.dto.responseDto.EmployeeResponseDto;
import com.ssm1.entity.Employee;
import com.ssm1.dao.EmployeeDao;
import com.ssm1.service.EmployeeService;
import com.ssm1.util.Md5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 员工表(Employee)表服务实现类
 *
 * @author makejava
 * @since 2022-04-26 15:01:37
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private PositionDao positionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param emId 主键
     * @return 实例对象
     */
    @Override
    public EmployeeResponseDto queryById(Integer emId) throws Exception {
        try {
            Employee employee = employeeDao.queryById(emId);
            if (Objects.isNull(employee)) {
                throw new RuntimeException("没有查询到员工信息");
            }
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            List<ActivePositionListResponseDto> activePositionList = positionDao.queryActivePositionList();
            List<ActiveDepartmentListResponseDto> activeDepartmentList = departmentDao.queryActiveDepartmentList();
            employeeResponseDto.setEmployee(employee);
            employeeResponseDto.setDepartmentList(activeDepartmentList);
            employeeResponseDto.setPositionList(activePositionList);
            return employeeResponseDto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Employee> queryAllByLimit(int offset, int limit) {
        return this.employeeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee insert(Employee employee) {
        employee.setPassword(Md5Util.getMd5("123456"));
        this.employeeDao.insert(employee);
        return employee;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeResponseDto update(Employee employee) throws Exception {
        this.employeeDao.update(employee);
        return this.queryById(employee.getEmId());
    }

    /**
     * 通过主键删除数据
     *
     * @param emId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer emId) {
        return this.employeeDao.deleteById(emId) > 0;
    }

    @Override
    public EmployeeDto getEmInfoByUsernameAndPassword(String username, String password) {
        return employeeDao.getEmInfoByUsernameAndPassword(username, Md5Util.getMd5(password));
    }

    @Override
    public Map<String, Object> queryPageList(EmployeeListRequestDto requestDto) {
        Map<String, Object> map = new HashMap<>();
        try {
            //构建者模式
            //wrapper.like().eq()...
            QueryWrapper<EmployeeListRequestDto> wrapper = new QueryWrapper<>();
            if (!StringUtils.isEmpty(requestDto.getName())) {
                wrapper.like("name", requestDto.getName());
            }
            if (!StringUtils.isEmpty(requestDto.getLoginName())) {
                wrapper.like("login_name", requestDto.getLoginName());
            }
            if (Objects.nonNull(requestDto.getDepId())) {
                wrapper.eq("dep_id", requestDto.getDepId());
            }
            if (Objects.nonNull(requestDto.getPositionId())) {
                wrapper.eq("position_id", requestDto.getPositionId());
            }
            if (requestDto.getStatus() != null) {
                wrapper.eq("status", requestDto.getStatus());
            }
//            wrapper.like(!StringUtils.isEmpty(requestDto.getName()),"name",requestDto.getName())
//                    .eq(Objects.nonNull(requestDto.getDepId()),"dep_id",requestDto.getDepId())
//                    .eq(Objects.nonNull(requestDto.getPositionId()),"position_id",requestDto.getPositionId())
//                    .eq(Objects.nonNull(requestDto.getStatus()),"status",requestDto.getStatus());
            Page<EmployeeListRequestDto> page = new Page<>(requestDto.getCurrent(), requestDto.getSize());
            IPage<EmployeeDto> employee = employeeDao.queryPageList(page, wrapper);
            map.put("success", true);
            map.put("data", employee);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        return map;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public Map<String, Object> toggleStatus(ToggleEmployeeStatusRequestDto requestDto) {
        Map<String, Object> map = new HashMap<>();
        Integer emId = requestDto.getEmId();
        Integer status = requestDto.getStatus();
        try {
            if (status == 1) {
                //状态禁用
                employeeDao.updateFailureStatusById(emId);
            } else {
                //状态启用
                employeeDao.updateSuccessStatusById(emId);
            }
            map.put("success", true);
        } catch (Exception e) {
            throw e;
        }
        return map;
    }
}
