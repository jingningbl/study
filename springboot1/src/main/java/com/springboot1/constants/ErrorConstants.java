package com.springboot1.constants;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 16:53
 * @describe 错误信息相关常量
 */
public interface ErrorConstants {
    /**
     * 错误码
     */
    interface ErrorCode {
        int LOVE = 20000;
        int PASSWORD = 40000;
    }

    /**
     * 错误信息
     */
    interface ErrorMsg {
        String LOVE = "爱是一个错";
        String PASSWORD = "密码错误";
    }
}
