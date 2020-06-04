package com.hong.common.discoverer;

import com.hong.common.bean.ServiceInfo;

import java.util.List;

/**
 * @author wanghong
 * @date 2020/06/04 14:00
 **/
public interface ServiceDiscoverer {
    /**
     * 获取指定服务名称下的所有可用服务
     * @param name
     * @return
     */
    List<ServiceInfo> getServiceInfo(String name);

}
