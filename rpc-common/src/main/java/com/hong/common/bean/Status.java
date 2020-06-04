package com.hong.common.bean;

/**
 * @author wanghong
 * @date 2020/06/04 11:07
 * 响应状态码枚举
 **/
public enum Status {
    SUCCESS(200, "SUCCESS"), ERROR(500, "ERROR"), NOT_FOUND(404, "NOT FOUND");

    private int code;

    private String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
