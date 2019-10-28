package com.ly.senior.designpatterns.behaviortype.strategy.improve;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-08-15 16:04
 *  * @last modify by [luoyong 2019-08-15 16:04]
 * @Description: DuckStrategyTest
 **/
public class DuckStrategyTest {
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


}
