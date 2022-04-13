package com.mybatis.pojo;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2022-03-20 14:38:55
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 838060839614532813L;
    
    private Integer courseId;
    
    private String courseName;


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
