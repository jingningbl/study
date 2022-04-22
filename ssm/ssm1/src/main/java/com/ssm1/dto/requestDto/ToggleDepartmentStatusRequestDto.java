package com.ssm1.dto.requestDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/21 18:40
 * @description:
 */
@ApiModel(description = "切换部门状态requestDto")
public class ToggleDepartmentStatusRequestDto implements Serializable {

    private static final long serialVersionUID = 303713464206086127L;

    @ApiModelProperty(value = "部门id",example = " ")
    private Integer depId;

    @ApiModelProperty(value = "部门状态,1有效0无效",example = " ")
    private Integer status;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
