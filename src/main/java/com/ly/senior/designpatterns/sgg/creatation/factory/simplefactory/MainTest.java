package com.ly.senior.designpatterns.sgg.creatation.factory.simplefactory;

/**
 * @author luoyong
 *  * @create 2021-06-14 3:18 下午
 *  * @last modify by [luoyong 2021-06-14 3:18 下午]
 * @Description: MainTest
 **/
public class MainTest {
    public static void main(String[] args) {
        WuLinSimpleFactory factory = new WuLinSimpleFactory();

        AbstractCar van = factory.newCar("van");
        AbstractCar mini = factory.newCar("mini");
        AbstractCar zz = factory.newCar("zz");
        van.run();
        mini.run();
    }
}
