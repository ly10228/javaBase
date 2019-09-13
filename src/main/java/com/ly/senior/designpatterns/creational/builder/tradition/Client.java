package com.ly.senior.designpatterns.creational.builder.tradition;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-09-11 16:39
 *  * @last modify by [luoyong 2019-09-11 16:39]
 * @Description: Client
 * 优点：好理解，简单易操作
 * 缺点：设计的程序结构 过于简单 ，没有设计缓存层对象，程序的维护和扩展不好
 * 这种设计方案：把产品(房子)和创建产品的过程（即：房子的创建过程）封装了在一起，耦合性增强了。
 * 解决方案：将产品和产品的建造过程解耦-->建造者模式
 **/
public class Client {

    @Test
    public void test() {
        CommonHouse commonHouse = new CommonHouse();
        commonHouse.build();
    }
}
