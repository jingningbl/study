package com.mybatis.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.pojo
 * @date 2022/3/11 12:13
 * @describe
 */
public class StuCard {
    private int cid;
    private String balance;

    public StuCard() {
    }

    public StuCard(int cid, String balance) {
        this.cid = cid;
        this.balance = balance;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "StuCard{" +
                "cid=" + cid +
                ", balance='" + balance + '\'' +
                '}';
    }
}
