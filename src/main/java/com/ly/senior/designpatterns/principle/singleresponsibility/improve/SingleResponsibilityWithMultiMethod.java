package com.ly.senior.designpatterns.principle.singleresponsibility.improve;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: SingleResponsibilityWithMoreMethod
 * @create 2019-08-28 22:56
 * @last modify by [LuoYong 2019-08-28 22:56]
 **/
public class SingleResponsibilityWithMultiMethod {

    /**
     * @param
     * @return void
     * @Description: testSingleResponsibilityWithMultiMethod
     * 这种修改方法没有对原来的类做大的修改，只是增加方法
     * 这里虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上，仍然是遵守单一职责
     * @author luoyong
     * @create 22:57 2019/8/28
     * @last modify by [LuoYong 22:57 2019/8/28 ]
     */
    @Test
    public void testSingleResponsibilityWithMultiMethod() {
        VehicleMultiMethod vehicleMultiMethod = new VehicleMultiMethod();
        vehicleMultiMethod.run("汽车");
        vehicleMultiMethod.runWater("轮船");
        vehicleMultiMethod.runAir("飞机");
    }

    class VehicleMultiMethod {
        public void run(String vehicle) {
            //处理

            System.out.println(vehicle + " 在公路上运行....");

        }

        public void runAir(String vehicle) {
            System.out.println(vehicle + " 在天空上运行....");
        }

        public void runWater(String vehicle) {
            System.out.println(vehicle + " 在水中行....");
        }
    }
}

