package com.ly.object.demo.encapsulation.dto;

/**
 * @author dell
 * @Description: TODO
 * @create 2018-11-20 22:53
 * @last modify by [dell 2018-11-20 22:53]
 **/
public class Demo {
    //int num = 10;
    //用private修饰
    private int num = 10;

    public void show() {
        System.out.println(num);
    }

    private void method() {
        System.out.println("method");
    }

    public void function() {
        method();
    }
}
