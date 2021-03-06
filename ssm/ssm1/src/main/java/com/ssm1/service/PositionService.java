package com.ssm1.service;

import com.ssm1.dto.requestDto.PositionListRequestDto;
import com.ssm1.dto.requestDto.TogglePositionStatusRequestDto;
import com.ssm1.entity.Position;
import java.util.List;
import java.util.Map;

/**
 * 职位表(Position)表服务接口
 *
 * @author makejava
 * @since 2022-04-16 19:31:24
 */
public interface PositionService {

    /**
     * 通过ID查询单条数据
     *
     * @param positionId 主键
     * @return 实例对象
     */
    Position queryById(Integer positionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Position> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    Position insert(Position position);

    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    Position update(Position position);

    /**
     * 通过主键删除数据
     *
     * @param positionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer positionId);

    /**
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 查询职位列表
     */
    Map<String, Object> queryPageList(PositionListRequestDto requestDto);

    Map<String, Object> toggleStatus(TogglePositionStatusRequestDto requestDto);

    Map<String, Object> queryActivePositionList();
}
