package com.ly.base.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author luoyong
 *  * @create 2019-12-26 14:10
 *  * @last modify by [luoyong 2019-12-26 14:10]
 * @Description: 一：流的分类
 * 1:操作数据的单位：字节流 字符流
 * 2:数据的流向 输入流（读数据） 输出流（写数据）
 * 3:流的角色 节点流 处理流
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 **/
public class FileReaderWriterTest {


    /**
     * @return void
     * @Description: 测试字符流 读数据
     * 将day09下的hello.txt文件内容读入程序中，并输出到控制台
     * 说明
     * 1：read()理解：返回读入的一个字符，如果文件达到文件末尾，返回-1
     * 2：异常的处理：为了保证流资源一定是可以执行关闭操作。需要使用try-catch-finally处理
     * 3：读入的文件一定要存在，否则就会报FileNotFoundException
     * @author luoyong
     * @create 14:13 2019-12-26
     * @last modify by [LuoYong 14:13 2019-12-26 ]
     */
    @Test
    public void testFileReader() {

        FileReader fr = null;

        try {

            //1:实例化file文件 指明要操作的文件
            File file = new File("/Users/luoyong/java/doc/test/hello.txt");

            //2:提供具体的流
            fr = new FileReader(file);

            //3:数据的读入
            //read():返回读入的一个字符，如果文件达到末尾就返回-1
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //流的关闭操作
            if (null != fr) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * @return void
     * @Description: read（）方法重载
     * @author luoyong
     * @create 14:50 2019-12-26
     * @last modify by [LuoYong 14:50 2019-12-26 ]
     */
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1:实例化file文件 指明要操作的文件
            File file = new File("/Users/luoyong/java/doc/test/hello.txt");

            //2:提供具体的流
            fr = new FileReader(file);

            //3:read()读取流中的数据
            //一次读取五个字符
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }

        } catch (IOException ex) {

            ex.printStackTrace();

        } finally {
            if (null != fr) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    /**
     * @return void
     * @Description: 从内存当中写出数据到硬盘文件当中
     * public FileWriter(File file, boolean append) throws IOException
     * 输出操作：对应File可以不存在，不会报异常
     * 2.
     * File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
     * File对应的硬盘中的文件如果存在：
     * 如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
     * 如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
     * @author luoyong
     * @create 14:59 2019-12-26
     * @last modify by [LuoYong 14:59 2019-12-26 ]
     */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1:实例化file文件 指明要操作的文件
            File file = new File("/Users/luoyong/java/doc/test/hello.txt");

            //2:提供具体的流 append=false 如果原文件存在 会对原文件里面的内容进行覆盖
            fw = new FileWriter(file, false);

            //3：写出操作
            fw.write("20191226001");
            fw.write("20191226002");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (null != fw) {
                try {
                    //4:流的关闭
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }

    /**
     * @return void
     * @Description: 测试数据的读写
     * @author luoyong
     * @create 15:07 2019-12-26
     * @last modify by [LuoYong 15:07 2019-12-26 ]
     */
    @Test
    public void testFileReaderWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1:创建File类的对象，指明读入和写出的文件
            File srcFile = new File("/Users/luoyong/java/doc/test/hello.txt");
            File destFile = new File("/Users/luoyong/java/doc/test/dest.txt");

            //2:创建输入输出流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3:数据的读入和写出操作
            char[] chars = new char[5];
            //记录每次读入到chars数组中的字符的个数
            int len;
            while ((len = fr.read(chars)) != -1) {
                //每次写出len个字符
                fw.write(chars, 0, len);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                //流关闭
                if (null != fw) {
                    fw.close();
                }
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
