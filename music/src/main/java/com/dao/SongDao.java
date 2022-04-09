package com.dao;

import com.pojo.Song;
import com.pojo.Us;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.dao
 * @date 2021/12/7 15:39
 * @describe
 */
public interface SongDao {
    boolean save(Song song);

    boolean delete(int id);

    Song findSongById(int id);

    List<Song> findSongsAll(int pageNum, int pageSize);

    List<Song> findSongsSids(List<Integer> sids);
}
