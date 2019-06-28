package com.ly.reflect.demo;

import com.ly.reflect.dto.Person;

import java.lang.reflect.Constructor;

/**
 * @author dell
 * @Description: 通过反射获取构造方法并使用
 * @create 2018-11-06 22:02
 * @last modify by [dell 2018-11-06 22:02]
 **/
public class ConstructorDemo {
    public static void main(String[] args) throws Exception {
        //1:获取字节码文件
        Class c = Class.forName("com.ly.reflect.dto.Person");
        //2:获取所有公共构造方法 并打印
        showGetConstructors(c);
        System.out.println("=================================");
        //3:获取所有构造方法 并打印
        showGetDeclaredConstructors(c);
        //4:获取单个构造方法
        System.out.println("=================================");
        //4.1 无参构造方法
        Person p = (Person) getSingleConstructor(c);
        p.show();
        System.out.println("=================================");
        //4.2 带参构造方法
        Person pWithParam = (Person) getSingleConstructorWithParam(c);
        pWithParam.show();
        System.out.println("=================================");
        //4.3 ：通过反射获取私有构造方法并使用
        Person pPrivate = (Person) getPrivateSingleConstructorWithParam(c);
        pPrivate.show();
    }

    /**
     * 获取所有公共构造方法 并打印
     * public Constructor[] getConstructors():所有公共构造方法
     *
     * @param c Person类的字节码文件
     */
    private static void showGetConstructors(Class c) {
        Constructor[] cons = c.getConstructors();
        print(cons);
    }

    /**
     * 获取所有构造方法 并打印
     * public Constructor[] getDeclaredConstructors():所有构造方法
     *
     * @param c Person类的字节码文件
     */
    private static void showGetDeclaredConstructors(Class c) {
        Constructor[] cons = c.getDeclaredConstructors();
        print(cons);
    }


    /**
     * public Constructor<T> getConstructor(Class<?>... parameterTypes)
     * parameterTypes表示：
     * 你要获取的构造方法的构造参数个数及数据类型的class字节码文件对象
     *
     * @param c Person类的字节码文件
     * @return
     */
    private static Object getSingleConstructor(Class c) throws Exception {
        Constructor con = c.getConstructor();// 返回的是构造方法对象
        /**
         * public T newInstance(Object... initargs)
         * 使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
         */
        Object obj = con.newInstance();
        System.out.println(obj);
        return obj;
    }


    /**
     * 通过反射获取带参构造函数并使用
     * public Person(String name, int age, String address)
     * public Constructor<T> getConstructor(Class<?>... parameterTypes)
     * parameterTypes表示：
     * 你要获取的构造方法的构造参数个数及数据类型的class字节码文件对象
     *
     * @param c Person类的字节码文件
     * @return
     */
    private static Object getSingleConstructorWithParam(Class c) throws Exception {
        Constructor con = c.getConstructor(String.class, int.class, String.class);// 返回的是构造方法对象
        /**
         * public T newInstance(Object... initargs)
         * 使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
         */
        Object obj = con.newInstance("众小安", 5, "上海市黄浦区外滩");
        System.out.println(obj);
        return obj;
    }


    /**
     * 通过反射获取私有带参构造函数并使用
     * private Person(String name){}
     * public Constructor<T> getConstructor(Class<?>... parameterTypes)
     * parameterTypes表示：
     * 你要获取的构造方法的构造参数个数及数据类型的class字节码文件对象
     *
     * @param c Person类的字节码文件
     * @return
     */
    private static Object getPrivateSingleConstructorWithParam(Class c) throws Exception {
        Constructor con = c.getDeclaredConstructor(String.class);// 返回的是构造方法对象
        /**
         * public T newInstance(Object... initargs)
         * 使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
         */
        con.setAccessible(true);
        // 用该私有构造方法创建对象
        // IllegalAccessException:非法的访问异常。
        // 暴力访问
        Object obj = con.newInstance("众小安");// 值为true则指示反射的对象在使用时应该取消Java语言访问检查。
        System.out.println(obj);
        return obj;
    }


    /**
     * 打印构造方法到控制台
     *
     * @param cons
     */
    private static void print(Constructor[] cons) {
        for (Constructor con : cons) {
            System.out.println(con);
        }
    }
}
