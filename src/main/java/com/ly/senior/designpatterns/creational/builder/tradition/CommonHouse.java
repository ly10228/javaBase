package com.ly.senior.designpatterns.creational.builder.tradition;

/**
 * @author luoyong
 *  * @create 2019-09-11 16:37
 *  * @last modify by [luoyong 2019-09-11 16:37]
 * @Description: CommonHouse
 **/
public class CommonHouse extends AbstractHouse {
    @Override
    public void buildBasic() {
        System.out.println(" 普通房子打地基 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 普通房子砌墙 ");
    }

    @Override
    public void roofed() {
        System.out.println(" 普通房子封顶 ");
    }
}
