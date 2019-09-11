package com.ly.senior.designpatterns.creational.builder.improve;

/**
 * @author luoyong
 *  * @create 2019-09-11 16:42
 *  * @last modify by [luoyong 2019-09-11 16:42]
 * @Description: 抽象的建造者
 **/
public abstract class HouseBuilder {
    /**
     * 组合产品--这里指的是房子
     */
    protected House house = new House();

    /**
     * 定义好建造的流程（抽象方法）
     */
    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    /**
     * 建造好房子 将产品返回
     */
    public House buildHouse() {
        return house;
    }

}
