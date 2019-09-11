package com.ly.senior.designpatterns.creational.builder.tradition;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-09-11 16:39
 *  * @last modify by [luoyong 2019-09-11 16:39]
 * @Description: Client
 **/
public class Client {

    @Test
    public void test() {
        CommonHouse commonHouse = new CommonHouse();
        commonHouse.build();
    }
}
