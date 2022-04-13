package com.mybatis.dto;

import com.mybatis.pojo.Student;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.dto
 * @date 2022/3/20 18:57
 * @describe
 */
public class OneToManyDto {
    private Integer courseId;
    private String courseName;
    private List<Student> studentList;

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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "OneToManyDto{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
