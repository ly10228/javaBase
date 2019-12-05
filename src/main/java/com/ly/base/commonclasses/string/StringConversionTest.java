package com.ly.base.commonclasses.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author luoyong
 *  * @create 2019-12-01 21:45
 *  * @last modify by [luoyong 2019-12-01 21:45]
 * @Description: String类的转换
 **/
public class StringConversionTest {


    /**
     * @return void
     * @Description: String与byte[]之间的转换
     * 编码：String-->byte[] 调用String类的getBytes()
     * 解码：byte[]-->String 调用String的构造器
     * 编码：字符串--》字节（看的懂--》看不懂的二进制数据）
     * 解码：字节--》字符串（看不懂的二进制数据--》看的懂）
     * 说明--》解码时 要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
     * utf-8 换一个汉字三个字节 gbk一个汉字两个字节
     * @author luoyong
     * @create 22:02 2019-12-01
     * @last modify by [luoyong 22:02 2019-12-01 ]
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        //使用默认字符集进行编码
        byte[] byteArray = str1.getBytes();
        System.out.println(Arrays.toString(byteArray));

        byte[] gbks = str1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));

        System.out.println("***************");

        //使用默认字符集 进行解码
        String str2 = new String(byteArray);
        System.out.println(str2);

        //指定编码格式 进行解码
        String str3 = new String(byteArray, "gbk");
        System.out.println(str3);

        //str4中文乱码--编码与解码集要一致
        String str4 = new String(gbks);
        System.out.println(str4);

    }


    /**
     * @return void
     * @Description: String与char[]之间的转换
     * String-->char[] str.toCharArray()
     * char[]-->String String构造方法 new String(char[] chars)
     * @author luoyong
     * @create 21:55 2019-12-01
     * @last modify by [luoyong 21:55 2019-12-01 ]
     */
    @Test
    public void test2() {
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + "\t");
        }

        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(chars);
        System.out.println(str2);
    }


    /**
     * @return void
     * @Description: String 与基本数据类型、包装类型之间的转换
     * String-->基本数据类型。 包装类：调用包装类的静态方法-->parseXxx(str)
     * 基本数据类型--》String 调用String类的静态方法 String.valueOf(xxx) 或者 xxx+""
     * @author luoyong
     * @create 21:46 2019-12-01
     * @last modify by [luoyong 21:46 2019-12-01 ]
     */
    @Test
    public void test1() {
        String str1 = "123";

        //String转换成基本数据类型
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);
        String str3 = num + "";
        //false str2在堆空间当中
        System.out.println(str1 == str2);
        //false str3在堆空间当中 str1在方法区常量池里面
        System.out.println(str1 == str3);
    }


}
