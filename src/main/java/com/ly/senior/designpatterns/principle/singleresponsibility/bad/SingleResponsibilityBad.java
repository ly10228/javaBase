package com.ly.senior.designpatterns.principle.singleresponsibility.bad;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: SingleResponsibilityBad
 * 单一原则错误示例
 * @create 2019-08-28 22:44
 * @last modify by [LuoYong 2019-08-28 22:44]
 **/
public class SingleResponsibilityBad {

    /**
     * @param
     * @return void
     * @Description: 不好的示例 违反了单一职责原则
     * @author luoyong
     * @create 22:50 2019/8/28
     * @last modify by [LuoYong 22:50 2019/8/28 ]
     */
    @Test
    public void testBadSingleResponsibility() {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }

}
