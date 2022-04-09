package com.springboot1.dao;

import com.springboot1.entity.TeachInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TeachInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-02 15:28:40
 */
public interface TeachInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    TeachInfo queryById(Integer tid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TeachInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param teachInfo 实例对象
     * @return 对象列表
     */
    List<TeachInfo> queryAll(TeachInfo teachInfo);

    /**
     * 新增数据
     *
     * @param teachInfo 实例对象
     * @return 影响行数
     */
    int insert(TeachInfo teachInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TeachInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TeachInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TeachInfo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TeachInfo> entities);

    /**
     * 修改数据
     *
     * @param teachInfo 实例对象
     * @return 影响行数
     */
    int update(TeachInfo teachInfo);

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 影响行数
     */
    int deleteById(Integer tid);

}

