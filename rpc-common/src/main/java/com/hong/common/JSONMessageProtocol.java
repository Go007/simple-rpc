package com.hong.common;

import com.alibaba.fastjson.JSON;

/**
 * @author wanghong
 * @date 2020/06/04 13:16
 **/
public class JSONMessageProtocol implements MessageProtocol {
    @Override
    public byte[] marshallingRequest(Request req) {
        Request temp = new Request();
        temp.setServiceName(req.getServiceName());
        temp.setMethod(req.getMethod());
        temp.setHeaders(req.getHeaders());
        temp.setParameterTypes(req.getParameterTypes());

        if (req.getParameters() != null) {
            Object[] params = req.getParameters();
            Object[] serizeParmas = new Object[params.length];
            for (int i = 0; i < params.length; i++) {
                serizeParmas[i] = JSON.toJSONString(params[i]);
            }

            temp.setParameters(serizeParmas);
        }

        return JSON.toJSONBytes(temp);
    }

    @Override
    public Request unmarshallingRequest(byte[] data) {
        Request req = JSON.parseObject(data, Request.class);
        if (req.getParameters() != null) {
            // TODO
        }
        return null;
    }

    @Override
    public byte[] marshallingResponse(Response rsp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response unmarshallingResponse(byte[] data) {
        // TODO Auto-generated method stub
        return null;
    }
}
