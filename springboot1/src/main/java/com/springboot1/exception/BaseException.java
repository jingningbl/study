package com.springboot1.exception;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 17:05
 * @describe
 */
public class BaseException extends RuntimeException{

    private int code;

    private String msg;

    public BaseException() {
    }

    public BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
