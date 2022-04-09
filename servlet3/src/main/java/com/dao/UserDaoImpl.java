package com.dao;

import com.pojo.User;
import com.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:Administrator
 * @data:2021/11/27
 * @description:
 */
public class UserDaoImpl implements UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        try {
            connection = DruidUtils.getConn();
            String sql = "insert into test.music_user(username, pwd) values (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPwd());
            return preparedStatement.executeUpdate() == 1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtils.close(connection, preparedStatement, resultSet);
        }
        return false;
    }

    /**
     * 删除用户
     *
     * @param username
     * @return
     */
    @Override
    public boolean delete(String username) {
        try {
            connection = DruidUtils.getConn();
            String sql = "delete from test.music_user where username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            return preparedStatement.executeUpdate() == 1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtils.close(connection, preparedStatement, resultSet);
        }
        return false;
    }

    /**
     * 登录
     *
     * @param username
     * @param pwd
     * @return
     */
    @Override
    public User login(String username, String pwd) {
        try {
            connection = DruidUtils.getConn();
            String sql = "select * from test.music_user where username=? and pwd=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pwd);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), username, pwd);
                return user;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * 查找用户
     *
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        try {
            connection = DruidUtils.getConn();
            String sql = "select * from test.music_user where username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), username, resultSet.getString("pwd"));
                return user;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
