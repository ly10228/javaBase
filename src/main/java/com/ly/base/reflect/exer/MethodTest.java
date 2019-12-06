package com.ly.base.reflect.exer;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author luoyong
 * @Description: MethodTest--获取运行时类的方法结构
 * @create 2019-12-05 23:42
 * @last modify by [LuoYong 2019-12-05 23:42]
 **/
public class MethodTest {

    /**
     * @param
     * @return void
     * @Description: 获取运行时所有的方法
     * @author luoyong
     * @create 23:43 2019/12/5
     * @last modify by [LuoYong 23:43 2019/12/5 ]MethodTest
     */
    @Test
    public void listAllMethod() {
        Class<Person> personClass = Person.class;
        //获取运行时类和父类权限修饰符为public的方法
        Method[] methods = personClass.getMethods();
        System.out.println(Arrays.toString(methods));

        //获取当前运行时类声明所有的方法
        Field[] declaredFields = personClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

    }
}
