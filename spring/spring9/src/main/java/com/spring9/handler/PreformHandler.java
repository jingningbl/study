package com.spring9.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: bai
 * @date: 2022/4/22 8:15
 * @description: Spring Aop动态代理实现寄机制  jdk
 */
public class PreformHandler implements InvocationHandler {

    private Object target;

    public PreformHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始");
        Object invoke = method.invoke(target, args);
        System.out.println("结束");
        return invoke;
    }
}
