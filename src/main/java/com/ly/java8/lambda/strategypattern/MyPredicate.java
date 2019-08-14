package com.ly.java8.lambda.strategypattern;

/**
 * @author luoyong
 *  * @create 2019-08-14 20:51
 *  * @last modify by [luoyong 2019-08-14 20:51]
 * @Description: MyPredicate
 **/
public interface MyPredicate<T> {

    /**
     * @param t 对象
     * @return boolean
     * @Description: isFit
     * @author luoyong
     * @create 20:52 2019-08-14
     * @last modify by [luoyong 20:52 2019-08-14 ]
     */
    boolean isFit(T t);
}
