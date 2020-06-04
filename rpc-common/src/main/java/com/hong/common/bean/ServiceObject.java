package com.hong.common.bean;

import lombok.Data;

/**
 * @author wanghong
 * @date 2020/06/04 13:29
 *  服务对象类
 **/
@Data
public class ServiceObject {

    private String name;

    private Class<?> interfaces;

    private Object obj;

    public ServiceObject() {
    }

    public ServiceObject(String name, Class<?> interfaces, Object obj) {
        this.name = name;
        this.interfaces = interfaces;
        this.obj = obj;
    }
}
