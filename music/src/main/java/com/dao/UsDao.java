package com.dao;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.dao
 * @date 2021/12/7 15:42
 * @describe
 */
public interface UsDao {
    boolean save(int uid, int sid);

    boolean delete(int uid, int sid);

    List<Integer> findSongsAll(int uid);
}
