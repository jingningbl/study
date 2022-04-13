package com.mybatis.dto;

import com.mybatis.entity.Student;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.dto
 * @date 2022/3/21 10:07
 * @describe 一对多
 */
public class OneManyDto {

    private Integer id;
    /**
     * 班级id
     */
    private Integer classId;
    /**
     * 班级名
     */
    private String name;
    /**
     * 所有学生
     */
    private List<Student> studentList;

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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "OneManyDto{" +
                "id=" + id +
                ", classId=" + classId +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
