package com.ssm1.dto.requestDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/21 18:40
 * @description:
 */
@ApiModel(description = "切换职位状态requestDto")
public class TogglePositionStatusRequestDto implements Serializable {

    private static final long serialVersionUID = 8615300495672019129L;

    @ApiModelProperty(value = "职位id",example = " ")
    private Integer positionId;

    @ApiModelProperty(value = "职位状态,1有效0无效",example = " ")
    private Integer status;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
