package com.ly.oop.inherit.dto;

/**
 * @author luoyong
 * @Description: Person
 * @create 2019-07-08 23:19
 * @last modify by [LuoYong 2019-07-08 23:19]
 **/
public class Person extends Creature {
    public String name;
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
