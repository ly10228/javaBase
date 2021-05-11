package com.ly.senior.jvm.classload.classloader;

/**
 * @author luoyong
 *  * @create 2021-05-05 3:07 下午
 *  * @last modify by [luoyong 2021-05-05 3:07 下午]
 * @Description: 类加载器
 **/
public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统该类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);
        //试图获取引导类加载器：失败
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        //###########################
        try {
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);
            //自定义的类默认使用系统类加载器
            ClassLoader classLoader1 = Class.forName("com.ly.senior.jvm.classload.classloader.ClassLoaderTest").getClassLoader();
            System.out.println(classLoader1);

            //关于数组类型的加载:使用的类的加载器与数组元素的类的加载器相同
            String[] arrStr = new String[10];
            //null:表示使用的是引导类加载器
            System.out.println(arrStr.getClass().getClassLoader());

            ClassLoaderTest[] arr1 = new ClassLoaderTest[10];
            //sun.misc.Launcher$AppClassLoader@18b4aac2
            System.out.println(arr1.getClass().getClassLoader());

            int[] arr2 = new int[10];
            //null:不需要类的加载器
            System.out.println(arr2.getClass().getClassLoader());


            System.out.println(Thread.currentThread().getContextClassLoader());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
