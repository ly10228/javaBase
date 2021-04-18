package com.ly.senior.juc.atomics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author luoyong
 *  * @create 2021-04-18 4:03 下午
 *  * @last modify by [luoyong 2021-04-18 4:03 下午]
 * @Description: 引用类型原子类
 **/
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z33", 24);
        User li4 = new User("li44", 26);

        AtomicReference<User> atomicReferenceUser = new AtomicReference<>();

        atomicReferenceUser.set(z3);

        System.out.println(atomicReferenceUser.compareAndSet(z3, li4) + "\t" + atomicReferenceUser.get().toString());
        System.out.println(atomicReferenceUser.compareAndSet(z3, li4) + "\t" + atomicReferenceUser.get().toString());

    }
}


@ToString
@AllArgsConstructor
@Getter
class User {
    String userName;
    int age;
}
