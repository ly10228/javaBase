package com.ly.senior.designpatterns.behaviortype.visitor;

/**
 * @author luoyong
 * @Description: Action
 * @create 2019-09-16 23:11
 * @last modify by [LuoYong 2019-09-16 23:11]
 **/
public abstract class Action {
    /**
     * 得到男性 的测评
     *
     * @param man
     */
    public abstract void getManResult(Man man);

    /**
     * 得到女的 测评
     *
     * @param woman
     */
    public abstract void getWomanResult(Woman woman);
}
