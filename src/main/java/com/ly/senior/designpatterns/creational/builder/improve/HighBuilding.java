package com.ly.senior.designpatterns.creational.builder.improve;

/**
 * @author luoyong
 *  * @create 2019-09-11 16:47
 *  * @last modify by [luoyong 2019-09-11 16:47]
 * @Description: HighBuilding
 **/
public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println(" 高楼的打地基100米 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 高楼的砌墙20cm ");
    }

    @Override
    public void roofed() {
        System.out.println(" 高楼的透明屋顶 ");
    }
}
