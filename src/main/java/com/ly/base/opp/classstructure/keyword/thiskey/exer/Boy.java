package com.ly.base.opp.classstructure.keyword.thiskey.exer;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Boy
 * @create 2019-10-28 22:11
 * @last modify by [LuoYong 2019-10-28 22:11]
 **/
@Data
public class Boy {

    private String name;
    private int age;

    public Boy() {
    }

    public Boy(String name) {
        this.name = name;
    }

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void marry(Girl girl){
        System.out.println("我想娶" + girl.getName());
    }

    public void shout(){
        if(this.age >= 22){
            System.out.println("你可以去合法登记结婚了！");
        }else{
            System.out.println("先多谈谈恋爱~~");
        }

    }
}
