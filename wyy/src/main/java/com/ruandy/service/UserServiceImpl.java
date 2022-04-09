package com.ruandy.service;

import com.ruandy.dao.UserDao;
import com.ruandy.dao.UserDaoImpl;
import com.ruandy.pojo.User;

/**
 * @author Administrator
 * @title: UserServiceImpl
 * @projectName vip2105-web
 * @description: TODO
 * @date 2021/12/28 20:26
 */
public class UserServiceImpl implements UserService {
    //依赖具体的dao层对象
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean add(User u) {
        //业务的处理,,,
        //直接访问
        boolean flag = userDao.save(u);
        return flag;
    }

    @Override
    public boolean findByUsername(String username) {
        //dao层处理数据--数据库
        User u = userDao.findByUsername(username);
        return u == null;
    }

    @Override
    public User login(String username, String pwd) {
        User u = userDao.login(username, pwd);
        return u;
    }

    @Override
    public boolean rePwd(String username, String newPwd) {
        return userDao.rePwd(username, newPwd);
    }
}
