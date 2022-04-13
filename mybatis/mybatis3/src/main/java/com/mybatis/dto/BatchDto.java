package com.mybatis.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.dto
 * @date 2022/3/18 13:37
 * @describe 批量新增Dto对象
 */
public class BatchDto implements Serializable {
    private static final long serialVersionUID = 7406460867469341034L;
    private int[] aaa;
    private List<Integer> bbb;

    public int[] getAaa() {
        return aaa;
    }

    public void setAaa(int[] aaa) {
        this.aaa = aaa;
    }

    public List<Integer> getBbb() {
        return bbb;
    }

    public void setBbb(List<Integer> bbb) {
        this.bbb = bbb;
    }
}
