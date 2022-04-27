package com.ssm1.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm1.dto.requestDto.EmployeeListRequestDto;
import com.ssm1.dto.responseDto.EmployeeDto;
import com.ssm1.entity.Employee;
import com.ssm1.dao.EmployeeDao;
import com.ssm1.service.EmployeeService;
import org.springframework.stereotype.Service;

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

    /**
     * 通过ID查询单条数据
     *
     * @param emId 主键
     * @return 实例对象
     */
    @Override
    public Employee queryById(Integer emId) {
        return this.employeeDao.queryById(emId);
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
    public Employee update(Employee employee) {
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
        return employeeDao.getEmInfoByUsernameAndPassword(username, password);
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
}
