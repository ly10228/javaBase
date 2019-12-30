package com.ly.base.generic.genericinheritance;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author luoyong
 *  * @create 2019-12-16 21:48
 *  * @last modify by [luoyong 2019-12-16 21:48]
 * @Description: GenericInheritance--泛型继承
 **/
public class GenericInheritance {

    @Test
    public void test1() {
        Object obj = null;
        String str = null;
        //存在继承关系
        obj = str;

        Object[] objects = null;
        String[] strings = null;
        //编译不通过
//        objects == strings;

        Date date = new Date();
        //编译不通过
//        date = str;

        List<Object> list1 = null;
        List<String> list2 = Lists.newArrayList();
        //编译不通过 list1和list2不具备父子关系
//        list1==list2;

                /*
        反证法：
        假设list1 = list2;
           list1.add(123);导致混入非String的数据。出错。

         */
        show(list1);
        show1(list2);
    }

    public void show1(List<String> list) {

    }

    public void show(List<Object> list) {

    }

    @Test
    public void test2() {
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();
    }

}


