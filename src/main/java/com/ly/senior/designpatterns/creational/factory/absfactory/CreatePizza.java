package com.ly.senior.designpatterns.creational.factory.absfactory;

import com.ly.senior.designpatterns.creational.factory.tradition.pizza.Pizza;

/**
 * @author luoyong
 *  * @create 2019-09-09 15:14
 *  * @last modify by [luoyong 2019-09-09 15:14]
 * @Description: AbsFactory
 **/
public interface CreatePizza {
    /**
     * @param orderType
     * @return
     * @Description: 根据类型创建不同种类的pizza
     * @author luoyong
     * @create 15:16 2019-09-09
     * @last modify by [luoyong 15:16 2019-09-09 ]
     */
    Pizza createPizza(String orderType);
}
