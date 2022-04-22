package com.spring9.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author: bai
 * @date: 2022/4/22 8:48
 * @description:
 */
public class Advice1 {

    public void before() {
        System.out.println("前置通知1");
    }

    public void after() {
        System.out.println("后置通知1");
    }

    public void afterReturn() {
        System.out.println("返回后通知1");
    }

    public void exception() {
        System.out.println("异常通知1");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前1");
        //调用目标方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知后1");
        return proceed;
    }
}
