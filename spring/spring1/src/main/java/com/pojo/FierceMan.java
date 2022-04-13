package com.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/5 12:23
 * @describe
 */
public class FierceMan {
    private String[] clothes;
//    private List<Woman> womanList;
    private Map<String,Object> womanList;
//    数据库信息
    private Properties properties;

    public String[] getClothes() {
        return clothes;
    }

    public void setClothes(String[] clothes) {
        this.clothes = clothes;
    }

    public Map<String, Object> getWomanList() {
        return womanList;
    }

    public void setWomanList(Map<String, Object> womanList) {
        this.womanList = womanList;
    }

    //    public List<Woman> getWomanList() {
//        return womanList;
//    }
//
//    public void setWomanList(List<Woman> womanList) {
//        this.womanList = womanList;
//    }


    @Override
    public String toString() {
        return "FierceMan{" +
                "clothes=" + Arrays.toString(clothes) +
                ", womanList=" + womanList +
                ", properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
