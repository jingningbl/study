package com.dao;


import com.pojo.Song;

import java.util.List;

public interface SongDao {
    //    添加
    boolean save(Song song);

    //    删除
    boolean delete(int id);

    //    查询全部
    List<Song> findAll(int pageNum, int pageSize);

    //    根据一组id查询歌曲
    List<Song> findBySids(List<Integer> sids);

    //    根据id查询
    Song findSongById(int id);
//    更新
    boolean update(Song song);
}
