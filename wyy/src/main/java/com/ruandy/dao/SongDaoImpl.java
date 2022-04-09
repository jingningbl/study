package com.ruandy.dao;

import com.ruandy.pojo.Song;
import com.ruandy.util.DBUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @title: SongDaoImpl
 * @projectName vip2105
 * @description: TODO
 * @date 2021/11/19 20:50
 */
public class SongDaoImpl implements SongDao{
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    /**
     * 插入歌曲信息
     * @param s
     * @return
     */
    @Override
    public boolean save(Song s) {
        //1.获得连接
        try {
            conn= DBUtils.getConn();
            //2.sql语句
            //update 表 set name=? where id=?;
            String sql="insert into test.music_song(name, singer, album, style, location, size, uploadTime) " +
                    "VALUES (?,?,?,?,?,?,?)";
            //3.预编译语句处理对象
            ps=conn.prepareStatement(sql);
            //4.参数赋值: 下标值和问号的顺序有关系,问号第几号,下标就是第几,从1开始
            setArrtibute(ps,s);
            //5.执行操作
            return ps.executeUpdate()>0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return false;
    }

    /**
     * 查询全部数据-分页操作
     * @param pageNum  用户输入的页码
     * @param pageSize 用户输入每页的显示数据量
     * @return
     */
    @Override
    public List<Song> findAll(int pageNum, int pageSize) {
        List<Song> list=new ArrayList<>();
        //1.获得连接
        try {
            conn=DBUtils.getConn();
            //2.sql
            String sql="select * from test.music_song limit ?,?";
            //3.语句处理对象
            ps=conn.prepareStatement(sql);
            //4.参数赋值
            ps.setInt(1,(pageNum-1)*pageSize);
            ps.setInt(2,pageSize);
            //5.执行操作,获得结果集
            rs=ps.executeQuery();
            //6.循环--每一行都是Song,多行就是List
            while (rs.next()){
                Song s=rsToSong(rs);
                //放入集合
                list.add(s);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return list;//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    /**
     * 根据id查询歌曲
     * @param id
     * @return
     */
    @Override
    public Song findSongById(int id) {
        //1.获得链接
        try {
            conn=DBUtils.getConn();
            //2.sql语句
            String sql="select * from test.music_song where id=?";
            //3.获得预编译语句对象
            ps=conn.prepareStatement(sql);
            //4.赋值参数
            ps.setInt(1,id);
            //5.执行操作
            rs=ps.executeQuery();
            //6.通过游标判定是否查询出了数据,此处可以使用if判定,因为id不重复
            while(rs.next()){
                return rsToSong(rs);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return null;
    }

    @Override
    public List<Song> findBySidList(List<Integer> sids) {
        List<Song> songs=new ArrayList<>();
        //循环调用单次查询即可
        for (int i = 0; i <sids.size() ; i++) {
            //根据每个id查询出每首歌
            Song s=findSongById(sids.get(i));
            //将歌曲添加到新的集合
            songs.add(s);
        }
        return songs;
    }

    /**
     * 封装结果集--->解析为具体的Java对象
     * @param rs
     * @return
     */
    private Song rsToSong(ResultSet rs) throws SQLException {
        //移动到当前数据行,一次检索出每一列数据
        Song s=new Song();
        //rs.getInt(1);
        //rs.get数据类型("数据库字段名");//返回数据库当前行的列的值
        //将得到的数据 set给Java对象
        int id1=rs.getInt("id");
        s.setId(id1);
        s.setName(rs.getString("name"));
        s.setSinger(rs.getString("singer"));
        s.setAlbum(rs.getString("album"));
        s.setStyle(rs.getString("style"));
        s.setLocation(rs.getString("location"));
        s.setSize(rs.getLong("size"));
        s.setUploadTime(rs.getTimestamp("uploadTime"));
        return s;
    }


    /**
     * 封装参数赋值的操作
     * @param ps
     * @param s
     * @throws SQLException
     */
    private void setArrtibute(PreparedStatement ps, Song s) throws SQLException {
        ps.setString(1,s.getName());
        ps.setString(2,s.getSinger());
        ps.setString(3,s.getAlbum());
        ps.setString(4,s.getStyle());
        ps.setString(5,s.getLocation());
        ps.setLong(6,s.getSize());
        ps.setTimestamp(7,s.getUploadTime());
    }

}
