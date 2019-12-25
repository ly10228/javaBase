package com.ly.base.io.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author luoyong
 * @Description: FileTest
 * @create 2019-12-23 18:03
 * @last modify by [LuoYong 2019-12-23 18:03]
 **/
public class FileTest {
    /**
     * @param
     * @return void
     * @Description: 如何创建File类的实例
     * File(String filePath)
     * File(String parentPath,String childPath)
     * File(File parentFile,String childPath)
     * 2.
     * 相对路径：相较于某个路径下，指明的路径。
     * 绝对路径：包含盘符在内的文件或文件目录的路径
     * 3.路径分隔符
     * windows:\\
     * unix:/
     * @author luoyong
     * @create 18:07 2019/12/23
     * @last modify by [LuoYong 18:07 2019/12/23 ]
     */
    @Test
    public void testFileCreate() {
        //构造器1
        //相对于当前module
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\test\\hello.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器2： 文件夹
        File file3 = new File("D:\\test", "JavaSenior");
        System.out.println(file3);

        //构造器3：
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);
    }

    /**
     * @param
     * @return void
     * @Description: File类的获取功能
     * public String getAbsolutePath()：获取绝对路径
     * public String getPath() ：获取路径
     * public String getName() ：获取名称
     * public String getParent()：获取上层文件目录路径。若无，返回null
     * public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     * public long lastModified() ：获取最后一次的修改时间，毫秒值
     * 如下的两个方法适用于文件目录：
     * public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
     * public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     * @author luoyong
     * @create 22:18 2019/12/25
     * @last modify by [LuoYong 22:18 2019/12/25 ]
     */
    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\test\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    /**
     * @param
     * @return void
     * @Description: 获取某一个文件夹下面的所有文件
     * @author luoyong
     * @create 22:19 2019/12/25
     * @last modify by [LuoYong 22:19 2019/12/25 ]
     */
    @Test
    public void test3() {
        File file = new File("D:\\video");

        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }

    }

    /**
     * @param
     * @return void
     * @Description: 重命名功能
     * public boolean renameTo(File dest):把文件重命名为指定的文件路径
     * 比如：file1.renameTo(file2)为例：
     * 要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
     * @author luoyong
     * @create 22:21 2019/12/25
     * @last modify by [LuoYong 22:21 2019/12/25 ]
     */
    @Test
    public void test4() {
        File file1 = new File("D:\\test\\hello.txt");
        File file2 = new File("D:\\test\\hi.txt");

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

    /**
     * @param
     * @return void
     * @Description: File类的判断功能
     * public boolean isDirectory()：判断是否是文件目录
     * public boolean isFile() ：判断是否是文件
     * public boolean exists() ：判断是否存在
     * public boolean canRead() ：判断是否可读
     * public boolean canWrite() ：判断是否可写
     * public boolean isHidden() ：判断是否隐藏
     * @author luoyong
     * @create 22:27 2019/12/25
     * @last modify by [LuoYong 22:27 2019/12/25 ]
     */
    @Test
    public void test5() {
        File file1 = new File("D:\\test\\hi.txt");

        //文件
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        //文件夹
        File file2 = new File("d:\\test");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }

    /**
     * @param
     * @return void
     * @Description: File的创建与删除功能--文件
     * public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
     * 删除磁盘中的文件或文件目录
     * public boolean delete()：删除文件或者文件夹
     * @author luoyong
     * @create 22:32 2019/12/25
     * @last modify by [LuoYong 22:32 2019/12/25 ]
     */
    @Test
    public void test6() throws IOException {
        File file = new File("d:\\test\\test6.txt");
        if (file.exists()) {
            //文件存在 删除
            boolean delete = file.delete();
            if (delete) {
                System.out.println("删除文件成功");
            }
        } else {
            //文件不存在 创建
            boolean newFile = file.createNewFile();
            if (newFile) {
                System.out.println("创建文件成功");
            }
        }
    }

    /**
     * @param
     * @return void
     * @Description: 文件的删除与创建--文件夹
     * public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     * public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建
     * 删除磁盘中的文件或文件目录
     * public boolean delete()：删除文件或者文件夹
     * @author luoyong
     * @create 22:40 2019/12/25
     * @last modify by [LuoYong 22:40 2019/12/25 ]
     */
    @Test
    public void test7() {
        //文件目录的创建
        File file1 = new File("d:\\test\\test7");
        boolean mkdir = file1.mkdir();
        if (mkdir) {
            System.out.println("文件夹1创建成功");
        }
        //mkdirs
        File file2 = new File("d:\\test\\test701\\test70101");
        boolean mkdirs = file2.mkdirs();
        if (mkdirs) {
            System.out.println("文件夹2创建成功");
        }

        //注意：要想删除成功 test701下面不能有子目录或者文件
        File file3 = new File("d\\test\\test701");
        boolean delete = file3.delete();
        System.out.println(delete);
        if (delete) {
            System.out.println("删除文件夹成功");
        }
    }
}
