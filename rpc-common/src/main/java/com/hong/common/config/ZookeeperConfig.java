package com.hong.common.config;

import com.hong.common.util.PropertiesReader;

/**
 * @author wanghong
 * @date 2020/06/04 13:38
 **/
public class ZookeeperConfig {
    private static PropertiesReader propertiesReader = new PropertiesReader("app");

    public static final String ZK_ADDRESS = propertiesReader.getLabel("zk.address");
}
