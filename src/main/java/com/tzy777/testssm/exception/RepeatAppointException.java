package com.tzy777.testssm.exception;

/**
 * @author lipu@csii.com.cn
 * @date 2018/6/28 11:55
 * 重复预约异常
 */
public class RepeatAppointException extends RuntimeException {

    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
