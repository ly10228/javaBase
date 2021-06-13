package com.ly.senior.designpatterns.sgg.behavioral.strategy;

/**
 * @author luoyong
 *  * @create 2021-06-13 10:10 下午
 *  * @last modify by [luoyong 2021-06-13 10:10 下午]
 * @Description: 环境类
 **/
public class TeamGNR {

    /**
     * 战斗策略
     */
    private GameStrategy gameStrategy;


    public void setGameStrategy(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    /**
     * @return void
     * @Description: 游戏开始------>win 有很多种策略 比如：1 直接中推 2：四一分带 3 偷塔 4 猥琐发育等等  将这些策略抽象起来
     * @author luoyong
     * @create 10:11 下午 2021/6/13
     * @last modify by [LuoYong 10:11 下午 2021/6/13 ]
     */
    public void startGame() {
        System.out.println("游戏开始.....");
        //游戏策略
        gameStrategy.warStrategy();
        System.out.println("win......");
    }
}
