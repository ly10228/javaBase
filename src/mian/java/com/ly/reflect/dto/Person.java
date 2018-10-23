package com.ly.reflect.dto;

import lombok.Data;

/**
 * @author dell
 * @Description: dto
 * @create 2018-10-16 23:57
 * @last modify by [dell 2018-10-16 23:57]
 **/
@Data
public class Person {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    int age;
    /**
     * 住址
     */
    public String address;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void show() {
        System.out.println("show");
    }

    public void method(String s) {
        System.out.println("method " + s);
    }

    public String getString(String s, int i) {
        return s + "---" + i;
    }

    private void function() {
        System.out.println("function");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address=" + address
                + "]";
    }
}
