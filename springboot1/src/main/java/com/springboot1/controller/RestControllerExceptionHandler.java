package com.springboot1.controller;

import com.springboot1.exception.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 17:45
 * @describe
 */
@RestControllerAdvice(annotations = RestController.class)
public class RestControllerExceptionHandler {
    /**
     * 如果拦截到BaseException
     */
    @ExceptionHandler(BaseException.class)
    public Map<String, Object> baseExceptionHandler(BaseException baseException) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", baseException.getCode());
        result.put("msg", baseException.getMsg());
        return result;
    }

    /**
     * 如果拦截到非BaseException
     */
    @ExceptionHandler(Exception.class)
    public Map<String, Object> otherExceptionHandler(Exception exception) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "99999");
        result.put("msg", "未知异常");
        return result;
    }
}
