package com.mybatis.pojo;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.pojo
 * @date 2022/3/11 13:08
 * @describe
 */
public class StuClass {
    private Integer cid;
    private String cname;
    private Integer sum;
    private List<StuInfo> stuInfoList;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public List<StuInfo> getStuInfoList() {
        return stuInfoList;
    }

    public void setStuInfoList(List<StuInfo> stuInfoList) {
        this.stuInfoList = stuInfoList;
    }

    @Override
    public String toString() {
        return "StuClass{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", sum=" + sum +
                ", stuInfoList=" + stuInfoList +
                '}';
    }
}
