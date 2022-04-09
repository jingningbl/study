package com.dubbo.service.impl;

import com.dubbo.pojo.User;
import com.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.Service;

;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 22:29
 * @describe
 */
//注册bean

/**
 * 使用dubbo的service,将服务对外开放,将访问的地址(ip,端口,路径)注册到注册中心,timeout超时
 * 当服务提供方的@Service注解与调用方的@Reference注解同时配置超时,以@Reference为准,所以一般给@Service配置超时
 * retries重试次数
 */
@Service(timeout = 3000,retries = 2,version = "v2.0")
public class UserServiceImpl2 implements UserService {
    int i=1;
    public String sayHello() {
        return "hi,dubbo";
    }

    public User findUserById(Integer id) {
        System.out.println("new..................");
        System.out.println("服务被调用了"+i++);
        User user = new User(1, "李四", "123");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
