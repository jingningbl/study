package com.ssm1.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2022-03-26 11:52:23
 */
@TableName("student")
public class Student implements Serializable {
    private static final long serialVersionUID = -83616014444691078L;
    /**
    * 学生id
    */
    @TableId
    private Integer id;
    /**
    * 学生姓名
    */
    private String name;
    /**
    * 学生年龄
    */
    private Integer age;
    /**
    * 班级id
    */
    private Integer classId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classId=" + classId +
                '}';
    }
}
