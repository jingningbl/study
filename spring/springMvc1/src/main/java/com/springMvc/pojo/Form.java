package com.springMvc.pojo;

import java.util.Arrays;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.pojo
 * @date 2022/2/28 12:18
 * @describe
 */
public class Form {
    private String username;
    private String goddess;
//    private Integer[] reason;
    private List<Integer> reason;
    private EMSInfo emsInfo;

    public EMSInfo getEmsInfo() {
        return emsInfo;
    }

    public void setEmsInfo(EMSInfo emsInfo) {
        this.emsInfo = emsInfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGoddess() {
        return goddess;
    }

    public void setGoddess(String goddess) {
        this.goddess = goddess;
    }

//    public Integer[] getReason() {
//        return reason;
//    }
//
//    public void setReason(Integer[] reason) {
//        this.reason = reason;
//    }

//    @Override
//    public String toString() {
//        return "Form{" +
//                "username='" + username + '\'' +
//                ", goddess='" + goddess + '\'' +
//                ", reason=" + Arrays.toString(reason) +
//                '}';
//    }

    public List<Integer> getReason() {
        return reason;
    }

    public void setReason(List<Integer> reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Form{" +
                "username='" + username + '\'' +
                ", goddess='" + goddess + '\'' +
                ", reason=" + reason +
                ", emsInfo=" + emsInfo +
                '}';
    }
}
