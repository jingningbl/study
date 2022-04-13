package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author bai
 * @version V1.0
 * @Package com.aspect
 * @date 2022/2/21 12:41
 * @describe 环绕通知
 */
@Component
@Aspect
public class AroundAspect {
    @Around("execution(* com.service..*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = 0;
        try {
            System.out.println("环绕通知的前置通知");
            start = System.currentTimeMillis();
            Object proceed = joinPoint.proceed();
            System.out.println("环绕通知的返回后通知" + proceed);
            return proceed;
        } catch (Exception e) {
            System.out.println("环绕通知的异常通知" + e.getMessage());
            throw e;
        } finally {
            System.out.println("环绕通知的后置通知");
            long end = System.currentTimeMillis();
            System.out.println("目标方法耗时:" + (end - start) + "ms");
        }
    }
}
