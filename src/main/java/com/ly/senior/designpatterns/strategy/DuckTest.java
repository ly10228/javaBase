package com.ly.senior.designpatterns.strategy;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-08-15 14:01
 *  * @last modify by [luoyong 2019-08-15 14:01]
 * @Description: DuckTest
 **/
public class DuckTest {
    /**
     * @return void
     * @Description: 测试野鸭
     * @author luoyong
     * @create 14:13 2019-08-15
     * @last modify by [luoyong 14:13 2019-08-15 ]
     */
    @Test
    public void testWildDuck() {
        WildDuck wildDuck = new WildDuck();
        wildDuck.display();
        wildDuck.fly();
        wildDuck.quack();
        wildDuck.swim();
    }

    /**
     * @return void
     * @Description: 测试玩具鸭子
     * @author luoyong
     * @create 14:16 2019-08-15
     * @last modify by [luoyong 14:16 2019-08-15 ]
     */
    @Test
    public void testToyDuck() {
        ToyDuck toyDuck = new ToyDuck();
        toyDuck.display();
        toyDuck.fly();
        toyDuck.quack();
        toyDuck.swim();
    }


    /**
     * @return void
     * @Description: 测试北京鸭
     * @author luoyong
     * @create 14:17 2019-08-15
     * @last modify by [luoyong 14:17 2019-08-15 ]
     */
    @Test
    public void testPekingDuck() {
        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.display();
        pekingDuck.fly();
        pekingDuck.quack();
        pekingDuck.swim();
    }


}
