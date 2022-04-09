package com.springboot1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author bai
 * @version V1.0
 * @date 2022/3/30 22:00
 * @describe
 */
@Component
//启动配置的自动注入功能,注入的属性必须有setter方法
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "bai")
public class MyConfig {
    @Value("${bai.name}")
    private String name;
    //    @Value("${bai.outlook}")
    private String outlook;
    //    @Value("${bai.age}")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        System.err.println("setOutlook被调用了");
        this.outlook = outlook;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyConfig{" +
                "name='" + name + '\'' +
                ", outlook='" + outlook + '\'' +
                ", age=" + age +
                '}';
    }
}