package com.hong.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author wanghong
 * @date 2020/06/04 11:08
 **/
@Data
public class Response implements Serializable {

    private static final long serialVersionUID = -4317845782629589997L;

    /**
     * 响应码
     */
    private Status status;

    /**
     * 响应头
     */
    private Map<String, String> headers;

    /**
     * 返回值
     */
    private Object returnValue;

    /**
     * 响应异常
     */
    private Exception exception;

    public Response() {
        this(Status.SUCCESS, null);
    }

    public Response(Object returnValue) {
        this(Status.SUCCESS, returnValue);
    }

    public Response(Status status, Object returnValue) {
        this(status, returnValue, null);
    }

    public Response(Status status, Object returnValue, Exception exception) {
        this(status, returnValue, exception, null);
    }

    public Response(Status status, Object returnValue, Exception exception, Map<String, String> headers) {
        this.status = status;
        this.headers = headers;
        this.returnValue = returnValue;
        this.exception = exception;
    }

    public String getHeader(String name) {
        return this.headers == null ? null : this.headers.get(name);
    }

}
