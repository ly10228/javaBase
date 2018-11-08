package com.ly.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author dell
 * @Description: TODO
 * @create 2018-11-08 8:17
 * @last modify by [dell 2018-11-08 8:17]
 **/
public class MethodDemo {
    public static void main(String[] args) throws Exception {
        //1:获取字节码文件对象
        Class c = Class.forName("com.ly.reflect.dto.Person");
        //2:获取父类+自己的所有公有方法
        getYourOwnerCommonMethodOfaddingTheParent(c);
        System.out.println("=================================");
        //3:获取父类+自己所有的方法
        getYourOwnerAllMethodOfaddingTheParent(c);
        System.out.println("=================================");
        //4:获取单个方法并调用
        getSingleMethodAndCallIt(c);

    }

    /**
     * 获取自己+父类的所有公共方法
     *
     * @param c 字节码文件
     */
    private static void getYourOwnerCommonMethodOfaddingTheParent(Class c) {
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * 获取自己+父类的所有方法
     *
     * @param c 字节码文件
     */
    private static void getYourOwnerAllMethodOfaddingTheParent(Class c) {
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * 获取单个方法并调用
     *
     * @param c 字节码文件
     */
    private static void getSingleMethodAndCallIt(Class c) throws Exception {
        //1:获取对象
        Constructor con = c.getConstructor();
        Object obj = con.newInstance();
        //获取单个方法并使用
        // public Method getMethod(String name,Class<?>... parameterTypes)

        //第一个参数表示的方法名，第二个参数表示的是方法的参数的class类型
        Method m1 = c.getMethod("show");
        m1.invoke(obj);//调用obj对象的m1方法 也就是show方法
        System.out.println("----------");
        // public void method(String s)
        Method m2 = c.getMethod("method", String.class);
        m2.invoke(obj, "hello");
        System.out.println("----------");

        // public String getString(String s, int i)
        Method m3 = c.getMethod("getString", String.class, int.class);
        Object objString = m3.invoke(obj, "hello", 100);
        System.out.println(objString);
        // String s = (String)m3.invoke(obj, "hello",100);
        // System.out.println(s);
        System.out.println("----------");

        // private void function()
        Method m4 = c.getDeclaredMethod("function");
        m4.setAccessible(true);
        m4.invoke(obj);
    }

}
