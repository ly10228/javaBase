package com.ly.base.opp.classstructure.keyword.interfacekey.exer2;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: ComparableCircleTest
 * @create 2019-11-20 22:52
 * @last modify by [LuoYong 2019-11-20 22:52]
 **/
public class ComparableCircleTest {

    @Test
    public void test() {
        ComparableCircle c1 = new ComparableCircle(4.5);
        ComparableCircle c2 = new ComparableCircle(4.7);
        int compareValue = c1.compareTo(c2);
        if (compareValue > 0) {
            System.out.println("c1对象大");
        } else if (compareValue < 0) {
            System.out.println("c2对象大");
        } else {
            System.out.println("c1与c2一样大");
        }

        int compareValue1 = c1.compareTo("AA");
        System.out.println(compareValue1);
    }
}
