package com.dao;

import java.util.List;

public interface UsDao {
    //    给用户添加歌曲
    boolean save(int userId, int songId);

    //    删除歌曲
    boolean delete(int userId, int songId);

    //    根据用户id得到歌曲id集合
    List<Integer> findByUid(int id);
}
