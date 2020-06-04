package com.hong.common.protocol;

import com.hong.common.bean.Request;
import com.hong.common.bean.Response;

/**
 * @author wanghong
 * @date 2020/06/04 13:15
 **/
public class HttpMessageProtocol implements MessageProtocol {
    @Override
    public byte[] marshallingRequest(Request req) throws Exception {
        return new byte[0];
    }

    @Override
    public Request unmarshallingRequest(byte[] data) throws Exception {
        return null;
    }

    @Override
    public byte[] marshallingResponse(Response rsp) throws Exception {
        return new byte[0];
    }

    @Override
    public Response unmarshallingResponse(byte[] data) throws Exception {
        return null;
    }
}
