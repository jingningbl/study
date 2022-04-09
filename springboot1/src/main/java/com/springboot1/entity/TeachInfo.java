package com.springboot1.entity;

import java.io.Serializable;

/**
 * (TeachInfo)实体类
 *
 * @author makejava
 * @since 2022-04-02 15:28:40
 */
public class TeachInfo implements Serializable {
    private static final long serialVersionUID = 275797821415859246L;
    
    private Integer tid;
    
    private String tname;
    
    private String age;
    
    private String course;


    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "TeachInfo{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", age='" + age + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
