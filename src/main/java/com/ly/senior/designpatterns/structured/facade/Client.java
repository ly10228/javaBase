package com.ly.senior.designpatterns.structured.facade;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * @create 2019-09-15 16:22
 * @last modify by [LuoYong 2019-09-15 16:22]
 **/
public class Client {

    @Test
    public void test() {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();
        homeTheaterFacade.end();
    }
}
