package com.ly.senior.designpatterns.sgg.behavioral.strategy;

/**
 * @author luoyong
 *  * @create 2021-06-13 10:13 下午
 *  * @last modify by [luoyong 2021-06-13 10:13 下午]
 * @Description:
 **/
public class RandomStrategy implements GameStrategy {

    /**
     * @return void
     * @Description: 大乱斗策略 上去就是团
     * @author luoyong
     * @create 10:20 下午 2021/6/13
     * @last modify by [LuoYong 10:20 下午 2021/6/13 ]
     */
    @Override
    public void warStrategy() {
        System.out.println("大乱斗...");
    }
}
