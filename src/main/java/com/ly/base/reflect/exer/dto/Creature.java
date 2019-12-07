package com.ly.base.reflect.exer.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author luoyong
 * @Description: Serializable
 * @create 2019-12-05 23:10
 * @last modify by [LuoYong 2019-12-05 23:10]
 **/
@Getter
@Setter
public class Creature<T> implements Serializable {

    private char gender;

    private double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }
}
