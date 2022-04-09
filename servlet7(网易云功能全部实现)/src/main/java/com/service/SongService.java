package com.service;

import com.pojo.Song;

import java.util.List;

/**
 * @author Administrator
 * @title: SongService
 * @projectName vip2105-web
 * @description: TODO
 * @date 2021/12/30 20:32
 */
public interface SongService {
    //根据歌曲单个id查询歌曲信息
    Song findById(int sid);
    //根据歌曲id集合查询歌曲信息
    List<Song> findByIds(List<Integer> ids);
    //添加歌曲
    boolean add(Song s);

}
