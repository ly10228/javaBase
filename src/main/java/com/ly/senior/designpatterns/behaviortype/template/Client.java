package com.ly.senior.designpatterns.behaviortype.template;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * @create 2019-09-16 22:33
 * @last modify by [LuoYong 2019-09-16 22:33]
 **/
public class Client {

    @Test
    public void test() {
        System.out.println("制作红豆豆浆");
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();

        System.out.println("制作花生豆浆");
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();
    }
}
