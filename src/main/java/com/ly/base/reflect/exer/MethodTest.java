package com.ly.base.reflect.exer;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

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

    /**
     * @return void
     * @Description: 获取方法对应的属性
     * @author luoyong
     * @create 23:24 2019-12-06
     * @last modify by [luoyong 23:24 2019-12-06 ]
     */
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        //获取当前运行类声明的所有的方法
        Method[] declaredMethods = personClass.getDeclaredMethods();

        System.out.println(declaredMethods.length);
        System.out.println(Arrays.toString(declaredMethods));

        for (Method method : declaredMethods) {
            //1:获取方法上面的注解
            Annotation[] annotations = method.getAnnotations();
            Arrays.stream(annotations).forEach(item -> System.out.println(item));

            //获取指定的注解
            Optional<MethodAnnotation> methodAnnotation = getMethodAnnotation(method);
            if (!methodAnnotation.isPresent()) {
                //存在值
                System.out.println(methodAnnotation);
            }

            System.out.println();
        }
    }


    private Optional<MethodAnnotation> getMethodAnnotation(Method method) {
        MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
        return Optional.ofNullable(methodAnnotation);
    }

}
