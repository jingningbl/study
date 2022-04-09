package com.springboot1.service;

import com.springboot1.entity.TeachInfo;
import java.util.List;

/**
 * (TeachInfo)表服务接口
 *
 * @author makejava
 * @since 2022-04-02 15:28:40
 */
public interface TeachInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    TeachInfo queryById(Integer tid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TeachInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param teachInfo 实例对象
     * @return 实例对象
     */
    TeachInfo insert(TeachInfo teachInfo);

    /**
     * 修改数据
     *
     * @param teachInfo 实例对象
     * @return 实例对象
     */
    TeachInfo update(TeachInfo teachInfo);

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tid);

}
