package com.ssm1.entity;

import java.io.Serializable;

/**
 * 部门表(Department)实体类
 *
 * @author makejava
 * @since 2022-04-16 19:31:24
 */
public class Department implements Serializable {
    private static final long serialVersionUID = -66686687233300690L;
    /**
    * 部门id
    */
    private Integer depId;
    /**
    * 部门名称
    */
    private String name;
    /**
    * 办公地点
    */
    private String address;
    /**
    * 1代表有效,0代表无效
    */
    private Integer status;


    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
