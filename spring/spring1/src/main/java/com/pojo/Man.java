package com.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/4 11:38
 * @describe
 */
public class Man {
    private String name;
    //    资产
    private String fund;
    //    心动女生
    private Woman woman;

    /**
     * 示爱
     *
     * @return
     */
    public void proposal() {
        System.out.println("这名拥有" + fund + "资产的名字叫" + name + "的男嘉宾向年级为" + woman.getAge() + woman.getOutlook() + woman.getName() + "示爱了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public Woman getWoman() {
        return woman;
    }

    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", fund='" + fund + '\'' +
                ", woman=" + woman +
                '}';
    }
    public void myDestroy(){
        System.out.println("destroy-method自定义销毁");
    }
}
