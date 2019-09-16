package com.ly.senior.designpatterns.behaviortype.visitor;

/**
 * @author luoyong
 * @Description: Man
 * @create 2019-09-16 23:13
 * @last modify by [LuoYong 2019-09-16 23:13]
 **/
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
