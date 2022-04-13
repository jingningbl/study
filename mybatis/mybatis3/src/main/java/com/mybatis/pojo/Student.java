package com.mybatis.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.pojo
 * @date 2022/3/15 21:24
 * @describe
 */
//@Alias()开启包扫描设置别名
public class Student implements Serializable{

    private static final long serialVersionUID = 8904437936322244839L;
    private Integer id;
    private String name;
    private String address;
    private Integer courseId;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
