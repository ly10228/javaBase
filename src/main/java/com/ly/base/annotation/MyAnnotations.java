package com.ly.base.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author luoyong
 *  * @create 2019-12-08 20:40
 *  * @last modify by [luoyong 2019-12-08 20:40]
 * @Description: MyAnnotations
 **/
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
public @interface MyAnnotations {

    //成员变量
    MyAnnotation[] value();
}
