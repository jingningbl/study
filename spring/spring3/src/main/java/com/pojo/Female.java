package com.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/15 21:18
 * @describe
 */
public class Female {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Female{" +
                "name='" + name + '\'' +
                '}';
    }
}
