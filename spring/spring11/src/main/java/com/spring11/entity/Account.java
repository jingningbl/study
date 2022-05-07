package com.spring11.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2022-05-06 08:23:32
 */
@Component
public class Account implements Serializable {

    private static final long serialVersionUID = 208453846133899817L;
    
    private Integer id;
    
    private String aname;
    
    private Double money;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

}
