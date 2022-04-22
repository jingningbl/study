package com.spring9.service.impl;

import com.spring9.service.UserService;

/**
 * @author: bai
 * @date: 2022/4/22 8:47
 * @description:
 */
public class UserServiceImpl implements UserService {

    @Override
    public void select() {
        System.out.println("查");
    }
}
