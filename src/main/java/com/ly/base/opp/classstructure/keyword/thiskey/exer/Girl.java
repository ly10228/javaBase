package com.ly.base.opp.classstructure.keyword.thiskey.exer;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Girl
 * @create 2019-10-28 22:12
 * @last modify by [LuoYong 2019-10-28 22:12]
 **/
@Data
public class Girl {
    private String name;
    private int age;

    public Girl() {

    }

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void marry(Boy boy) {
        System.out.println("我想嫁给" + boy.getName());
        boy.marry(this);
    }


    /**
     * @param girl
     * @return int
     * @Description: 比较两个对象的大小
     * 正数：当前对象大；  负数：当前对象小  ； 0：当前对象与形参对象相等
     * @author luoyong
     * @create 22:13 2019/10/28
     * @last modify by [LuoYong 22:13 2019/10/28 ]
     */
    public int compare(Girl girl) {
        return this.age - girl.age;
    }
}
