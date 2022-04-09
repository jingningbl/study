package com.dao;



import com.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @title: USServiceImpl
 * @projectName vip2105
 * @description: TODO
 * @date 2021/11/26 21:54
 */
public class USDaoImpl implements USDao{
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    @Override
    public List<Integer> findByUid(int uid) {
        List<Integer> sids=new ArrayList<>();
        try {
            conn= DBUtils.getConn();
            String sql="select sid from test.music_user_song where uid=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,uid);
            rs=ps.executeQuery();
            //迭代
            while(rs.next()){
                sids.add(rs.getInt("sid"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return sids;
    }

    @Override
    public boolean delete(int uid, int sid) {
        try {
            conn=DBUtils.getConn();
            String sql="delete from test.music_user_song where uid=? and sid=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,uid);
            ps.setInt(2,sid);
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
}
