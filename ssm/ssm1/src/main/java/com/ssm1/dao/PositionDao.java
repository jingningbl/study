package com.ssm1.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm1.dto.requestDto.PositionListRequestDto;
import com.ssm1.dto.responseDto.ActivePositionListResponseDto;
import com.ssm1.dto.responseDto.PositionListResponseDto;
import com.ssm1.entity.Position;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 职位表(Position)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-16 19:31:24
 */
public interface PositionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param positionId 主键
     * @return 实例对象
     */
    Position queryById(Integer positionId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Position> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param position 实例对象
     * @return 对象列表
     */
    List<Position> queryAll(Position position);

    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 影响行数
     */
    int insert(Position position);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Position> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Position> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Position> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Position> entities);

    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 影响行数
     */
    int update(Position position);

    /**
     * 通过主键删除数据
     *
     * @param positionId 主键
     * @return 影响行数
     */
    int deleteById(Integer positionId);

    IPage<PositionListResponseDto> queryPageList(
            Page<PositionListRequestDto> page,
            @Param(Constants.WRAPPER)QueryWrapper<PositionListRequestDto> wrapper);

    void updateFailureStatusById(Integer positionId);

    void updateSuccessStatusById(Integer positionId);

    List<ActivePositionListResponseDto> queryActivePositionList();
}

