package com.hong.common.protocol;

import com.hong.common.bean.Request;
import com.hong.common.bean.Response;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author wanghong
 * @date 2020/06/04 13:17
 **/
public class JavaSerializeMessageProtocol implements MessageProtocol {

    @Override
    public byte[] marshallingRequest(Request req) throws Exception {
        return this.serialize(req);
    }

    @Override
    public Request unmarshallingRequest(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (Request) in.readObject();
    }

    @Override
    public byte[] marshallingResponse(Response rsp) throws Exception {
        return this.serialize(rsp);
    }

    @Override
    public Response unmarshallingResponse(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (Response) in.readObject();
    }

    private byte[] serialize(Object obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(obj);

        return bout.toByteArray();
    }
}
