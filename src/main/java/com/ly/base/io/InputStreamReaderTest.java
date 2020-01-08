package com.ly.base.io;

import org.junit.Test;

import java.io.*;

/**
 * @author luoyong
 *  * @create 2019-12-26 17:23
 *  * @last modify by [luoyong 2019-12-26 17:23]
 * @Description: 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 * 2.作用：提供字节流与字符流之间的转换
 * 3. 解码：字节、字节数组  --->字符数组、字符串
 * 编码：字符数组、字符串 ---> 字节、字节数组
 * 4.字符集
 * ASCII：美国标准信息交换码。 用一个字节的7位可以表示。
 * ISO8859-1：拉丁码表。欧洲码表 用一个字节的8位表示。
 * GB2312：中国的中文编码表。最多两个字节编码所有字符
 * GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 * Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 * UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 **/
public class InputStreamReaderTest {


    /**
     * @return void
     * @Description: 此时处理异常的话，仍然应该使用try-catch-finally
     * InputStreamReader的使用，实现字节的输入流---》字符的输入流的转换（字节输入流-->字符输入流）
     * @author luoyong
     * @create 17:27 2019-12-26
     * @last modify by [LuoYong 17:27 2019-12-26 ]
     */
    @Test
    public void test1() throws IOException {
        //字节输入流
        FileInputStream fis = new FileInputStream("/Users/luoyong/java/doc/test/hello.txt");

        //将字节流转换成字符流
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        char[] chars = new char[1024];
        int len;
        while ((len = isr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }
        isr.close();
    }


    /**
     * @return void
     * @Description: 综合使用InputStreamReader和OutputStreamWriter
     * @author luoyong
     * @create 17:39 2019-12-26
     * @last modify by [LuoYong 17:39 2019-12-26 ]
     */
    @Test
    public void test2() throws IOException {

        //造文件
        File file1 = new File("/Users/luoyong/java/doc/test/hello.txt");
        File file2 = new File("/Users/luoyong/java/doc/test/osw.txt");

        //造流
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

        //2：读写
        char[] chars = new char[1024];
        int len;
        while ((len = isr.read(chars)) != -1) {
            osw.write(chars, 0, len);
        }
        isr.close();
        osw.close();
    }


}