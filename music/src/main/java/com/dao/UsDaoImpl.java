package com.dao;

import com.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.dao
 * @date 2021/12/7 15:45
 * @describe
 */
public class UsDaoImpl implements UsDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public boolean save(int uid, int sid) {
        try {
            connection = DBUtils.getConn();
            String sql = "insert into test.music_user_song(uid, sid) values (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, uid);
            preparedStatement.setInt(2, sid);
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
    public boolean delete(int uid, int sid) {
        try {
            connection = DBUtils.getConn();
            String sql = "delete from test.music_user_song where uid=? and sid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, uid);
            preparedStatement.setInt(2, sid);
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
    public List<Integer> findSongsAll(int uid) {
        List<Integer> sids = new ArrayList<>();
        try {
            connection = DBUtils.getConn();
            String sql = "select sid from test.music_user_song where uid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, uid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sids.add(resultSet.getInt("sid"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sids;
    }
}
