package com.ly.base.opp.classstructure.keyword.interfacekey.exer2.abs;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: AbsCompareTest
 * @create 2019-11-20 23:06
 * @last modify by [LuoYong 2019-11-20 23:06]
 **/
public class AbsCompareTest {

    @Test
    public void test() {
        Circle c1 = new Circle(4.5);
        Circle c2 = new Circle(4.7);
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
