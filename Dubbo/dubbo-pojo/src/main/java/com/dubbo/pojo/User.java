package com.dubbo.pojo;

import java.io.Serializable;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/4 22:10
 * @describe 实体类需要实现序列化接口
 */
public class User implements Serializable {

    private static final long serialVersionUID = -7891182072840205860L;

    private Integer id;

    private String username;

    private String password;

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
