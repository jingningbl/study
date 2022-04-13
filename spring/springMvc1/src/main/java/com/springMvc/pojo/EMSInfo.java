package com.springMvc.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.pojo
 * @date 2022/2/28 12:35
 * @describe
 */
public class EMSInfo {
    private String address;
    private String mobile;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "EMSInfo{" +
                "address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
