package com.spring6.entity;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/1 8:47
 * @describe
 */
public class Teacher {
    public Teacher() {
        System.out.println("老师在教学");
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void teach() {
        System.out.println("老师在教" + msg);
    }
}
