package com.dao;

import com.pojo.User;
import com.util.DBUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator
 * @title: UserDaoImpl
 * @projectName vip2105
 * @description: TODO
 * @date 2021/11/26 20:35
 */
public class UserDaoImpl implements UserDao{
    //连接对象
    Connection conn=null;
    //语句处理
    PreparedStatement ps=null;
    //结果集
    ResultSet rs=null;
    @Override
    public boolean save(User u) {
        return false;
    }

    @Override
    public User login(String username, String pwd) {
        //1.获得连接对象
        try {
            conn= DBUtils.getConn();
            //2.sql
            String sql="select * from test.music_user where username=? and pwd=?";
            //3.获得语句处理对象
            ps=conn.prepareStatement(sql);
            //4.参数赋值
            ps.setString(1,username);
            ps.setString(2,pwd);
            //5.执行获得结果集
            rs=ps.executeQuery();
            //6.判定迭代
            while(rs.next()){
                User u=new User(rs.getInt("id"), username,pwd);
                return u;
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
    public User findByUsername(String username) {
        //1.获得连接对象
        try {
            conn= DBUtils.getConn();
            //2.sql
            String sql="select * from test.music_user where username=?";
            //3.获得语句处理对象
            ps=conn.prepareStatement(sql);
            //4.参数赋值
            ps.setString(1,username);
            //5.执行获得结果集
            rs=ps.executeQuery();
            //6.判定迭代
            while(rs.next()){
                User u=new User(rs.getInt("id"),
                                username,
                                rs.getString("pwd"));
                return u;
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

    /**
     * 修改密码
     * @param username
     * @return
     */
    @Override
    public boolean rePwd(String username,String pwd) {
        try {
            conn=DBUtils.getConn();
            String sql="update test.music_user set pwd=? where username=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,pwd);
            ps.setString(2,username);
            return ps.executeUpdate()>0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,null);
        }
        return false;
    }
}
