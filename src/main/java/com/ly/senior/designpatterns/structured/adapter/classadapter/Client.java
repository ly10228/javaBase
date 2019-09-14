package com.ly.senior.designpatterns.structured.adapter.classadapter;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client 类适配器模式
 * @create 2019-09-14 9:47
 * @last modify by [LuoYong 2019-09-14 9:47]
 **/
public class Client {

    @Test
    public void test() {
        System.out.println("==== 类适配器模式 ===");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
