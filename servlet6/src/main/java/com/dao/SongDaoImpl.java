package com.dao;

import com.pojo.Song;
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
public class SongDaoImpl implements SongDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * 增加歌曲
     *
     * @param song
     * @return
     */
    @Override
    public boolean save(Song song) {
        try {
//            连接数据库
            connection = DruidUtils.getConn();
//            sql语句
            String sql = "insert into test.music_song(name, singer, album, style, location, size, uploadTime) values (?,?,?,?,?,?,?)";
//            语句处理对象
            preparedStatement = connection.prepareStatement(sql);
//            调用函数赋值
            setArr(preparedStatement, song);
//            执行
            return preparedStatement.executeUpdate() == 1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭
            DruidUtils.close(connection, preparedStatement, resultSet);
        }
        return false;
    }

    /**
     * 封装赋值函数
     *
     * @param preparedStatement
     * @param song
     * @throws SQLException
     */
    private void setArr(PreparedStatement preparedStatement, Song song) throws SQLException {
        preparedStatement.setString(1, song.getName());
        preparedStatement.setString(2, song.getSinger());
        preparedStatement.setString(3, song.getAlbum());
        preparedStatement.setString(4, song.getStyle());
        preparedStatement.setString(5, song.getLocation());
        preparedStatement.setLong(6, song.getSize());
        preparedStatement.setTimestamp(7, song.getUploadTime());
    }

    /**
     * 删除歌曲
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        try {
            connection = DruidUtils.getConn();
            String sql = "delete from test.music_song where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
     * 查询全部歌曲
     *
     * @param pageNum  页码
     * @param pageSize 行数
     * @return 歌曲集合
     */
    @Override
    public List<Song> findAll(int pageNum, int pageSize) {
        List<Song> list = new ArrayList<>();
        try {
            connection = DruidUtils.getConn();
            String sql = "select * from test.music_song limit ?,?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (pageNum - 1) * pageSize);
            preparedStatement.setInt(2, pageSize);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                调用函数得到每首歌
                Song song = reToSong(resultSet);
//                将其添加到集合中
                list.add(song);
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

    /**
     * 根据一组id查询歌曲
     *
     * @param sids 一组id
     * @return 歌曲集合
     */
    @Override
    public List<Song> findBySids(List<Integer> sids) {
        List<Song> songs = new ArrayList<>();
//        遍历一组id
        for (int i = 0; i < sids.size(); i++) {
//            调用函数得到对应的歌曲
            Song song = findSongById(sids.get(i));
//            添加到集合中
            songs.add(song);
        }
        return songs;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return song
     */
    @Override
    public Song findSongById(int id) {
        try {
            connection = DruidUtils.getConn();
            String sql = "select * from test.music_song where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return reToSong(resultSet);
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

    @Override
    public boolean update(Song song) {
        try {
            connection=DruidUtils.getConn();
            String sql="update test.music_song set name=?,singer=?,album=?,style=?,location=?,size=?,uploadTime=? where id=?";
            preparedStatement=connection.prepareStatement(sql);
            setParmter(preparedStatement,song);
            return preparedStatement.executeUpdate()==1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(connection,preparedStatement,resultSet);
        }
        return false;
    }

    private void setParmter(PreparedStatement preparedStatement, Song song) throws SQLException {
        preparedStatement.setString(1,song.getName());
        preparedStatement.setString(2,song.getSinger());
        preparedStatement.setString(3, song.getAlbum());
        preparedStatement.setString(4, song.getStyle());
        preparedStatement.setString(5, song.getLocation());
        preparedStatement.setLong(6,song.getSize());
        preparedStatement.setTimestamp(7,song.getUploadTime());
        preparedStatement.setInt(8,song.getId());
    }

    /**
     * 封装获取结果集数据的函数
     *
     * @return
     * @throws SQLException
     */
    private Song reToSong(ResultSet resultSet) throws SQLException {
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
}
