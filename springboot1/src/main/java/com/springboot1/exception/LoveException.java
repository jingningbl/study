package com.springboot1.exception;

import com.springboot1.constants.ErrorConstants;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 17:08
 * @describe
 */
public class LoveException extends BaseException{
    public LoveException() {
        super(ErrorConstants.ErrorCode.LOVE, ErrorConstants.ErrorMsg.LOVE);
    }
}
