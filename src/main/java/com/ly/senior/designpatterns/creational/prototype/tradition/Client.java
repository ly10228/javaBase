package com.ly.senior.designpatterns.creational.prototype.tradition;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-09-10 10:59
 *  * @last modify by [luoyong 2019-09-10 10:59]
 * @Description: Client
 **/
public class Client {

    /**
     * @return void
     * @Description: 测试传统拷贝对象
     * @author luoyong
     * @create 11:01 2019-09-10
     * @last modify by [luoyong 11:01 2019-09-10 ]
     */
    @Test
    public void test() {
        Sheep sheep = new Sheep("tom", 1, "白色");

        Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep4 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep5 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());

        System.out.println(sheep);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);
    }
}
