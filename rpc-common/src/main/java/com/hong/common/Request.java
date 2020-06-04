package com.hong.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author wanghong
 * @date 2020/06/04 10:57
 **/
@Data
public class Request implements Serializable {

    private static final long serialVersionUID = -5200571424236772650L;

    /**
     * 请求的服务名称
     */
    private String serviceName;

    /**
     * 请求的服务方法
     */
    private String method;

    /**
     * 请求头
     */
    private Map<String, String> headers;

    /**
     * 请求参数类型
     */
    private Class<?>[] parameterTypes;

    /**
     * 请求参数
     */
    private Object[] parameters;

    public Request() {
    }

    public Request(String serviceName, String method) {
        this(serviceName, method, null, null);
    }

    public Request(String serviceName, String method, Class<?>[] parameterTypes, Object[] parameters) {
        this(serviceName, method, parameterTypes, parameters, null);
    }

    public Request(String serviceName, String method, Class<?>[] parameterTypes, Object[] parameters, Map<String, String> headers) {
        this.serviceName = serviceName;
        this.method = method;
        this.headers = headers;
        this.parameterTypes = parameterTypes;
        this.parameters = parameters;
    }

    public String getHeader(String name) {
        return this.headers == null ? null : this.headers.get(name);
    }
}
