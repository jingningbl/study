package com.ssm1.entity;

import java.io.Serializable;

/**
 * 报销单细节表(ExpenseReportDetail)实体类
 *
 * @author makejava
 * @since 2022-04-30 18:55:49
 */
public class ExpenseReportDetail implements Serializable {
    private static final long serialVersionUID = 764034990417008692L;
    /**
    * 报销单细节表id
    */
    private Integer expensiveDetailId;
    /**
    * 报销单id
    */
    private Integer expensiveId;
    /**
    * 报销项目
    */
    private String item;
    /**
    * 费用明细
    */
    private Double amount;
    /**
    * 费用备注
    */
    private String comment;


    public Integer getExpensiveDetailId() {
        return expensiveDetailId;
    }

    public void setExpensiveDetailId(Integer expensiveDetailId) {
        this.expensiveDetailId = expensiveDetailId;
    }

    public Integer getExpensiveId() {
        return expensiveId;
    }

    public void setExpensiveId(Integer expensiveId) {
        this.expensiveId = expensiveId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
