package com.hong.provider;

import com.hong.common.bean.ServiceObject;
import com.hong.common.protocol.JavaSerializeMessageProtocol;
import com.hong.common.register.ServiceRegister;
import com.hong.common.register.ZookeeperServiceRegister;
import com.hong.common.server.NettyRpcServer;
import com.hong.common.server.RequestHandler;
import com.hong.common.server.RpcServer;
import com.hong.common.util.PropertiesReader;
import com.hong.provider.api.DemoService;
import com.hong.provider.impl.DemoServiceImpl;

/**
 * @author wanghong
 * @date 2020/06/04 14:27
 **/
public class Provider {

    private static PropertiesReader propertiesReader = new PropertiesReader("app");

    public static void main(String[] args) throws Exception {

        int port = Integer.parseInt(propertiesReader.getLabel("rpc.port"));
        String protocol = propertiesReader.getLabel("rpc.protocol");

        // 服务注册
        DemoService ds = new DemoServiceImpl();
        ServiceObject so = new ServiceObject(DemoService.class.getName(), DemoService.class, ds);
        ServiceRegister sr = new ZookeeperServiceRegister();
        sr.register(so, protocol, port);

        RequestHandler reqHandler = new RequestHandler(new JavaSerializeMessageProtocol(), sr);

        RpcServer server = new NettyRpcServer(port, protocol, reqHandler);
        server.start();
        System.in.read(); // 按任意键退出
        server.stop();
    }
}
