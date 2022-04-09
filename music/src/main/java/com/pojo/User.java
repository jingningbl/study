package com.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2021/12/7 14:12
 * @describe
 */
public class User {
    private int id;
    private String username;
    private String pwd;

    public User() {
    }

    public User(int id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }
}
