package com.ly.base.commonclasses.string.exer;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2019-11-30 23:39
 *  * @last modify by [luoyong 2019-11-30 23:39]
 * @Description: StringExerTest
 **/
@Data
public class StringExerTest {

    //字符串不可变特性
    String str = new String("good");

    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringExerTest ex = new StringExerTest();

        //引用类型传递的是地址值
        ex.change(ex.str, ex.ch);
        //good
        System.out.println(ex.str);
        //best
        System.out.println(ex.ch);
    }
}
