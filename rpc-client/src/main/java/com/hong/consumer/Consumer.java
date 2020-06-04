package com.hong.consumer;

import com.hong.common.client.ClientStubProxyFactory;
import com.hong.common.client.NettyNetClient;
import com.hong.common.discoverer.ZookeeperServiceDiscoverer;
import com.hong.common.protocol.JavaSerializeMessageProtocol;
import com.hong.common.protocol.MessageProtocol;
import com.hong.common.util.PropertiesReader;
import com.hong.provider.api.DemoService;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanghong
 * @date 2020/06/04 14:33
 **/
public class Consumer {

    private static PropertiesReader propertiesReader = new PropertiesReader("app");

    public static void main(String[] args) throws Exception {

        ClientStubProxyFactory cspf = new ClientStubProxyFactory();
        // 设置服务发现者
        cspf.setSid(new ZookeeperServiceDiscoverer());

        // 设置支持的协议
        String protocol = propertiesReader.getLabel("rpc.protocol");
        Map<String, MessageProtocol> supportMessageProtocols = new HashMap<>();
        supportMessageProtocols.put(protocol, new JavaSerializeMessageProtocol());
        cspf.setSupportMessageProtocols(supportMessageProtocols);

        // 设置网络层实现
        cspf.setNetClient(new NettyNetClient());

        DemoService demoService = cspf.getProxy(DemoService.class); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println(hello); // 显示调用结果

        System.out.println(demoService.multiPoint(new Point(5, 10), 2));
    }
}
