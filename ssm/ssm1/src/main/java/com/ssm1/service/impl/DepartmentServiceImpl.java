package com.ssm1.service.impl;

import com.ssm1.dto.requestDto.DepartmentListRequestDto;
import com.ssm1.dto.requestDto.ToggleDepartmentStatusRequestDto;
import com.ssm1.dto.responseDto.DepartmentListResponseDto;
import com.ssm1.entity.Department;
import com.ssm1.dao.DepartmentDao;
import com.ssm1.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门表(Department)表服务实现类
 *
 * @author makejava
 * @since 2022-04-16 19:31:24
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param depId 主键
     * @return 实例对象
     */
    @Override
    public Department queryById(Integer depId) {
        return this.departmentDao.queryById(depId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Department> queryAllByLimit(int offset, int limit) {
        return this.departmentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insert(Department department) {
        this.departmentDao.insert(department);
        return department;
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department update(Department department) {
        this.departmentDao.update(department);
        return this.queryById(department.getDepId());
    }

    /**
     * 通过主键删除数据
     *
     * @param depId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer depId) {
        return this.departmentDao.deleteById(depId) > 0;
    }

    /**
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 查询部门列表, 单纯查询, 不需要事物声明
     */
    @Override
    public Map<String, Object> queryPageList(DepartmentListRequestDto departmentListRequestDto) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<DepartmentListResponseDto> departmentListResponseDto = departmentDao.queryPageList(departmentListRequestDto);
            map.put("success", true);
            map.put("data", departmentListResponseDto);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            //如果用到Spring的事物声明,则需要的catch中捕获后抛出,否则事物失效
        }
        return map;
    }

    /**
     * 对部门状态进行切换
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public Map<String, Object> toggleStatus(ToggleDepartmentStatusRequestDto requestDto) throws Exception {
        Map<String, Object> map = new HashMap<>();
        /**
         * 该部门当前状态
         */
        Integer status = requestDto.getStatus();
        Integer depId = requestDto.getDepId();
        try {
            if (status == 1) {
                //状态禁用
                departmentDao.updateFailureStatusById(depId);
                throw new Exception("测试异常");
            } else {
                //状态启用
                departmentDao.updateSuccessStatusById(depId);
            }
            map.put("success", true);
        } catch (Exception e) {
            //使用了声明式事物,必须要将异常抛出,否则事物失效
            throw e;
        }
        return map;
    }
}
