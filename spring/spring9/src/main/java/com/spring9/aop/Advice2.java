package com.spring9.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: bai
 * @date: 2022/4/22 8:48
 * @description:
 */
@Component
@Aspect
@Order(0)
public class Advice2 {

    @Pointcut(value = "execution(* com.spring9.service..*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("前置通知2");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("后置通知2");
    }

    @AfterReturning("pointcut()")
    public void afterReturn() {
        System.out.println("返回后通知2");
    }

    @AfterThrowing("pointcut()")
    public void exception() {
        System.out.println("异常通知2");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前2");
        //调用目标方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知后2");
        return proceed;
    }
}
