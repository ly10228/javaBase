package com.ly.senior.designpatterns.behaviortype.visitor;

/**
 * @author luoyong
 * @Description: Wait
 * @create 2019-09-16 23:15
 * @last modify by [LuoYong 2019-09-16 23:15]
 **/
public class Wait extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println(" 男人给的评价是该歌手待定 ..");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(" 女人给的评价是该歌手待定 ..");
    }
}
