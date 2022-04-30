package com.ssm1.service;

import com.ssm1.dto.requestDto.EmployeeListRequestDto;
import com.ssm1.dto.requestDto.ToggleEmployeeStatusRequestDto;
import com.ssm1.dto.responseDto.EmployeeDto;
import com.ssm1.dto.responseDto.EmployeeResponseDto;
import com.ssm1.entity.Employee;
import java.util.List;
import java.util.Map;

/**
 * 员工表(Employee)表服务接口
 *
 * @author makejava
 * @since 2022-04-26 15:01:37
 */
public interface EmployeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param emId 主键
     * @return 实例对象
     */
    EmployeeResponseDto queryById(Integer emId) throws Exception;

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Employee> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    EmployeeResponseDto update(Employee employee) throws Exception;

    /**
     * 通过主键删除数据
     *
     * @param emId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer emId);

    EmployeeDto getEmInfoByUsernameAndPassword(String username, String password);

    Map<String, Object> queryPageList(EmployeeListRequestDto requestDto);

    Map<String, Object> toggleStatus(ToggleEmployeeStatusRequestDto requestDto);
}
