package com.service;

import com.dao.SongDao;
import com.dao.SongDaoImpl;
import com.pojo.Song;

import java.util.List;

/**
 * @author Administrator
 * @title: SongServiceImpl
 * @projectName vip2105-web
 * @description: TODO
 * @date 2021/12/30 20:34
 */
public class SongServiceImpl implements SongService{
    //依赖具体JDBC中SongDao模块
    SongDao songDao=new SongDaoImpl();
    @Override
    public Song findById(int sid) {
        Song s=songDao.findSongById(sid);
        return s;
    }

    @Override
    public List<Song> findByIds(List<Integer> ids) {
        List<Song> list=songDao.findBySidList(ids);
        return list;
    }

    @Override
    public boolean add(Song s) {
        return songDao.save(s);
    }
}
