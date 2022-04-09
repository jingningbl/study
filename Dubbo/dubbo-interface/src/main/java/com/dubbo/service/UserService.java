package com.dubbo.service;


import com.dubbo.pojo.User;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 22:24
 * @describe
 */
public interface UserService {

    String sayHello();
    /**
     * 查询用户
     */
    User findUserById(Integer id);
}
