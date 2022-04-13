package com.mybatis6.dao;

import com.mybatis6.entity.Student;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-24 20:45:54
 */
public interface StudentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);

}

