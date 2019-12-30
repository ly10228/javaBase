package com.ly.base.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author luoyong
 *  * @create 2019-12-08 20:38
 *  * @last modify by [luoyong 2019-12-08 20:38]
 * @Description: MyAnnotation
 **/

@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
public @interface MyAnnotation {
    String value() default "hello";
}
