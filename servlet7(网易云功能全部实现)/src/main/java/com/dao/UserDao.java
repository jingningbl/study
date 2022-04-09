package com.dao;

import com.pojo.User;

/**
 * @author Administrator
 * @title: UserDao
 * @projectName vip2105
 * @description: TODO
 * @date 2021/11/26 20:32
 */
public interface UserDao {
    //注册
    boolean save(User u);
    //登录
    User login(String username,String pwd);
    //判断是否被注册根据用户名
    User findByUsername(String username);
    //修改密码
    boolean rePwd(String username,String pwd);
}
