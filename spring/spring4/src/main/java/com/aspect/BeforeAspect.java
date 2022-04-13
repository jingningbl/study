package com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author bai
 * @version V1.0
 * @Package com.aspect
 * @date 2022/2/19 14:51
 * @describe
 */
@Component
//@Aspect
public class BeforeAspect {
    public void test(){
        System.out.println("发送前置通知");
    }
}
