package com.ssm1.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author q1425
 */
@ApiModel(description = "测试用户")
public class TestUser implements Serializable {

    private static final long serialVersionUID = -2705419003360530213L;
    /**
     * example:例子
     * hidden:隐藏
     */
    @ApiModelProperty(value = "用户名", example = "admin", required = true, hidden = false)
    private String username;
    @ApiModelProperty(value = "密码", example = "1513", required = true, hidden = false)
    private String password;

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

    @Override
    public String toString() {
        return "TestUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
