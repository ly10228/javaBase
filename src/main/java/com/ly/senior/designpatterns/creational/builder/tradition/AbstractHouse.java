package com.ly.senior.designpatterns.creational.builder.tradition;

/**
 * @author luoyong
 *  * @create 2019-09-11 16:33
 *  * @last modify by [luoyong 2019-09-11 16:33]
 * @Description: AbstractHouse
 **/
public abstract class AbstractHouse {

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}
