package com.ssm1.dto.requestDto;

import com.ssm1.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/20 17:48
 * @description: 获取职位列表
 */
@ApiModel(description = "职位列表RequestDto")
public class PositionListRequestDto extends PageDto implements Serializable {

    private static final long serialVersionUID = 2127582074981441652L;

    @ApiModelProperty(value = "职位名称",example = " ")
    private String positionName;

    @ApiModelProperty(value = "状态:1有效,2无效",example = " ")
    private Integer status;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
