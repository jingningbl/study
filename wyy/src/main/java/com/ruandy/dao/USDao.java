package com.ruandy.dao;

import java.util.List;

/**
 * @author Administrator
 * @title: USDao
 * @projectName vip2105
 * @description: TODO
 * @date 2021/11/26 21:52
 */
public interface USDao {
    //根据当前的用户id查询出歌曲id
    //一个用户可能对应多个歌曲,所以这是一个1对多的关系
    List<Integer> findByUid(int uid);
    //添加
    //删除
    boolean delete(int uid,int sid);
    //更新
}
