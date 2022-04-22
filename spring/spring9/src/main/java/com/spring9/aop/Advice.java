package com.spring9.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author: bai
 * @date: 2022/4/22 8:48
 * @description:
 */
public class Advice {

    public void before() {
        System.out.println("前置通知");
    }

    public void after() {
        System.out.println("后置通知");
    }

    public void afterReturn() {
        System.out.println("返回后通知");
    }

    public void exception() {
        System.out.println("异常通知");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前");
        //调用目标方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知后");
        return proceed;
    }
}
