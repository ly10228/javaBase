package com.ly.senior.designpatterns.principle.singleresponsibility.improve;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: SingleResponsibilityWithMultiClass
 * @create 2019-08-28 22:53
 * @last modify by [LuoYong 2019-08-28 22:53]
 **/
public class SingleResponsibilityWithMultiClass {

    /**
     * @param
     * @return void
     * @Description: 多个类
     * 遵守单一职责原则
     * 但是这样改动很大 1：类分解 2:修改客户端
     * @author luoyong
     * @create 22:53 2019/8/28
     * @last modify by [LuoYong 22:53 2019/8/28 ]
     */
    @Test
    public void testSingleResponsibilityWithMoreClass() {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        roadVehicle.run("汽车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }

    class RoadVehicle {
        public void run(String vehicle) {
            System.out.println(vehicle + "公路运行");
        }
    }

    class AirVehicle {
        public void run(String vehicle) {
            System.out.println(vehicle + "天空运行");
        }
    }

    class WaterVehicle {
        public void run(String vehicle) {
            System.out.println(vehicle + "水中运行");
        }
    }
}
