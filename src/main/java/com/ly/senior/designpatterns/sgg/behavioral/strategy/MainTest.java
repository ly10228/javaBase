package com.ly.senior.designpatterns.sgg.behavioral.strategy;

/**
 * @author luoyong
 *  * @create 2021-06-13 10:24 下午
 *  * @last modify by [luoyong 2021-06-13 10:24 下午]
 * @Description: 测试
 **/
public class MainTest {

    public static void main(String[] args) {

        GameStrategy gameStrategy = new RandomStrategy();

        TeamGNR teamGNR = new TeamGNR();
        teamGNR.setGameStrategy(gameStrategy);
        teamGNR.startGame();
    }
}
