package com.ly.base.commonclasses.string;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-11-30 22:29
 *  * @last modify by [luoyong 2019-11-30 22:29]
 * @Description: StringTest
 **/
public class StringTest {


    /**
     * @return void
     * @Description: 字符串拼接
     * 1：常量与常量的的拼接结果在常量池, 且常量池中不会存在相同内容的常量
     * 2：只要其中有一个是变量,结果就在堆当中
     * 3：如果拼接的结果调用intern()方法，返回值就在常量池当中
     * @author luoyong
     * @create 23:19 2019-11-30
     * @last modify by [luoyong 23:19 2019-11-30 ]
     */
    @Test
    public void testSplice() {
        //常量池
        String s1 = "javaEE";
        //常量池
        String s2 = "hadoop";
        //常量池
        String s3 = "javaEEhadoop";
        //常量池
        String s4 = "javaEE" + "hadoop";
        //堆当中
        String s5 = s1 + "hadoop";
        //堆当中
        String s6 = "javaEE" + s2;
        //堆当中
        String s7 = s1 + s2;
        //true
        System.out.println(s3 == s4);
        //false
        System.out.println(s3 == s5);
        //false
        System.out.println(s3 == s6);
        //false
        System.out.println(s3 == s7);
        //false
        System.out.println(s5 == s6);
        //false
        System.out.println(s5 == s7);
        //false
        System.out.println(s6 == s7);

        //返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        String s8 = s6.intern();
        //true
        System.out.println(s3 == s8);

        //常量
        final String s9 = "javaEE";
        String s10 = s9 + "hadoop";
        //true
        System.out.println(s3 == s10);

    }


    /**
     * @return void
     * @Description: 创建
     * String实例化方式
     * 1：通过字面量定义
     * 2：通过new+构造器的方式
     * 面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
     * 两个:一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："abc"
     * @author luoyong
     * @create 22:49 2019-11-30
     * @last modify by [luoyong 22:49 2019-11-30 ]
     */
    @Test
    public void testCreate() {
        String s1 = "javaBase";
        String s2 = "javaBase";

        String s3 = new String("javaBase");
        String s4 = new String("javaBase");

        //true
        System.out.println(s1 == s2);
        //false
        System.out.println(s1 == s3);
        //false
        System.out.println(s1 == s4);
        //false
        System.out.println(s3 == s4);

        System.out.println("****************");
        Person p1 = new Person("ly", 28);
        Person p2 = new Person("ly", 28);

        //true
        System.out.println(p1.getName().equals(p2.getName()));
        //true 地址值是一样的
        System.out.println(p1.getName() == p2.getName());

        p1.setName("zq");

        System.out.println(p2.getName());

    }

    /**
     * @return void
     * @Description: 字符串的不可变特性
     * String:字符串，使用一对""引起来表示。
     * 1.String声明为final的，不可被继承
     * 2.String实现了Serializable接口：表示字符串是支持序列化的。
     * 实现了Comparable接口：表示String可以比较大小
     * 3.String内部定义了final char[] value用于存储字符串数据
     * 4.String:代表不可变的字符序列。简称：不可变性。
     * 体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
     * 2. 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
     * 3. 当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
     * 5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
     * 6.字符串常量池中是不会存储相同内容的字符串的。
     * @author luoyong
     * @create 22:37 2019-11-30
     * @last modify by [luoyong 22:37 2019-11-30 ]
     */
    @Test
    public void testImmutable() {
        //字面量的定义方式
        String s1 = "abc";
        String s2 = "abc";
        s1 = "hello";

        //比较s1和s2的地址值
        System.out.println(s1 == s2);

        //hello
        System.out.println(s1);
        //abc
        System.out.println(s2);

        System.out.println("*****************");

        String s3 = "abc";
        s3 += "def";
        //abcdef
        System.out.println(s3);
        System.out.println(s2);

        System.out.println("*****************");

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        //abc
        System.out.println(s4);
        //mbc
        System.out.println(s5);
    }
}
