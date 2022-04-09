package com.dao;

import com.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:Administrator
 * @data:2021/11/27
 * @description:
 */
public class UsDaoImpl implements UsDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * 给用户添加歌曲
     *
     * @param userId
     * @param songId
     * @return
     */
    @Override
    public boolean save(int userId, int songId) {
        try {
            connection = DruidUtils.getConn();
            String sql = "insert into test.music_user_song(uid, sid) values (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, songId);
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
     * 用户删除歌曲
     *
     * @param userId
     * @param songId
     * @return
     */
    @Override
    public boolean delete(int userId, int songId) {
        try {
            connection = DruidUtils.getConn();
            String sql = "delete from test.music_user_song where uid=? and sid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, songId);
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
     * 查询用户的搜有歌曲id
     *
     * @param uid
     * @return
     */
    @Override
    public List<Integer> findByUid(int uid) {
        List<Integer> list = new ArrayList<>();
        try {
            connection = DruidUtils.getConn();
            String sql = "select sid from test.music_user_song where uid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, uid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getInt("sid"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtils.close(connection, preparedStatement, resultSet);
        }
        return list;
    }
}
