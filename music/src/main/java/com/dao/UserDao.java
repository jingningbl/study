package com.dao;

import com.pojo.User;

/**
 * @author bai
 * @version V1.0
 * @Package com.dao
 * @date 2021/12/7 14:14
 * @describe
 */
public interface UserDao {
    boolean save(User user);

    boolean delete(String username);

    User findUsername(String username);

    User login(String username, String pwd);
}
