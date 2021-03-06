package com.tzy777.testssm.dto;

/**
 * @author lipu@csii.com.cn
 * @date 2018/6/28 14:29
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> {
    // 是否成功标志
    private boolean success;
    // 成功时返回的数据
    private T data;
    // 错误信息
    private String error;

    public Result() {
    }

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
