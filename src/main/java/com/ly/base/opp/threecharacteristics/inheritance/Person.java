package com.ly.base.opp.threecharacteristics.inheritance;

/**
 * @author luoyong
 * @Description: Person
 * @create 2019-10-29 7:56
 * @last modify by [LuoYong 2019-10-29 7:56]
 **/
public class Person extends Creature {
    String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("吃饭");
        sleep();
    }

    private void sleep() {
        System.out.println("睡觉");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
