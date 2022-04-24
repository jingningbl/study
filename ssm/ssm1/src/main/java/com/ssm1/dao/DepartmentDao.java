package com.ssm1.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm1.dto.requestDto.DepartmentListRequestDto;
import com.ssm1.dto.responseDto.DepartmentListResponseDto;
import com.ssm1.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门表(Department)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-16 19:31:24
 */
public interface DepartmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param depId 主键
     * @return 实例对象
     */
    Department queryById(Integer depId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Department> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param department 实例对象
     * @return 对象列表
     */
    List<Department> queryAll(Department department);

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int insert(Department department);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Department> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Department> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Department> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Department> entities);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int update(Department department);

    /**
     * 通过主键删除数据
     *
     * @param depId 主键
     * @return 影响行数
     */
    int deleteById(Integer depId);

    /**
     * 查询部门列表
     */
//    List<DepartmentListResponseDto> queryPageList(DepartmentListRequestDto departmentListRequestDto);

    IPage<DepartmentListResponseDto> queryPageList(
            Page<DepartmentListRequestDto> departmentListRequestDto,
            @Param(Constants.WRAPPER) Wrapper<DepartmentListRequestDto> queryWrapper);
    /**
     * 部门状态无效
     */
    void updateFailureStatusById(Integer depId);

    /**
     * 部门状态有效
     */
    void updateSuccessStatusById(Integer depId);
}

