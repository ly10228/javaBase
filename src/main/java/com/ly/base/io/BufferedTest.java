package com.ly.base.io;

import org.junit.Test;

import java.io.*;

/**
 * @author luoyong
 *  * @create 2019-12-26 16:47
 *  * @last modify by [luoyong 2019-12-26 16:47]
 * @Description: 处理流之一：缓冲流的使用
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * 2.作用：提供流的读取、写入的速度
 * 提高读写速度的原因：内部提供了一个缓冲区
 * 3. 处理流，就是“套接”在已有的流的基础上。
 **/
public class BufferedTest {

    /**
     * @return void
     * @Description: 非文本文件的复制--字节流
     * @author luoyong
     * @create 16:50 2019-12-26
     * @last modify by [LuoYong 16:50 2019-12-26 ]
     */
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {

            //1:造文件
            File srcFile = new File("/Users/luoyong/java/doc/test/src.png");
            File destFile = new File("/Users/luoyong/java/doc/test/bufferStream.png");

            //2: 造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //2：读写数据
            byte[] bytes = new byte[1024];
            //每次读入到字节数组当中的字节个数
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    /**
     * @param srcPath
     * @param destPath
     * @return void
     * @Description: 实现文件复制的方法
     * @author luoyong
     * @create 17:07 2019-12-26
     * @last modify by [LuoYong 17:07 2019-12-26 ]
     */
    public void copyFileWithBuffered(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }
    }


    @Test
    public void testCopyFileWithBuffered() {
        long start = System.currentTimeMillis();
        String srcPath = "/Users/luoyong/java/video/01.avi";
        String destPath = "/Users/luoyong/java/doc/test/02.avi";
        copyFileWithBuffered(srcPath, destPath);
        long end = System.currentTimeMillis();
        //284ms
        System.out.println("复制操作花费的时间为：" + (end - start));
    }


    /**
     * @return void
     * @Description: 字符流
     * 使用BufferedReader和BufferedWriter实现文本文件的复制
     * @author luoyong
     * @create 17:09 2019-12-26
     * @last modify by [LuoYong 17:09 2019-12-26 ]
     */
    @Test
    public void testBufferedReaderBufferedWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和对应的流
            br = new BufferedReader(new FileReader("/Users/luoyong/java/doc/test/hello.txt"));
            bw = new BufferedWriter(new FileWriter("/Users/luoyong/java/doc/test/bw.txt"));
            //数据的读写
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }
            //方式二
            String data;
            while ((data = br.readLine()) != null) {
                //  bw.write(data + "\n");//data中不包含换行符
                //data当中不包含换行符
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (null != br) {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
