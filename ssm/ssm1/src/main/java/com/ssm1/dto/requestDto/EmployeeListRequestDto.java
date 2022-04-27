package com.ssm1.dto.requestDto;

import com.ssm1.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/20 17:48
 * @description: 获取员工列表
 */
@ApiModel(description = "员工列表RequestDto")
public class EmployeeListRequestDto extends PageDto implements Serializable {

    private static final long serialVersionUID = -2146388255206787820L;

    @ApiModelProperty(value = "员工名称",example = " ")
    private String name;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",example = " ")
    private String loginName;
    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id",example = " ")
    private Integer depId;
    /**
     * 职位id
     */
    @ApiModelProperty(value = "职位id",example = " ")
    private Integer positionId;
    /**
     * 状态(0:离职 1:在职)
     */
    @ApiModelProperty(value = "状态(0:离职 1:在职)",example = " ")
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

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
