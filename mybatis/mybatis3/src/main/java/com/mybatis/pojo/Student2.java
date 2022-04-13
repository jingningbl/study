package com.mybatis.pojo;

import java.util.Date;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.pojo
 * @date 2022/3/15 21:24
 * @describe
 */
public class Student2 {
    private Integer id;
    private String name;
    private String address;
    /**
     * myBirthday对应表中my_birthday
     */
    private Date myBirthday;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getMyBirthday() {
        return myBirthday;
    }

    public void setMyBirthday(Date myBirthday) {
        this.myBirthday = myBirthday;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", myBirthday=" + myBirthday +
                '}';
    }
}
