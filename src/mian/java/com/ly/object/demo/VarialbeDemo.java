package com.ly.object.demo;

import com.ly.object.dto.Varialbe;

/**
 * @author dell
 * @Description: 成员变量demo
 * @create 2018-11-14 23:47
 * @last modify by [dell 2018-11-14 23:47]
 **/
public class VarialbeDemo {
    public static void main(String[] args) {
        Varialbe v = new Varialbe();

        System.out.println(v.getNum()); //访问成员变量

        v.show();
    }
}
