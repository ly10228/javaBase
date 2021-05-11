package com.ly.base.jvm.gc.concept.reference;

import com.ly.base.jvm.gc.concept.reference.dto.User;

import java.lang.ref.WeakReference;

/**
 * @author luoyong
 *  * @create 2021-02-25 2:33 下午
 *  * @last modify by [luoyong 2021-02-25 2:33 下午]
 * @Description: 若引用
 **/
public class WeakReferenceTest {

    public static void main(String[] args) {
        //构造弱引用
        WeakReference<User> userWeakReference = new WeakReference<>(new User(1, "ly001"));

        //从弱引用中重新获取对象
        System.out.println(userWeakReference.get());

        System.gc();

        //不管当前内存是否足够 都会回收ta它的内存
        System.out.println("After GC:");

        //重新尝试从弱引用中获取对象
        System.out.println(userWeakReference.get());
    }
}