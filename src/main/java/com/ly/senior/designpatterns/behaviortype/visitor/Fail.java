package com.ly.senior.designpatterns.behaviortype.visitor;

/**
 * @author luoyong
 * @Description: Fail
 * @create 2019-09-16 23:14
 * @last modify by [LuoYong 2019-09-16 23:14]
 **/
public class Fail extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println(" 男人给的评价该歌手失败 !");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(" 女人给的评价该歌手失败 !");
    }
}
