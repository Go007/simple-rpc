package com.hong.service;

/**
 * @author wanghong
 * @date 2020/06/04 10:48
 * 定义 RPC 服务端，抽象类，可以有多种实现
 **/
public abstract class RpcServer {

    /**
     * 服务端对外暴露的端口号
     */
    public int port;

    /**
     * 客户端-服务端交互协议
     */
    public String protocol;

    /**
     * 开启服务
     */
    public abstract void start();

    /**
     * 停止服务
     */
    public abstract void stop();
}
