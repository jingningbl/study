package com.ssm1.service.impl;

import com.ssm1.entity.Department;
import com.ssm1.dao.DepartmentDao;
import com.ssm1.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
     * @param limit 查询条数
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
}
