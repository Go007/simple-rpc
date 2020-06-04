package com.hong.common.server;

import lombok.Data;

/**
 * @author wanghong
 * @date 2020/06/04 10:48
 * 定义 RPC 服务端，抽象类，可以有多种实现
 **/
@Data
public abstract class RpcServer {

    /**
     * 服务端对外暴露的端口号
     */
    protected int port;

    /**
     * 客户端-服务端交互协议
     */
    protected String protocol;

    /**
     * 请求处理器
     */
    protected RequestHandler requestHandler;

    public RpcServer(int port, String protocol, RequestHandler requestHandler) {
        this.port = port;
        this.protocol = protocol;
        this.requestHandler = requestHandler;
    }

    /**
     * 开启服务
     */
    public abstract void start();

    /**
     * 停止服务
     */
    public abstract void stop();
}
