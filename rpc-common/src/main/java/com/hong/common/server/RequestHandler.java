package com.hong.common.server;

import com.hong.common.bean.Request;
import com.hong.common.bean.Response;
import com.hong.common.bean.ServiceObject;
import com.hong.common.bean.Status;
import com.hong.common.protocol.MessageProtocol;
import com.hong.common.register.ServiceRegister;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wanghong
 * @date 2020/06/04 14:09
 * 请求处理器
 **/
@Data
public class RequestHandler {

    private MessageProtocol protocol;

    private ServiceRegister serviceRegister;

    public RequestHandler(MessageProtocol protocol, ServiceRegister serviceRegister) {
        super();
        this.protocol = protocol;
        this.serviceRegister = serviceRegister;
    }

    public byte[] handleRequest(byte[] data) throws Exception {
        // 1、解组消息
        Request req = this.protocol.unmarshallingRequest(data);

        // 2、查找服务对象
        ServiceObject so = this.serviceRegister.getServiceObject(req.getServiceName());

        Response rsp = null;

        if (so == null) {
            rsp = new Response(Status.NOT_FOUND);
        } else {
            // 3、反射调用对应的过程方法
            try {
                Method m = so.getInterfaces().getMethod(req.getMethod(), req.getParameterTypes());
                Object returnValue = m.invoke(so.getObj(), req.getParameters());
                rsp = new Response(Status.SUCCESS);
                rsp.setReturnValue(returnValue);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                rsp = new Response(Status.ERROR);
                rsp.setException(e);
            }
        }

        // 4、编组响应消息
        return this.protocol.marshallingResponse(rsp);
    }

}
