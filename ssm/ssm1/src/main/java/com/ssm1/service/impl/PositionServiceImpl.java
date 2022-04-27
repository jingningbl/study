package com.ssm1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm1.dto.requestDto.DepartmentListRequestDto;
import com.ssm1.dto.requestDto.PositionListRequestDto;
import com.ssm1.dto.requestDto.TogglePositionStatusRequestDto;
import com.ssm1.dto.responseDto.ActiveDepartmentListResponseDto;
import com.ssm1.dto.responseDto.ActivePositionListResponseDto;
import com.ssm1.dto.responseDto.DepartmentListResponseDto;
import com.ssm1.dto.responseDto.PositionListResponseDto;
import com.ssm1.entity.Position;
import com.ssm1.dao.PositionDao;
import com.ssm1.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 职位表(Position)表服务实现类
 *
 * @author makejava
 * @since 2022-04-16 19:31:24
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param positionId 主键
     * @return 实例对象
     */
    @Override
    public Position queryById(Integer positionId) {
        return this.positionDao.queryById(positionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Position> queryAllByLimit(int offset, int limit) {
        return this.positionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    @Override
    public Position insert(Position position) {
//        position.setCreateTime(new Date());
        this.positionDao.insert(position);
        return position;
    }

    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    @Override
    public Position update(Position position) {
        this.positionDao.update(position);
        return this.queryById(position.getPositionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param positionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer positionId) {
        return this.positionDao.deleteById(positionId) > 0;
    }

    /**
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 查询部门列表, 单纯查询, 不需要事物声明
     */
    @Override
    public Map<String, Object> queryPageList(PositionListRequestDto requestDto) {
        Map<String, Object> map = new HashMap<>();
        try {
//            List<DepartmentListResponseDto> departmentListResponseDto = departmentDao.queryPageList(departmentListRequestDto);
            //封装查询条件
            QueryWrapper<PositionListRequestDto> wrapper = new QueryWrapper<>();
            if (requestDto.getPositionName() != null) {
                wrapper.like("position_name", requestDto.getPositionName());
            }
            if (requestDto.getStatus() != null) {
                wrapper.eq("status", requestDto.getStatus());
            }
            Page<PositionListRequestDto> page = new Page<>(requestDto.getCurrent(), requestDto.getSize());
            IPage<PositionListResponseDto> position = positionDao.queryPageList(page, wrapper);

            map.put("success", true);
            map.put("data", position);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            //如果用到Spring的事物声明,则需要的catch中捕获后抛出,否则事物失效
        }
        return map;
    }

    @Override
    public Map<String, Object> toggleStatus(TogglePositionStatusRequestDto requestDto) {
        Map<String, Object> map = new HashMap<>();
        /**
         * 该部门当前状态
         */
        Integer status = requestDto.getStatus();
        Integer positionId = requestDto.getPositionId();
        try {
            if (status == 1) {
                //状态禁用
                positionDao.updateFailureStatusById(positionId);
            } else {
                //状态启用
                positionDao.updateSuccessStatusById(positionId);
            }
            map.put("success", true);
        } catch (Exception e) {
            //使用了声明式事物,必须要将异常抛出,否则事物失效
            throw e;
        }
        return map;
    }

    @Override
    public Map<String, Object> queryActivePositionList() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<ActivePositionListResponseDto> position = positionDao.queryActivePositionList();
            map.put("success", true);
            map.put("data", position);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }
}
