package com.ly.base.opp.threecharacteristics.polymorphism.runtimebehavior;

import java.util.Random;

/**
 * @author luoyong
 * @Description: 多态是编译时行为还是运行时行为？ 运行时行为 --》证明代码入下所示
 * @create 2019-11-04 22:19
 * @last modify by [LuoYong 2019-11-04 22:19]
 **/
public class InterviewTest {

    /**
     * @param
     * @return void
     * @Description: 证明多态是运行时行为
     * 因为在编译期间看不出到底执行的是什么行为
     * @author luoyong
     * @create 22:21 2019/11/4
     * @last modify by [LuoYong 22:21 2019/11/4 ]
     */
    public static void main(String[] args) {
        int key = new Random().nextInt(3);

        System.out.println(key);

        Animal animal = getInstance(key);

        animal.eat();
    }

    public static Animal getInstance(int key) {
        switch (key) {
            case 0:
                return new Cat();
            case 1:
                return new Dog();
            default:
                return new Sheep();
        }

    }
}

class Animal {

    protected void eat() {
        System.out.println("animal eat food");
    }
}

class Cat extends Animal {

    protected void eat() {
        System.out.println("cat eat fish");
    }
}

class Dog extends Animal {

    public void eat() {
        System.out.println("Dog eat bone");

    }

}

class Sheep extends Animal {


    public void eat() {
        System.out.println("Sheep eat grass");

    }


}