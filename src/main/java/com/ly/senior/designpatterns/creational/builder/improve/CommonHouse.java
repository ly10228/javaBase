package com.ly.senior.designpatterns.creational.builder.improve;

/**
 * @author luoyong
 *  * @create 2019-09-11 16:46
 *  * @last modify by [luoyong 2019-09-11 16:46]
 * @Description: CommonHouse
 **/
public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println(" 普通房子打地基5米 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 普通房子砌墙10cm ");
    }

    @Override
    public void roofed() {
        System.out.println(" 普通房子屋顶 ");
    }
}
