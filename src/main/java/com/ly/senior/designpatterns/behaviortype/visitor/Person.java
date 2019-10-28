package com.ly.senior.designpatterns.behaviortype.visitor;

/**
 * @author luoyong
 * @Description: Person
 * @create 2019-09-16 23:11
 * @last modify by [LuoYong 2019-09-16 23:11]
 **/
public abstract class Person {
    /**
     * @param action
     * @return void
     * @Description: 提供一个方法，让访问者可以访问
     * @author luoyong
     * @create 23:12 2019/9/16
     * @last modify by [LuoYong 23:12 2019/9/16 ]
     */
    public abstract void accept(Action action);
}
