package com.ly.base.reflect;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author luoyong
 * @Description: ClassLoaderTest
 * @create 2019-12-03 23:10
 * @last modify by [LuoYong 2019-12-03 23:10]
 **/
public class ClassLoaderTest {

    @Test
    public void test1() {
        //1:对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);

        //2:调用系统类加载器的getParent()获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        //sun.misc.Launcher$ExtClassLoader@3af49f1c
        System.out.println(classLoader1);

        //3:调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java核心类库，无法加载自定义的类
        ClassLoader classLoader2 = classLoader1.getParent();
        //null
        System.out.println(classLoader2);

        //String就是内库当中的一员
        ClassLoader classLoader3 = String.class.getClassLoader();
        //null
        System.out.println(classLoader3);
    }

    /**
     * @param
     * @return void
     * @Description: 类加载器读取配置文件
     * @author luoyong
     * @create 23:21 2019/12/3
     * @last modify by [LuoYong 23:21 2019/12/3 ]
     */
    @Test
    public void testReadConfigurationFile() throws Exception {
        Properties properties = new Properties();
        //读取配置文件的方式一：
        FileInputStream fis = new FileInputStream("src/main/java/com/ly/base/reflect/jdbc.properties");
        properties.load(fis);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);

        Properties properties1 = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("jdbc1.properties");
        properties1.load(inputStream);
        String user1 = properties1.getProperty("user");
        String password1 = properties1.getProperty("password");
        System.out.println("user1 = " + user1 + ",password1 = " + password1);

    }
}
