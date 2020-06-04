package com.hong.common.discoverer;

import com.alibaba.fastjson.JSON;
import com.hong.common.bean.ServiceInfo;
import com.hong.common.config.ZookeeperConfig;
import com.hong.common.serializer.MyZkSerializer;
import org.I0Itec.zkclient.ZkClient;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanghong
 * @date 2020/06/04 14:03
 **/
public class ZookeeperServiceDiscoverer implements ServiceDiscoverer {

    private ZkClient zkClient;

    private static final String ROOT_PATH = "/Rpc-framework";

    public ZookeeperServiceDiscoverer() {
        String addr = ZookeeperConfig.ZK_ADDRESS;
        zkClient = new ZkClient(addr);
        zkClient.setZkSerializer(new MyZkSerializer());
    }

    @Override
    public List<ServiceInfo> getServiceInfo(String name) {
        String servicePath = ROOT_PATH + "/" + name + "/service";
        List<String> children = zkClient.getChildren(servicePath);
        List<ServiceInfo> resources = new ArrayList<ServiceInfo>();
        for (String ch : children) {
            try {
                String deCh = URLDecoder.decode(ch, "UTF-8");
                ServiceInfo r = JSON.parseObject(deCh, ServiceInfo.class);
                resources.add(r);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return resources;
    }
}
