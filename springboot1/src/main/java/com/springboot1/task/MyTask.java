package com.springboot1.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 18:29
 * @describe
 */
@Component
public class MyTask {
    /**
     * 定时任务注解
     * fixedRate固定频率ms(方法执行时间大于fixedRate,则时间为方法执行时间)
     * fixedDelay延迟时间ms
     */
    @Scheduled(cron = "0,10,20,30,40,50 * * * * ? ")
    public void say() {
        System.out.println(LocalDateTime.now() +"0000000");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
