package com.spring7;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/8 8:49
 * @describe
 */
public class StudentClass {
    private int id;
    private int classId;
    private String name;

    public StudentClass(int id, int classId, String name) {
        this.id = id;
        this.classId = classId;
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
