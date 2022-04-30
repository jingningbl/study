package com.ssm1.dto.requestDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/30 11:18
 * @description:
 */
@ApiModel(value = "ToggleEmployeeStatusRequestDto", description = "切换员工状态requestDto")
public class ToggleEmployeeStatusRequestDto implements Serializable {

    private static final long serialVersionUID = -3313763869811708079L;

    @ApiModelProperty(value = "员工id", example = "")
    private Integer emId;

    @ApiModelProperty(value = "状态(0:离职 1:在职)", example = "")
    private Integer status;

    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        this.emId = emId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
