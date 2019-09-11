package com.ly.senior.designpatterns.creational.builder.improve;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-09-11 16:51
 *  * @last modify by [luoyong 2019-09-11 16:51]
 * @Description: Client
 **/
public class Client {

    /**
     * @return void
     * @Description: 测试构建普通房子
     * @author luoyong
     * @create 16:52 2019-09-11
     * @last modify by [luoyong 16:52 2019-09-11 ]
     */
    @Test
    public void testBuildCommonHouse() {
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector director = new HouseDirector(commonHouse);
        House house = director.constructHouse();
        System.out.println(house);
    }

    @Test
    public void testBuildHidhHouse() {
        HighBuilding highBuilding = new HighBuilding();
        HouseDirector director = new HouseDirector(highBuilding);
        House house = director.constructHouse();
        System.out.println(house);
    }
}
