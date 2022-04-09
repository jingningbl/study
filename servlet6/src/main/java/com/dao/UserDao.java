package com.dao;

import com.pojo.User;

public interface UserDao {
    //    注册
    boolean save(User user);

    //    删除
    boolean delete(String username);

    //    登录
    User login(String username, String pwd);

    //    查询用户是否存在
    User findByUsername(String username);
//    更改密码
    boolean rePwd(String username,String pwd);
}
