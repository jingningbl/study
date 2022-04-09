package com.dao;

import com.pojo.Song;

import java.util.List;

/**
 * @author Administrator
 * @title: SongDao
 * @projectName vip2105
 * @description: TODO
 * @date 2021/11/19 20:42
 */
public interface SongDao {
    //添加
    boolean save(Song s);
    //limit 起始的数据=(pagenum-1)*5,每页显示的行数
    List<Song> findAll(int pageNum, int pageSize);
    //根据id查询歌曲
    Song findSongById(int id);
    //根据一组id查询出歌曲信息
    List<Song> findBySidList(List<Integer> sids);
}
