package com.ly.senior.designpatterns.creational.builder.improve;

/**
 * @author luoyong
 *  * @create 2019-09-11 16:48
 *  * @last modify by [luoyong 2019-09-11 16:48]
 * @Description: 指挥者 -指定制作的流程，返回产品
 **/
public class HouseDirector {
    /**
     * 聚合抽象的建造者
     */
    HouseBuilder houseBuilder = null;

    /**
     * 构造器注入
     *
     * @param houseBuilder
     */
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    /**
     * setter注入
     *
     * @param houseBuilder
     */
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    /**
     * 如何处理建造房子的流程，交给指挥者
     *
     * @return
     */
    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
