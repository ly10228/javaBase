package com.ly.base.io.file.exer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author luoyong
 * @Description: FileTest
 * @create 2019-12-25 22:10
 * @last modify by [LuoYong 2019-12-25 22:10]
 **/
public class FileDemo {

    /**
     * @param
     * @return void
     * @Description: 创建一个与file同目录下面的另外一个文件，文件名为haha.txt
     * @author luoyong
     * @create 22:11 2019/12/25
     * @last modify by [LuoYong 22:11 2019/12/25 ]
     */
    @Test
    public void test() throws IOException {
        File file = new File("D:\\test\\hello.txt");
        File destFile = new File(file.getParent(), "haha.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile) {
            System.out.println("创建成功");
        }
    }

}
