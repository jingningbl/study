package com.mybatis.entity;

import java.io.Serializable;

/**
 * (StudentClass)实体类
 *
 * @author makejava
 * @since 2022-03-20 21:26:44
 */
public class StudentClass implements Serializable {
    private static final long serialVersionUID = 570918976466203928L;
    
    private Integer id;
    /**
    * 班级id
    */
    private Integer classId;
    /**
    * 班级名
    */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", classId=" + classId +
                ", name='" + name + '\'' +
                '}';
    }
}
