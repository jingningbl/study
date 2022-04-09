package com.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/2 9:33
 * @describe
 */
public class Beauty {
    private String name;
    private Integer age;
    public String phone;

    public Beauty() {
    }

    public Beauty(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
