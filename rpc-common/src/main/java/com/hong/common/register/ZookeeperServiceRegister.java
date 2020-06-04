package com.hong.common.register;

import com.alibaba.fastjson.JSON;
import com.hong.common.bean.ServiceInfo;
import com.hong.common.bean.ServiceObject;
import com.hong.common.config.ZookeeperConfig;
import com.hong.common.serializer.MyZkSerializer;
import org.I0Itec.zkclient.ZkClient;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;

/**
 * @author wanghong
 * @date 2020/06/04 13:44
 **/
public class ZookeeperServiceRegister extends DefaultServiceRegister implements ServiceRegister {

    private ZkClient zkClient;

    private static final String ROOT_PATH = "/Rpc-framework";

    public ZookeeperServiceRegister() {
        String addr = ZookeeperConfig.ZK_ADDRESS;
        zkClient = new ZkClient(addr);
        zkClient.setZkSerializer(new MyZkSerializer());
    }

    @Override
    public void register(ServiceObject so, String protocolName, int port) throws UnknownHostException {
        super.register(so, protocolName, port);

        String host = InetAddress.getLocalHost().getHostAddress();
        String address = host + ":" + port;

        ServiceInfo soInf = new ServiceInfo();
        soInf.setAddress(address);
        soInf.setName(so.getInterfaces().getName());
        soInf.setProtocol(protocolName);

        this.exportService(soInf);
    }

    private void exportService(ServiceInfo serviceResource) {
        String serviceName = serviceResource.getName();
        String uri = JSON.toJSONString(serviceResource);
        try {
            uri = URLEncoder.encode(uri, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String servicePath = ROOT_PATH + "/" + serviceName + "/service";
        if (!zkClient.exists(servicePath)) {
            zkClient.createPersistent(servicePath, true);
        }
        String uriPath = servicePath + "/" + uri;
        if (zkClient.exists(uriPath)) {
            zkClient.delete(uriPath);
        }

        // 这里注意创建的是临时节点
        zkClient.createEphemeral(uriPath);
    }
}
