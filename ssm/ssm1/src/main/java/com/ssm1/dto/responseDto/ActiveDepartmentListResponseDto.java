package com.ssm1.dto.responseDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/27 14:27
 * @description:
 */
@ApiModel(value = "ActiveDepartmentListResponseDto", description = "有效部门下拉列表responseDto")
public class ActiveDepartmentListResponseDto implements Serializable {

    private static final long serialVersionUID = 5864420226578771717L;

    @ApiModelProperty(value = "部门id", example = "")
    private Integer depId;


    @ApiModelProperty(value = "部门名称", example = "")
    private String name;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
