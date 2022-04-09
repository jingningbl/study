package com.service;

import com.dao.USDao;
import com.dao.USDaoImpl;

import java.util.List;

/**
 * @author Administrator
 * @title: USService
 * @projectName vip2105-web
 * @description: TODO
 * @date 2021/12/30 20:24
 */
public interface USService {

    //根据用户id访问数据库JDBC获得歌曲id集合
    List<Integer> getSongIdsByUid(int uid);
    //删除用户关联的歌曲信息-歌曲本身并没有删掉
    boolean delete(int uid,int sid);
}
