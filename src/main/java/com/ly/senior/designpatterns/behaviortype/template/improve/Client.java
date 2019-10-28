package com.ly.senior.designpatterns.behaviortype.template.improve;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * @create 2019-09-16 22:41
 * @last modify by [LuoYong 2019-09-16 22:41]
 **/
public class Client {

    @Test
    public void test() {
        System.out.println("----制作红豆豆浆----");
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();

        System.out.println("----制作花生豆浆----");
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();

        System.out.println("----制作纯豆浆----");
        SoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
    }
}
