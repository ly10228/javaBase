package com.ly.senior.designpatterns.sgg.behavioral.strategy;

/**
 * @author luoyong
 *  * @create 2021-06-13 10:22 下午
 *  * @last modify by [luoyong 2021-06-13 10:22 下午]
 * @Description: 稳健运营 四一分推
 **/
public class SteadyStrategy implements GameStrategy {

    /**
     * @return void
     * @Description: 稳健运营 四一分推
     * @author luoyong
     * @create 10:22 下午 2021/6/13
     * @last modify by [LuoYong 10:22 下午 2021/6/13 ]
     */
    @Override
    public void warStrategy() {
        System.out.println("稳健运营 四一分推");
    }
}
