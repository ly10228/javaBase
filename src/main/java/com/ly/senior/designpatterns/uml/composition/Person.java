package com.ly.senior.designpatterns.uml.composition;

/**
 * @author luoyong
 * @Description: Person
 * @create 2019-09-07 17:15
 * @last modify by [LuoYong 2019-09-07 17:15]
 **/
public class Person {
    /**
     * 聚合关系
     */
    private IDCard card;
    /**
     * 组合关系
     */
    private Head head = new Head();

}
