package com.ly.base.reflect.exer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author luoyong
 * @Description: MyAnnotation
 * @create 2019-12-05 23:12
 * @last modify by [LuoYong 2019-12-05 23:12]
 **/
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello我是默认值";
}
