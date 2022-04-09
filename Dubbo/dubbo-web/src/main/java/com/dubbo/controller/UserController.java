package com.dubbo.controller;

import com.dubbo.pojo.User;
import com.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 22:48
 * @describe
 */
@RestController
@RequestMapping("user")
public class UserController {
    //本地注入
    //@Autowired
    /**
     * 从zookeeper注册中心获取UserService的url进行远程访问(RPC)
     * 将结果封装为一个代理对象,给变量赋值
     */
    @Reference(timeout = 1000,version = "v2.0",loadbalance = "random")
    private UserService userService;

    @RequestMapping("sayHello")
    public String sayHello() {
        return userService.sayHello();
    }
    int i = 1;
    @RequestMapping("findUserById")
    public User findUserById(Integer id) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(i++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return userService.findUserById(id);
    }
}
