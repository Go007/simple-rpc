package com.hong.common.register;

import com.hong.common.bean.ServiceObject;

import java.net.UnknownHostException;

/**
 * @author wanghong
 * @date 2020/06/04 13:31
 * 服务注册中心
 **/
public interface ServiceRegister {

    void register(ServiceObject so, String protocol, int port) throws UnknownHostException;

    ServiceObject getServiceObject(String name);
}
