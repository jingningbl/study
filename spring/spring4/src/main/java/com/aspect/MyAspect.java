package com.aspect;

import com.pojo.MyResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author bai
 * @version V1.0
 * @Package com.aspect
 * @date 2022/2/19 13:55
 * @describe 基于接口的Aop是jdk动态代理, 基于类的Aop是cglib动态代理
 */
@Component
//@Aspect
public class MyAspect {
    @Pointcut("execution(* com.service..*.*(..))")
    public void firstPC() {

    }

    @Before("firstPC()")
//    @Before("execution(* com.service..*.*(..))")
    public void myEnhance(JoinPoint joinPoint) {
//        JoinPoint代表目标方法
//        获取目标方法签名(目标方法唯一标志)
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName());
        System.out.println(joinPoint.getTarget());
//        获取实参列表
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(i);
            }
        }
        System.out.println("调用接口时间为:" + LocalDateTime.now());
    }

    @AfterReturning(value = "firstPC()", returning = "result")
//    @AfterReturning(value = "execution(* com.service..*.*(..))",returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        System.out.println("-----------------------");
        System.out.println("afterReturningAdvice被执行了");
        System.out.println("目标方法:" + joinPoint.getSignature() + "的返回值为:" + result);
        if (result instanceof Number) {
            result = 9999;
        } else if (result instanceof String) {
            result = "木子帅";
        } else if (result instanceof MyResult) {
            ((MyResult) result).setId(2);
        }
        System.out.println("目标方法:" + joinPoint.getSignature() + "的返回值为:" + result);
        System.out.println("-----------------------");
    }

    @After("firstPC()")
//    @After("execution(* com.service..*.*(..))")
    public void afterAdvice() {
        System.out.println("----------------");
        System.out.println("afterAdvice被执行了");
        System.out.println("----------------");
    }

    /**
     * 环绕通知,一个相当于另外4个
     *
     * @return
     */
    @AfterThrowing
    @Around("firstPC()")
//    @Around("execution(* com.service..*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = 0;
        try {
            //        前置通知
            System.out.println("环绕通知中的前置通知");
            start = System.currentTimeMillis();
//        调用目标方法
            Object proceed = joinPoint.proceed();
//        返回后通知
            System.out.println("环绕通知中的返回后通知,值为:" + proceed);
            return proceed;
        } catch (Exception e) {
//            异常通知
            System.out.println("环绕通知中的异常通知,异常为:" + e.getMessage());
//            最好在通知里面把异常抛出去,让调用方知道有这个异常
            throw e;
        } finally {
            System.out.println("环绕通知中的后置通知");
            long end = System.currentTimeMillis();
            System.out.println("目标方法" + joinPoint.getSignature().getName() + "耗时为:" + (end - start));
        }
    }
}
