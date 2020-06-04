package com.hong.common.client;

import com.hong.common.bean.ServiceInfo;

/**
 * @author wanghong
 * @date 2020/06/04 14:18
 **/
public interface NetClient {
    byte[] sendRequest(byte[] data, ServiceInfo sinfo) throws Throwable;
}
