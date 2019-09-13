package com.ly.senior.designpatterns.jdksource;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Builder
 * Appendable 接口定义了多个append方法(抽象方法), 即Appendable 为抽象建造者, 定义了抽象方法
 * AbstractStringBuilder 实现了 Appendable 接口方法，这里的AbstractStringBuilder 已经是建造者，只是不能实例化
 * StringBuilder 即充当了指挥者角色，同时充当了具体的建造者，建造方法的实现是由 AbstractStringBuilder 完成, 而StringBuilder 继承了AbstractStringBuilder
 * @create 2019-09-13 18:01
 * @last modify by [LuoYong 2019-09-13 18:01]
 **/
public class Builder {

    @Test
    public void test() {
        StringBuilder stringBuilder = new StringBuilder("hello,world");
        System.out.println(stringBuilder);
    }
}
