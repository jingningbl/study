package com.mybatis.dto;

import com.mybatis.entity.StudentClass;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.dto
 * @date 2022/3/20 22:18
 * @describe 多对一
 */
public class ManyOneDto {
    /**
     * 学生id
     */
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
    /**
     * 班级
     */
    private StudentClass studentClass;

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

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "ManyToOneDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classId=" + classId +
                ", studentClass=" + studentClass +
                '}';
    }
}
