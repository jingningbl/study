package com.dao;

import com.pojo.User;
import com.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bai
 * @version V1.0
 * @Package com.dao
 * @date 2021/12/7 14:15
 * @describe
 */
public class UserDaoImpl implements UserDao {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Override
    public boolean save(User user) {
        try {
            connection = DBUtils.getConn();
            String sql = "insert into test.music_user(username, pwd) values (?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPwd());
            return preparedStatement.executeUpdate() == 1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, preparedStatement, resultSet);
        }
        return false;
    }

    @Override
    public boolean delete(String username) {
        try {
            connection = DBUtils.getConn();
            String sql = "delete from test.music_user where username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            return preparedStatement.executeUpdate() == 1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, preparedStatement, resultSet);
        }
        return false;
    }

    @Override
    public User findUsername(String username) {
        try {
            connection = DBUtils.getConn();
            String sql = "select * from test.music_user where username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"), resultSet.getString("pwd"));
                return user;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public User login(String username, String pwd) {
        try {
            connection = DBUtils.getConn();
            String sql = "select * from test.music_user where username=? and pwd=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pwd);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"), resultSet.getString("pwd"));
                return user;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
