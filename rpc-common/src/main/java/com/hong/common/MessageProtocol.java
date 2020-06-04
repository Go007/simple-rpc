package com.hong.common;

/**
 * @author wanghong
 * @date 2020/06/04 13:13
 * 消息协议
 **/
public interface MessageProtocol {

    byte[] marshallingRequest(Request req) throws Exception;

    Request unmarshallingRequest(byte[] data) throws Exception;

    byte[] marshallingResponse(Response rsp) throws Exception;

    Response unmarshallingResponse(byte[] data) throws Exception;
}
