package com.ssm1.dto.responseDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/27 17:11
 * @description:
 */
@ApiModel(value = "ActivePositionListResponseDto", description = "有效职位下拉列表responseDto")
public class ActivePositionListResponseDto implements Serializable {

    private static final long serialVersionUID = -4530043098492744077L;

    @ApiModelProperty(value = "职位id", example = "")
    private Integer positionId;

    @ApiModelProperty(value = "职位名称", example = "")
    private String positionName;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
