package com.hong.common.register;

import com.hong.common.bean.ServiceObject;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanghong
 * @date 2020/06/04 13:33
 * 基于本地内存实现的默认服务注册中心
 **/
public class DefaultServiceRegister implements ServiceRegister {

    private Map<String, ServiceObject> serviceMap = new HashMap<>();

    @Override
    public void register(ServiceObject so, String protocolName, int port) throws UnknownHostException {
        if (so == null) {
            throw new IllegalArgumentException("参数不能为空");
        }

        this.serviceMap.put(so.getName(), so);
    }

    @Override
    public ServiceObject getServiceObject(String name) {
        return this.serviceMap.get(name);
    }

}
