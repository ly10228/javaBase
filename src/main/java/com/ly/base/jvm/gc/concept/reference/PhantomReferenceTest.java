package com.ly.base.jvm.gc.concept.reference;

import java.lang.ref.ReferenceQueue;

/**
 * @author luoyong
 *  * @create 2021-02-25 2:44 下午
 *  * @last modify by [luoyong 2021-02-25 2:44 下午]
 * @Description: 虚引用
 **/
public class PhantomReferenceTest {

    //当前类对象的声明
    public static PhantomReferenceTest obj;

    //引用队列
    static ReferenceQueue<PhantomReferenceTest> phantomQueue = null;


}
