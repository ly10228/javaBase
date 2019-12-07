package com.ly.base.reflect.exer.dto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 * @author luoyong
 * @Description: MyAnnotation
 * @create 2019-12-05 23:12
 * @last modify by [LuoYong 2019-12-05 23:12]
 **/
@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {
    String methodName() default "我是一个方法";
}
