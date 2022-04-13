package com.spring6.entity;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/1 8:30
 * @describe
 */
public class Student {

    public Student() {
        System.out.println("student创建了");
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void study() {
        System.out.println("学生在学习" + msg);
    }
}
