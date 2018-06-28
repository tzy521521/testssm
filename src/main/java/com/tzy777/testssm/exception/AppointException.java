package com.tzy777.testssm.exception;

/**
 * @author lipu@csii.com.cn
 * @date 2018/6/28 11:55
 * 预约业务异常
 */
public class AppointException extends RuntimeException {

    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
