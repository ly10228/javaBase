package com.ly.base.collection.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author luoyong
 * @Description: Person
 * @create 2019-12-09 23:13
 * @last modify by [LuoYong 2019-12-09 23:13]
 **/
@Getter
@Setter
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person equals()....");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
