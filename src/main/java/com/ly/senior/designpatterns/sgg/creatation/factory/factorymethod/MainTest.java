package com.ly.senior.designpatterns.sgg.creatation.factory.factorymethod;

/**
 * @author luoyong
 *  * @create 2021-06-14 3:18 下午
 *  * @last modify by [luoyong 2021-06-14 3:18 下午]
 * @Description: MainTest 相比较于简单工厂 又多了一层抽象 将汽车制造提升为分厂
 **/
public class MainTest {
    public static void main(String[] args) {
        AbstractCarFactory carFactory = new WulinRacingCarFactory();
        AbstractCar abstractCar = carFactory.newCar();
        abstractCar.run();


        carFactory = new WulinVanCarFactory();
        AbstractCar abstractCar1 = carFactory.newCar();

        abstractCar1.run();
    }
}
