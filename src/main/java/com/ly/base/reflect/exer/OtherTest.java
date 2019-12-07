package com.ly.base.reflect.exer;

import com.ly.base.reflect.exer.dto.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author luoyong
 * @Description: OtherTest
 * @create 2019-12-05 23:49
 * @last modify by [LuoYong 2019-12-05 23:49]
 **/
public class OtherTest {

    private static Class clazz = Person.class;

    /**
     * @return void
     * @Description: 获取运行时类注解
     * @author luoyong
     * @create 09:57 2019-12-07
     * @last modify by [LuoYong 09:57 2019-12-07 ]
     */
    @Test
    public void testGetAnnotations() {
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        System.out.println(Arrays.toString(declaredAnnotations));

    }


    /**
     * @return void
     * @Description: 获取运行时类所在的包
     * @author luoyong
     * @create 10:11 2019-12-07
     * @last modify by [LuoYong 10:11 2019-12-07 ]
     */
    @Test
    public void testGetPackage() {
        Package aPackage = clazz.getPackage();
        //package com.ly.base.reflect.exer.dto
        System.out.println(aPackage);
    }

    /**
     * @return void
     * @Description: 获取运行时类及父类实现的接口
     * @author luoyong
     * @create 10:18 2019-12-07
     * @last modify by [LuoYong 10:18 2019-12-07 ]
     */
    @Test
    public void testGetInterfaces() {
        //获取运行时类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        System.out.println("当前类实现的接口");
        Arrays.stream(interfaces).forEach(System.out::println);

        //获取运行时类父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        System.out.println("父类实现的接口");
        Arrays.stream(interfaces1).forEach(System.out::println);
    }


    /**
     * @return void
     * @Description: 获取运行时的带泛型的父类的泛型
     * @author luoyong
     * @create 10:47 2019-12-07
     * @last modify by [LuoYong 10:47 2019-12-07 ]
     */
    @Test
    public void testGetGenericSuperclassParam() {
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Arrays.stream(actualTypeArguments).forEach(System.out::println);
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class) actualTypeArguments[0]).getName());
    }

    /**
     * @return void
     * @Description: 获取运行时的父类
     * @author luoyong
     * @create 10:56 2019-12-07
     * @last modify by [LuoYong 10:56 2019-12-07 ]
     */
    @Test
    public void testGetGenericSuperclass() {
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }


    /**
     * @return void
     * @Description: 获取运行时类的父类
     * @author luoyong
     * @create 10:58 2019-12-07
     * @last modify by [LuoYong 10:58 2019-12-07 ]
     */
    @Test
    public void testGetSuperclass() {
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /**
     * @return void
     * @Description: 获取运行时类构造器
     * @author luoyong
     * @create 11:01 2019-12-07
     * @last modify by [LuoYong 11:01 2019-12-07 ]
     */
    @Test
    public void testGetConstructors() {
        Constructor[] constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        Arrays.stream(declaredConstructors).forEach(System.out::println);
    }


}
