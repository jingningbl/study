package com.dao;

import com.pojo.Song;
import com.pojo.Us;
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
 * @date 2021/12/7 15:41
 * @describe
 */
public class SongDaoImpl implements SongDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public boolean save(Song song) {
        try {
            connection = DBUtils.getConn();
            String sql = "insert into test.music_song(name, singer, album, style, location, size, uploadTime) values (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            setArr(preparedStatement, song);
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

    private void setArr(PreparedStatement preparedStatement, Song song) throws SQLException {
        preparedStatement.setString(1, song.getName());
        preparedStatement.setString(2, song.getSinger());
        preparedStatement.setString(3, song.getAlbum());
        preparedStatement.setString(4, song.getStyle());
        preparedStatement.setString(5, song.getLocation());
        preparedStatement.setLong(6, song.getSize());
        preparedStatement.setTimestamp(7, song.getUploadTime());
    }

    @Override
    public boolean delete(int id) {
        try {
            connection = DBUtils.getConn();
            String sql = "delete from test.music_song where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
    public Song findSongById(int id) {
        try {
            connection = DBUtils.getConn();
            String sql = "select * from test.music_song where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Song song = setParameter(resultSet);
                return song;
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

    private Song setParameter(ResultSet resultSet) throws SQLException {
        Song song = new Song();
        song.setId(resultSet.getInt("id"));
        song.setName(resultSet.getString("name"));
        song.setSinger(resultSet.getString("singer"));
        song.setAlbum(resultSet.getString("album"));
        song.setStyle(resultSet.getString("style"));
        song.setLocation(resultSet.getString("location"));
        song.setSize(resultSet.getLong("size"));
        song.setUploadTime(resultSet.getTimestamp("uploadTime"));
        return song;
    }

    @Override
    public List<Song> findSongsAll(int pageNum, int pageSize) {
        List<Song> list = new ArrayList<>();
        try {
            connection = DBUtils.getConn();
            String sql = "select * from test.music_song limit ?,?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (pageNum - 1) * pageSize);
            preparedStatement.setInt(2, pageSize);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Song song = setParameter(resultSet);
                list.add(song);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    @Override
    public List<Song> findSongsSids(List<Integer> sids) {
        List<Song> list = new ArrayList<>();
        for (int i = 0; i < sids.size(); i++) {
            list.add(findSongById(sids.get(i)));
        }
        return list;
    }
}
