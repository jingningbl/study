package com.ssm1.dto.responseDto;

import com.ssm1.entity.Department;
import com.ssm1.entity.Position;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/16 18:55
 * @description:
 */
@ApiModel(description = "用户信息Dto")
public class EmployeeDto implements Serializable {

    private static final long serialVersionUID = 1294999567910766240L;
    /**
     * 员工id
     */
    @ApiModelProperty(value = "主键id")
    private Integer emId;
    /**
     * 密码
     */
//    private String password;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String loginName;
    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Integer depId;
    /**
     * 职位id
     */
    @ApiModelProperty(value = "职位id")
    private Integer positionId;
    /**
     * 状态(0:离职 1:在职)
     */
    @ApiModelProperty(value = "状态(0:离职 1:在职)")
    private Integer status;
    /**
     * 一对一关联部门表
     */
    @ApiModelProperty(value = "部门表")
    private Department department;
    /**
     * @description:一对一关联职位表
     */
    @ApiModelProperty(value = "职位表")
    private Position position;

    public EmployeeDto() {
    }

    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        this.emId = emId;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

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
