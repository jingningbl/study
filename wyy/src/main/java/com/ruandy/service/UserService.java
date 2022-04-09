package com.ruandy.service;

import com.ruandy.pojo.User;

/**
 * @author Administrator
 * @title: UserService
 * @projectName vip2105-web
 * @description: 业务层
 * @date 2021/12/28 20:20
 */
public interface UserService {
    //封装获取参数,插入数据库.数据库访问的优化处理,数据库的中间件
    boolean add(User u);
    //业务判定:是否被注册
    boolean findByUsername(String username);
    //登录业务
    User login(String username,String pwd);
//    修改密码
    boolean rePwd(String username,String newPwd);
}
