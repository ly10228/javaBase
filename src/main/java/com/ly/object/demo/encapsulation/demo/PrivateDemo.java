package com.ly.object.demo.encapsulation.demo;

import com.ly.object.demo.encapsulation.dto.Demo;

/**
 * @author dell
 * @Description: TODO
 * @create 2018-11-20 22:53
 * @last modify by [dell 2018-11-20 22:53]
 **/
public class PrivateDemo {
    public static void main(String[] args) {
        Demo d = new Demo();
        //不能方法私有的成员变量
        //System.out.println(d.num);
        d.show();
        //不能访问私有的成员方法
        //d.method();
        d.function();
    }
}
