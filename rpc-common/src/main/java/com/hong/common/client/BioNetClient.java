package com.hong.common.client;

import com.hong.common.bean.ServiceInfo;

/**
 * @author wanghong
 * @date 2020/06/04 14:19
 **/
public class BioNetClient implements NetClient {
    @Override
    public byte[] sendRequest(byte[] data, ServiceInfo sinfo) throws Throwable {
        return new byte[0];
    }
}
