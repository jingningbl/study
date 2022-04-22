package com.spring9.handler;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: bai
 * @date: 2022/4/22 8:31
 * @description: cglib
 */
public class CgLibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    /**
     * 生成代理对象的方法
     */
    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 回调方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理前");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib代理后");
        return invoke;
    }
}
