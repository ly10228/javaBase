package com.ly.java8.lambda.strategypattern;

/**
 * @author luoyong
 *  * @create 2019-08-14 20:47
 *  * @last modify by [luoyong 2019-08-14 20:47]
 * @Description: MyFun
 **/
@FunctionalInterface
public interface MyFun {
    Integer getValue(Integer num);
}
