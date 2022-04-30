package com.ssm1.dto.responseDto;

import com.ssm1.entity.Employee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author: bai
 * @date: 2022/4/20 18:19
 * @description: 职位列表responseDto
 */
@ApiModel(value = "EmployeeResponseDto", description = "员工信息responseDto")
public class EmployeeResponseDto implements Serializable {

    private static final long serialVersionUID = 5163684159275206029L;

    @ApiModelProperty(value = "员工信息", example = "")
    private Employee employee;

    @ApiModelProperty(value = "有效职位", example = "")
    private List<ActivePositionListResponseDto> positionList;

    @ApiModelProperty(value = "有效部门", example = "")
    private List<ActiveDepartmentListResponseDto> departmentList;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<ActivePositionListResponseDto> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<ActivePositionListResponseDto> positionList) {
        this.positionList = positionList;
    }

    public List<ActiveDepartmentListResponseDto> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<ActiveDepartmentListResponseDto> departmentList) {
        this.departmentList = departmentList;
    }
}
