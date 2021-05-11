package com.ly.senior.jvm.classload.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author luoyong
 *  * @create 2021-05-05 3:09 下午
 *  * @last modify by [luoyong 2021-05-05 3:09 下午] @Description: 自定义类加载器
 **/
public class UserClassLoader extends ClassLoader {
    private String rootDir;

    public UserClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }


    /**
     * 编写findClass方法的逻辑
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类的class文件字节数组
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            //直接生成class对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 编写获取class文件并转换为字节码流的逻辑 * @param className * @return
     */
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            // 读取类文件的字节码
            while ((len = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 类文件的完全路径
     */
    private String classNameToPath(String className) {
        return rootDir + "/" + className.replace('.', '/') + ".class";
    }

    public static void main(String[] args) {
        ///Users/luoyong/za/code/ly/javaBase/target/classes/com/ly/senior/jvm/classload/classloader/User.class
        String rootDir = "/Users/luoyong/za/code/ly/javaBase/target/classes";

        try {
            //创建自定义的类的加载器1
            UserClassLoader loader1 = new UserClassLoader(rootDir);
            Class clazz1 = loader1.findClass("com.ly.senior.jvm.classload.classloader.User");

            //创建自定义的类的加载器2
            UserClassLoader loader2 = new UserClassLoader(rootDir);
            Class clazz2 = loader2.findClass("com.ly.senior.jvm.classload.classloader.User");

            //clazz1与clazz2对应了不同的类模板结构。实现了加载类的隔离
            System.out.println(clazz1 == clazz2);
            System.out.println(clazz1.getClassLoader());
            System.out.println("clazz1 parent is" + clazz1.getClassLoader().getParent());
            System.out.println(clazz2.getClassLoader());
            System.out.println("clazz2 parent is" + clazz2.getClassLoader().getParent());

            //######################
            Class clazz3 = ClassLoader.getSystemClassLoader().loadClass("com.ly.senior.jvm.classload.classloader.User");
            System.out.println(clazz3.getClassLoader());

            System.out.println(clazz1.getClassLoader().getParent());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
