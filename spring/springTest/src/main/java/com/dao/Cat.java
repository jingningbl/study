package com.dao;

/**
 * @author bai
 * @version V1.0
 * @Package com.dao
 * @date 2022/2/15 22:10
 * @describe
 */
public class Cat implements Animal {

    private String name;

    @Override
    public void say() {
        System.out.println("喵喵喵");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
