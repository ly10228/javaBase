package com.ly.senior.designpatterns.structured.decorator;

import com.ly.senior.designpatterns.structured.decorator.coffee.Chocolate;
import com.ly.senior.designpatterns.structured.decorator.coffee.LongBlack;
import com.ly.senior.designpatterns.structured.decorator.decorator.DeCaf;
import com.ly.senior.designpatterns.structured.decorator.decorator.Milk;

/**
 * @author luoyong
 * @Description: CoffeeBar
 * @create 2019-09-14 20:40
 * @last modify by [LuoYong 2019-09-14 20:40]
 **/
public class CoffeeBar {
    public static void main(String[] args) {
        // 装饰者模式下的订单：2份巧克力+一份牛奶的LongBlack

        // 1. 点一份 LongBlack
        Drink order = new LongBlack();
        System.out.println("费用1=" + order.cost());
        System.out.println("描述=" + order.getDesc());

        // 2. order 加入一份牛奶
        order = new Milk(order);

        System.out.println("order 加入一份牛奶 费用 =" + order.cost());
        System.out.println("order 加入一份牛奶 描述 = " + order.getDesc());

        // 3. order 加入一份巧克力

        order = new Chocolate(order);

        System.out.println("order 加入一份牛奶 加入一份巧克力  费用 =" + order.cost());
        System.out.println("order 加入一份牛奶 加入一份巧克力 描述 = " + order.getDesc());

        // 3. order 加入一份巧克力

        order = new Chocolate(order);

        System.out.println("order 加入一份牛奶 加入2份巧克力   费用 =" + order.cost());
        System.out.println("order 加入一份牛奶 加入2份巧克力 描述 = " + order.getDesc());

        System.out.println("===========================");

        Drink order2 = new DeCaf();

        System.out.println("order2 无因咖啡  费用 =" + order2.cost());
        System.out.println("order2 无因咖啡 描述 = " + order2.getDesc());

        order2 = new Milk(order2);

        System.out.println("order2 无因咖啡 加入一份牛奶  费用 =" + order2.cost());
        System.out.println("order2 无因咖啡 加入一份牛奶 描述 = " + order2.getDesc());

    }
}
