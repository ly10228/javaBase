package com.ly.senior.jvm.runtimearea.stack;

import java.util.Date;

/**
 * @author luoyong
 *  * @create 2021-05-05 5:44 下午
 *  * @last modify by [luoyong 2021-05-05 5:44 下午]
 * @Description: 测试局部变量表
 **/
public class LocalVariablesTest {
    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
    }

    //关于Slot的使用的理解
    public void test1() {
        Date date = new Date();
        String name1 = "com.ly";
        test2(date, name1);
        System.out.println(date + name1);
    }

    public static void testStatic() {
        LocalVariablesTest test = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
        //因为this变量不存在于当前方法的局部变量表中！！
//        System.out.println(this.count);
    }


    public LocalVariablesTest() {
        this.count = 1;

    }


    /**
     * @param dateP
     * @param name2
     * @return java.lang.String
     * @Description: 非静态的方法 局部变量表中默认存储了this
     * @author luoyong
     * @create 5:49 下午 2021/5/5
     * @last modify by [LuoYong 5:49 下午 2021/5/5 ]
     */
    public String test2(Date dateP, String name2) {
        dateP = null;
        name2 = "ly";
        // double 和 long 会占据两个slot
        double weight = 180.5;
        char gender = '男';
        return dateP + name2;
    }

    public void test3() {
        this.count++;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //变量c的位置:复用了变量b的slot
        int c = a + 1;
    }

    public void test5Temp() {
        int num;
//        System.out.println(num);//错误信息：变量num未进行初始化
    }
}
