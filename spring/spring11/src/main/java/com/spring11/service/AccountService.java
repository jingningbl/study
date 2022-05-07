package com.spring11.service;


/**
 * (Account)表服务接口
 *
 * @author makejava
 * @since 2022-05-06 08:23:34
 */
public interface AccountService {

    /**
     * 编程式事务
     */
    void transfer(Integer from, Integer to, Double money);
    /**
     * 声明式事务
     */
    void trans(Integer from, Integer to, Double money);
}
