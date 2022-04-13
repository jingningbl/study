package com.spring7;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/8 8:49
 * @describe
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private int classId;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
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
    public void init(){
        System.out.println("初始化...");
    }
    public void destroy(){
        System.out.println("销毁....");
    }
}
