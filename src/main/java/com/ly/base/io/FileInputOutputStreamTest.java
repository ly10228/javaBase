package com.ly.base.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author luoyong
 *  * @create 2019-12-26 15:41
 *  * @last modify by [luoyong 2019-12-26 15:41]
 * @Description: FileInputOutputStreamTest
 * 结论：
 * 1：对于文本文件（.txt .java .c .cpp） 使用字符流处理
 * 2：对于非文本文件（.jpg .mp3 .mp4 .avi .doc .ppt ....）使用字节流处理
 **/
public class FileInputOutputStreamTest {

    /**
     * @return void
     * @Description: 字节输入流--读数据
     * 使用FileInputStream处理文本文件，可能会出现乱码
     * @author luoyong
     * @create 15:43 2019-12-26
     * @last modify by [LuoYong 15:43 2019-12-26 ]
     */
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {

            //1:初始化文件资源
            File file = new File("/Users/luoyong/java/doc/test/hello.txt");

            //2:获取流对象
            fis = new FileInputStream(file);

            //3:读取流当中的数据
            byte b[] = new byte[5];
            //用来记录每次读入到数组当中的字节的个数
            int len;
            while ((len = fis.read(b)) != -1) {
                String string = new String(b, 0, len);
                System.out.println(string);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (null != fis) {
                try {
                    //4:关闭流对象
                    fis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    /**
     * @return void
     * @Description: 实现对图片的复制
     * 字节输入流--读数据
     * 字节输出流--写数据
     * @author luoyong
     * @create 15:51 2019-12-26
     * @last modify by [LuoYong 15:51 2019-12-26 ]
     */
    @Test
    public void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {

            //1:获取文件
            File srcFile = new File("/Users/luoyong/java/doc/test/src.png");
            File destFile = new File("/Users/luoyong/java/doc/test/dest.png");

            //2:获取流对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3：从srcFile当中读数据 写入到destFile当中
            byte[] bytes = new byte[5];
            //记录每次读入到bytes数组当中流的个数
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * @return void
     * @Description: 文件的复制
     * @author luoyong
     * @create 16:09 2019-12-26
     * @last modify by [LuoYong 16:09 2019-12-26 ]
     */
    @Test
    public void testCopyFile() {
        long startTime = System.currentTimeMillis();
        String srcPath = "/Users/luoyong/java/video/01.avi";
        String destPath = "/Users/luoyong/java/doc/test/02.avi";
        copyFile(srcPath,destPath);
        long endTime = System.currentTimeMillis();
        System.out.println("复制时间为:"+(endTime-startTime)+"ms");
    }

    /**
     * @param srcPath  目标路径
     * @param destPath 指定路径
     * @return void
     * @Description: 对指定路径的文件进行复制
     * @author luoyong
     * @create 16:10 2019-12-26
     * @last modify by [LuoYong 16:10 2019-12-26 ]
     */
    public void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1:获取文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2:流实例化
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3:读写数据
            byte[] bytes = new byte[1024];
            //每次读入到字节数组的字节个数
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
