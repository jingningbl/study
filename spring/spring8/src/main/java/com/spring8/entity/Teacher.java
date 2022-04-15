package com.spring8.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2022-04-15 09:03:02
 */
@Component
@Scope(scopeName = "prototype")
public class Teacher {
    @Value("1")
    private Integer id;
    @Value("张三")
    private String name;
    @Value("上海")
    private String address;


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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * 初始化方法
     */
    @PostConstruct
    public void init() {
        System.out.println("初始化完成");
    }

    /**
     * 销毁方法
     */
    @PreDestroy
    public void destroy() {
        System.out.println("销毁...");
    }
}

