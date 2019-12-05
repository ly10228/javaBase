package com.ly.base.reflect.exer;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author luoyong
 * @Description: FieldTest--获取当前运行时类的属性结构
 * @create 2019-12-05 23:26
 * @last modify by [LuoYong 2019-12-05 23:26]
 **/
public class FieldTest {

    /**
     * @param
     * @return void
     * @Description: 获取属性集合
     * getFields()
     * getDeclaredFields()
     * @author luoyong
     * @create 23:33 2019/12/5
     * @last modify by [LuoYong 23:33 2019/12/5 ]
     */
    @Test
    public void getFields() {
        Class<Person> personClass = Person.class;
        //获取属性结构
        //getFields() 获取当前运行时类父类中声明为public访问权限的属性
        Field[] fields = personClass.getFields();
        System.out.println(Arrays.toString(fields));

        //getDeclaredFields()获取当前运行时类中所有的属性--》不包含父类当中的声明的属性
        Field[] declaredFields = personClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
    }


    /**
     * @param
     * @return void
     * @Description: 获取属性的权限修饰符+数据类型+变量名称
     * @author luoyong
     * @create 23:42 2019/12/5
     * @last modify by [LuoYong 23:42 2019/12/5 ]
     */
    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //1:权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //2:数据类型
            Class type = field.getType();
            System.out.println(type.getName() + "\t");

            //变量名
            String fieldName = field.getName();
            System.out.println(fieldName);

            System.out.println();
        }
    }

}
