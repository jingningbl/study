package com.spring11.dao;

import org.springframework.stereotype.Repository;

/**
 * (Account)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-06 08:23:33
 */
public interface AccountDao {

    void increaseMoney(Integer id,Double money);

    void decreaseMoney(Integer id,Double money);

}

