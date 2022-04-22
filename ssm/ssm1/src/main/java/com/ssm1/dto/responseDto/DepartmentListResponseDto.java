package com.ssm1.dto.responseDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/20 18:19
 * @description: 部门列表responseDto
 */
@ApiModel(description = "部门列表responseDto")
public class DepartmentListResponseDto implements Serializable {

    private static final long serialVersionUID = 4877964807647441140L;

    @ApiModelProperty(value = "部门id",example = " ")
    private Integer depId;

    @ApiModelProperty(value = "部门名称",example = " ")
    private String name;

    @ApiModelProperty(value = "部门地址",example = " ")
    private String address;

    @ApiModelProperty(value = "状态:1有效,2无效",example = " ")
    private Integer status;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
