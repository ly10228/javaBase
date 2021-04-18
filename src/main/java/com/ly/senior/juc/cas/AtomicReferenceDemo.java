package com.ly.senior.juc.cas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author luoyong
 *  * @create 2021-04-11 10:44 下午
 *  * @last modify by [luoyong 2021-04-11 10:44 下午]
 * @Description: 原子引用
 **/
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z3", 24);
        User li4 = new User("li4", 26);

        AtomicReference<User> atomicReferenceUser = new AtomicReference<>();

        atomicReferenceUser.set(z3);

        System.out.println(atomicReferenceUser.compareAndSet(z3, li4) + "\t" + atomicReferenceUser.get().toString());
        System.out.println(atomicReferenceUser.compareAndSet(z3, li4) + "\t" + atomicReferenceUser.get().toString());
    }
}

@Getter
@ToString
@AllArgsConstructor
class User {
    String userName;
    int age;
}
