package com.mybatis.dto;

import java.io.Serializable;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.dto
 * @date 2022/3/16 13:45
 * @describe
 */
public class BetweenDto implements Serializable {
    private static final long serialVersionUID = 1256785050452281195L;
    private Integer min;
    private Integer max;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
