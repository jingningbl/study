package com.mybatis.dto;

import com.mybatis.pojo.Course;

import java.io.Serializable;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.dto
 * @date 2022/3/20 15:31
 * @describe
 */
public class ManyToOneDto implements Serializable {

    private static final long serialVersionUID = 9037524700901217082L;
    private Integer id;
    private String name;
    private String address;
    private Integer courseId;
//    private Integer courseId2;
//    private String courseName;
    private Course course;

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

//    public Integer getCourseId2() {
//        return courseId2;
//    }
//
//    public void setCourseId2(Integer courseId2) {
//        this.courseId2 = courseId2;
//    }
//
//    public String getCourseName() {
//        return courseName;
//    }
//
//    public void setCourseName(String courseName) {
//        this.courseName = courseName;
//    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

//    @Override
//    public String toString() {
//        return "ManyToOneDto{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                ", courseId=" + courseId +
//                ", courseId2=" + courseId2 +
//                ", courseName='" + courseName + '\'' +
//                '}';

    @Override
    public String toString() {
        return "ManyToOneDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", courseId=" + courseId +
                ", course=" + course +
                '}';
    }
}
