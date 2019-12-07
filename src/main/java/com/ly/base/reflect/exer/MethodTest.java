package com.ly.base.reflect.exer;

import com.ly.base.reflect.exer.dto.MethodAnnotation;
import com.ly.base.reflect.exer.dto.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
        //获取运行时类及其所有父类权限修饰符为public的方法
        Method[] methods = personClass.getMethods();
        Arrays.stream(methods).forEach(System.out::println);

        //获取当前运行时类声明所有的方法-->不包含父类当中申请的
        System.out.println("获取当前运行时类声明所有的方法-->不包含父类当中申请的");
        Field[] declaredFields = personClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out::println);
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
            System.out.println("方法是:" + method);
            //1:获取方法上面的注解
            Annotation[] annotations = method.getAnnotations();
            Arrays.stream(annotations).forEach(item -> System.out.println(item));

            //获取指定的注解
            Optional<MethodAnnotation> methodAnnotationOptional = getMethodAnnotation(method);
            if (methodAnnotationOptional.isPresent()) {
                System.out.println("方法有注解");
                //存在值
                System.out.println(methodAnnotationOptional);
                MethodAnnotation methodAnnotation = methodAnnotationOptional.get();
                System.out.println(methodAnnotation.methodName());

            } else {
                System.out.println("方法上无注解");
            }
            //2:获取权限修饰符
            int modifiers = method.getModifiers();
            System.out.println("方法的权限修饰符是:" + Modifier.toString(modifiers));


            //3:获取返回值类型
            Class returnType = method.getReturnType();
            System.out.println("方法的返回值类型是:" + returnType.getName());

            System.out.println();
            //4:获取方法名
            String name = method.getName();
            System.out.print("方法名称是:" + name);
            System.out.print("(");
            //5:形参列表

            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes != null && parameterTypes.length > 0) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        //参数数组最后的一个元素
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }
            System.out.print(")");

            System.out.println();
            //6:抛出的异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        //数组最后一个元素
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

            System.out.println();
        }
    }


    private Optional<MethodAnnotation> getMethodAnnotation(Method method) {
        MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
        return Optional.ofNullable(methodAnnotation);
    }

}
