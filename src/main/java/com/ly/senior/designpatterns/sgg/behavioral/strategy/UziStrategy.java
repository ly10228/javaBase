package com.ly.senior.designpatterns.sgg.behavioral.strategy;

/**
 * @author luoyong
 *  * @create 2021-06-13 10:23 下午
 *  * @last modify by [luoyong 2021-06-13 10:23 下午]
 * @Description: uzi--冲锋
 **/
public class UziStrategy implements GameStrategy {

    /**
     * @return void
     * @Description: uzi--发起冲锋
     * @author luoyong
     * @create 10:23 下午 2021/6/13
     * @last modify by [LuoYong 10:23 下午 2021/6/13 ]
     */
    @Override
    public void warStrategy() {
        System.out.println("uzi--发起冲锋");
    }
}
