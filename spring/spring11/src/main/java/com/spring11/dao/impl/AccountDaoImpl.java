package com.spring11.dao.impl;

import com.spring11.dao.AccountDao;
import com.spring11.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: bai
 * @date: 2022/5/6 8:27
 * @description:
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void increaseMoney(Integer id, Double money) {
        String sql = "update spring.account set money = money + ? where id = ?";
        jdbcTemplate.update(sql, money, id);
    }

    @Override
    public void decreaseMoney(Integer id, Double money) {
        String sql = "update spring.account set money = money - ? where id = ?";
        jdbcTemplate.update(sql, money, id);
    }
}
