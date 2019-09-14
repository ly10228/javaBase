package com.ly.senior.designpatterns.structured.adapter.interfaceadapter;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * 接口适配器模式--适用于一个接口不想使用其所有的方法的情况
 * @create 2019-09-14 10:33
 * @last modify by [LuoYong 2019-09-14 10:33]
 **/
public class Client {

    @Test
    public void test() {
        AbsAdapter absAdapter = new AbsAdapter() {
            @Override
            public void m1() {
                System.out.println("使用了m1的方法");
            }
        };
        absAdapter.m1();
    }
}
