package com.ruandy.service;



import com.ruandy.dao.USDao;
import com.ruandy.dao.USDaoImpl;

import java.util.List;

/**
 * @author Administrator
 * @title: USServiceImpl
 * @projectName vip2105-web
 * @description: TODO
 * @date 2021/12/30 20:27
 */
public class USServiceImpl implements USService{
    //业务层依赖于dao层
    USDao usDao=new USDaoImpl();
    @Override
    public List<Integer> getSongIdsByUid(int uid) {
        List<Integer> list=usDao.findByUid(uid);
        return list;
    }

    @Override
    public boolean delete(int uid, int sid) {
        return usDao.delete(uid,sid);
    }
}
