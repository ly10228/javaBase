package com.ly.senior.designpatterns.principle.singleresponsibility.bad;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Vehicle
 * 交通工具
 * @create 2019-08-28 22:45
 * @last modify by [LuoYong 2019-08-28 22:45]
 **/
@Data
public class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在公路上运行....");
    }
}
