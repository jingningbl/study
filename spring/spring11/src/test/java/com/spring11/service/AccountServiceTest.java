package com.spring11.service;

import com.spring11.service.impl.AccountServiceImpl;
import com.spring11.service.impl.AccountServiceImpl_1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: bai
 * @date: 2022/5/6 9:02
 * @description:
 */
public class AccountServiceTest {
    /**
     * 编程式事务
     */
    @Test
    public void testAccountServiceImpl(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        AccountServiceImpl accountService = context.getBean("accountService", AccountServiceImpl.class);
        accountService.transfer(1,2,1000.0);
    }
    /**
     * 声明式事务,xml配置
     */
    @Test
    public void testAccountServiceImpl1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application1.xml");
        AccountServiceImpl accountService = context.getBean("accountService", AccountServiceImpl.class);
        accountService.trans(1,2,1000.0);
    }
    /**
     * 声明式事务,注解配置
     */
    @Test
    public void testAccountServiceImpl2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application2.xml");
        AccountServiceImpl_1 accountService = context.getBean("accountService_1", AccountServiceImpl_1.class);
        accountService.trans(1,2,1000.0);
    }
}