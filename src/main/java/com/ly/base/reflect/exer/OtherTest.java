package com.ly.base.reflect.exer;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author luoyong
 * @Description: OtherTest
 * @create 2019-12-05 23:49
 * @last modify by [LuoYong 2019-12-05 23:49]
 **/
public class OtherTest {
    @Test
    public void test7() {
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        System.out.println(Arrays.toString(declaredAnnotations));

    }
}
