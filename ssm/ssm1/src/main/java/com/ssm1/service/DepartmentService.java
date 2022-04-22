package com.ssm1.service;

import com.ssm1.dto.requestDto.DepartmentListRequestDto;
import com.ssm1.dto.requestDto.ToggleDepartmentStatusRequestDto;
import com.ssm1.entity.Department;

import java.util.List;
import java.util.Map;

/**
 * 部门表(Department)表服务接口
 *
 * @author makejava
 * @since 2022-04-16 19:31:24
 */
public interface DepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param depId 主键
     * @return 实例对象
     */
    Department queryById(Integer depId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Department> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department update(Department department);

    /**
     * 通过主键删除数据
     *
     * @param depId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer depId);

    /**
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 查询部门列表
     */
    Map<String, Object> queryPageList(DepartmentListRequestDto departmentListRequestDto);

    /**
     * 对部门状态进行切换
     */
    Map<String, Object> toggleStatus(ToggleDepartmentStatusRequestDto requestDto) throws Exception;
}
