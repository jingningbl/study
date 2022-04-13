package com.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author bai
 * @version V1.0
 * @Package com.dao
 * @date 2022/2/15 11:41
 * @describe
 */
@Repository
//主要用在根据类型注入Bean,容器中存在多个类型相同的Bean的情况,可以在想要注入的Bean上添加@Primary,等同于加primary=true,相同类型的注解
//只能有一个Bean有@Primary
@Primary
@DependsOn
//@ComponentScan()
public class StudentDao implements PeopleDao{

    @Override
    public void queryById(Integer id) {
        System.out.println("根据id:"+id+"查询到了学生信息");
    }
}
