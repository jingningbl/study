package com.ssm1.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 操作记录表(DealRecord)实体类
 *
 * @author makejava
 * @since 2022-04-30 18:54:21
 */
public class DealRecord implements Serializable {
    private static final long serialVersionUID = 718311380971442761L;
    /**
    * 操作记录表id
    */
    private Integer recordId;
    /**
    * 报销单id
    */
    private Integer expensiveId;
    /**
    * 操作员工id
    */
    private Integer emId;
    /**
    * 处理方式
    */
    private Date dealTime;
    /**
    * 处理方式
    */
    private String dealWay;
    /**
    * 处理结果
    */
    private String dealResult;
    /**
    * 处理结果备注
    */
    private String comment;


    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getExpensiveId() {
        return expensiveId;
    }

    public void setExpensiveId(Integer expensiveId) {
        this.expensiveId = expensiveId;
    }

    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        this.emId = emId;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
