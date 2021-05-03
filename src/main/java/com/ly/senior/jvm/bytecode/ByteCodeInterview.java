package com.ly.senior.jvm.bytecode;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2021-05-03 6:40 下午
 *  * @last modify by [luoyong 2021-05-03 6:40 下午]
 * @Description: ByteCodeInterview
 **/
public class ByteCodeInterview {
    @Test
    public void test1() {
        int i = 10;
        //输出结果 11
//        i++;
        //输出结果11
        ++i;
        System.out.println(i);
    }


    @Test
    public void test2() {
        int i = 10;
        i = i++;
        //输出结果10
        System.out.println(i);
    }


    @Test
    public void test3() {
        int i = 2;
        //i = i * i++
        i *= i++;
        //4
        System.out.println(i);
    }

    @Test
    public void test4() {
        int k = 10;
        k = k + (k++) + (++k);
        //32
        System.out.println(k);
    }


    /**
     * @return void
     * @Description: 包装类对象的缓存问题
     * @author luoyong
     * @create 8:32 下午 2021/5/3
     * @last modify by [LuoYong 8:32 下午 2021/5/3 ]
     */
    @Test
    public void test5() {

        Integer i1 = 10;
        Integer i2 = 10;
        //true
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        //false
        System.out.println(i3 == i4);

        Boolean b1 = true;
        Boolean b2 = true;
        //true
        System.out.println(b1 == b2);
    }


    /**
     * @return void
     * @Description: String声明的字面量数据都放在字符串常量池中
     * jdk 6中字符串常量池存放在方法区（即永久代中）
     * jdk7 及以后字符串常量池存放在堆空间
     * @author luoyong
     * @create 8:40 下午 2021/5/3
     * @last modify by [LuoYong 8:40 下午 2021/5/3 ]
     */
    @Test
    public void test6() {
        String str = new String("hello") + new String("World");
//        str.intern();   true
        String str1 = "helloWorld";
        //false
        str.intern();
        //false --> true (加上intern() 在str声明之前)
        System.out.println(str == str1);

    }
}
