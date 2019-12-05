package com.ly.base.reflect.exer;

/**
 * @author luoyong
 * @Description: Person
 * @create 2019-12-05 23:17
 * @last modify by [LuoYong 2019-12-05 23:17]
 **/
public class Person extends Creature<String> implements MyInterface,Comparable<String> {

    private String name;

    int age;

    public int id;

    public Person() {
    }

    @MyAnnotation(value = "一个参数的构造方法")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是:" + nation);
        return nation;
    }

    public String display(String interests, int age) {
        return interests + age;
    }

    @Override
    public void info() {
        System.out.println("我是一个程序员");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }


    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
