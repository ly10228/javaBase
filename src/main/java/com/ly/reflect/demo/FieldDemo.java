package com.ly.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author dell
 * @Description: 通过发生获取成员变量并使用
 * @create 2018-11-07 22:51
 * @last modify by [dell 2018-11-07 22:51]
 **/
public class FieldDemo {
    public static void main(String[] args) throws Exception {
        //1:获取字节码文件
        Class c = Class.forName("com.ly.reflect.dto.Person");
        //2:获取所有的公有成员变量
        getAllPublicFiled(c);
        System.out.println("=================================");
        //3:获取所有的成员变量
        getAllFiled(c);
        System.out.println("=================================");
        //4:获取成员变量并赋值
        getMemberVariablesAndAssignValues(c);
    }

    /**
     * 获取所有的公有成员变量
     *
     * @param c 字节码文件
     */
    private static void getAllPublicFiled(Class c) {
        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    /**
     * 获取所有的成员变量
     *
     * @param c 字节码文件
     */
    private static void getAllFiled(Class c) {
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    /**
     * 获取成员变量并赋值
     *
     * @param c 字节码文件
     */
    private static void getMemberVariablesAndAssignValues(Class c) throws Exception {
        //1:通过无构造方法获取对象
        Constructor con = c.getConstructor();
        Object object = con.newInstance();//初始化对象
        System.out.println(object);
        //2:获取对象变量 并赋值
        Field nameField = c.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(object, "张三");

        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(object, 22);

        Field addressField = c.getDeclaredField("address");
        addressField.setAccessible(true);
        addressField.set(object, "北京东路");// // 给object对象的addressField字段设置值为"北京东路"
        System.out.println(object);
    }

}
