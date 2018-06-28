package com.tzy777.testssm.exception;

/**
 * @author lipu@csii.com.cn
 * @date 2018/6/28 11:55
 * 库存不足异常
 */
public class NoNumberException extends RuntimeException {

    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
