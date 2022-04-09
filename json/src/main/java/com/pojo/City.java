package com.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/1/2 9:24
 * @describe
 */
public class City {
    private String cityName;
    private String cityValue;

    public City() {
    }

    public City(String cityName, String cityValue) {
        this.cityName = cityName;
        this.cityValue = cityValue;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", cityValue='" + cityValue + '\'' +
                '}';
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityValue() {
        return cityValue;
    }

    public void setCityValue(String cityValue) {
        this.cityValue = cityValue;
    }
}
