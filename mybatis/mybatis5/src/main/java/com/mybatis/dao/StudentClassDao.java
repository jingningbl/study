package com.mybatis.dao;

import com.mybatis.dto.OneManyDto;
import com.mybatis.entity.StudentClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (StudentClass)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-20 21:26:44
 */
public interface StudentClassDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StudentClass queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<StudentClass> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param studentClass 实例对象
     * @return 对象列表
     */
    List<StudentClass> queryAll(StudentClass studentClass);

    /**
     * 新增数据
     *
     * @param studentClass 实例对象
     * @return 影响行数
     */
    int insert(StudentClass studentClass);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StudentClass> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StudentClass> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StudentClass> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<StudentClass> entities);

    /**
     * 修改数据
     *
     * @param studentClass 实例对象
     * @return 影响行数
     */
    int update(StudentClass studentClass);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据class_id查询班级信息
     *
     * @param classId
     * @return StudentClass
     */
    StudentClass selectClassByClassId(Integer classId);

    /**
     * 根据班级id查询该班级所有的学生
     *
     * @param id
     * @return
     */
    OneManyDto selectStudentFromClassByClassId(Integer id);
}

