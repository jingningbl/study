package com.ssm1.dto.requestDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/20 17:48
 * @description: 获取部门列表
 */
@ApiModel(description = "部门列表RequestDto")
public class DepartmentListRequestDto implements Serializable {

    private static final long serialVersionUID = 7597479925937532259L;

    @ApiModelProperty(value = "部门名称",example = " ")
    private String name;

    @ApiModelProperty(value = "部门地址",example = " ")
    private String address;

    @ApiModelProperty(value = "状态:1有效,2无效",example = " ")
    private Integer status;

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
