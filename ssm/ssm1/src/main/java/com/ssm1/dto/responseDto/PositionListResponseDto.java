package com.ssm1.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: bai
 * @date: 2022/4/20 18:19
 * @description: 职位列表responseDto
 */
@ApiModel(description = "职位列表responseDto")
public class PositionListResponseDto implements Serializable {

    private static final long serialVersionUID = 7185961849591629452L;

    @ApiModelProperty(value = "职位id",example = " ")
    private Integer positionId;

    @ApiModelProperty(value = "职位名称",example = " ")
    private String positionName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "职位地址",example = " ")
    private Date createTime;

    @ApiModelProperty(value = "状态:1有效,2无效",example = " ")
    private Integer status;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
