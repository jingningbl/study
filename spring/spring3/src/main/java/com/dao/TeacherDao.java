package com.dao;

import org.springframework.stereotype.Repository;

/**
 * @author bai
 * @version V1.0
 * @Package com.dao
 * @date 2022/2/15 12:29
 * @describe
 */
@Repository
public class TeacherDao implements PeopleDao{

    @Override
    public void queryById(Integer id) {
        System.out.println("根据id:"+id+"查询到了老师信息");
    }
}
