package com.ly.base.opp.classstructure.keyword.thiskey.exer;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: BoyGirlTest
 * @create 2019-10-28 22:16
 * @last modify by [LuoYong 2019-10-28 22:16]
 **/
public class BoyGirlTest {

    /**
     * @param
     * @return void
     * @Description: 测试
     * @author luoyong
     * @create 22:16 2019/10/28
     * @last modify by [LuoYong 22:16 2019/10/28 ]
     */
    @Test
    public void test() {
        Boy boy = new Boy("罗密欧", 21);
        boy.shout();

        Girl girl = new Girl("朱丽叶", 18);
        girl.marry(boy);

        Girl girl1 = new Girl("祝英台", 19);
        int compare = girl.compare(girl1);
        if (compare > 0) {
            System.out.println(girl.getName() + "大");
        } else if (compare < 0) {
            System.out.println(girl1.getName() + "大");
        } else {
            System.out.println("一样大");
        }
    }
}
