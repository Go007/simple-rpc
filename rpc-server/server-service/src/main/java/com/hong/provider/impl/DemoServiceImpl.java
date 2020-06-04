package com.hong.provider.impl;

import com.hong.provider.api.DemoService;

import java.awt.*;

/**
 * @author wanghong
 * @date 2020/06/04 14:31
 **/
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public Point multiPoint(Point p, int multi) {
        p.x = p.x * multi;
        p.y = p.y * multi;
        return p;
    }
}
