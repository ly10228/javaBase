package com.ly.senior.designpatterns.sgg.creatation.factory.simplefactory;

/**
 * @author luoyong
 *  * @create 2021-06-14 3:17 下午
 *  * @last modify by [luoyong 2021-06-14 3:17 下午]
 * @Description: 工厂类
 * 简单工厂--->产品数量极少
 **/
public class WuLinSimpleFactory {
    /**
     * @param type Class: 好像具有扩展性，但是没有解决实际问题
     * @return
     */
    public AbstractCar newCar(String type) {

        //核心方法：一切从简
        if ("van".equals(type)) {
            // 钣金、喷漆、放发动机、申请环保

            return new VanCar();
        } else if ("mini".equals(type)) {
            return new MiniCar();
        }

        //.....

        //更多的产品，违反开闭原则。应该直接扩展出一个类来造
        return null;
    }
}
