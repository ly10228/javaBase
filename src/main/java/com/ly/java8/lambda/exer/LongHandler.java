package com.ly.java8.lambda.exer;

/**
 * @author luoyong
 * @Description: LongHandler
 * @create 2019-08-18 10:34
 * @last modify by [LuoYong 2019-08-18 10:34]
 **/
public interface LongHandler<T, R> {
    R handler(T tOne, T tTwo);
}
