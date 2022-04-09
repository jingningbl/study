package com.springboot1.service.impl;

import com.springboot1.entity.TeachInfo;
import com.springboot1.dao.TeachInfoDao;
import com.springboot1.service.TeachInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TeachInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-04-02 15:28:40
 */
@Service("teachInfoService")
public class TeachInfoServiceImpl implements TeachInfoService {
    @Resource
    private TeachInfoDao teachInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    @Override
    public TeachInfo queryById(Integer tid) {
        return this.teachInfoDao.queryById(tid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TeachInfo> queryAllByLimit(int offset, int limit) {
        return this.teachInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param teachInfo 实例对象
     * @return 实例对象
     */
    @Override
    public TeachInfo insert(TeachInfo teachInfo) {
        this.teachInfoDao.insert(teachInfo);
        return teachInfo;
    }

    /**
     * 修改数据
     *
     * @param teachInfo 实例对象
     * @return 实例对象
     */
    @Override
    public TeachInfo update(TeachInfo teachInfo) {
        this.teachInfoDao.update(teachInfo);
        return this.queryById(teachInfo.getTid());
    }

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tid) {
        return this.teachInfoDao.deleteById(tid) > 0;
    }
}
