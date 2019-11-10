package com.ly.base.opp.object;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author luoyong
 *  * @create 2019-11-10 11:35
 *  * @last modify by [luoyong 2019-11-10 11:35]
 * @Description: Customer
 **/
@Getter
@Setter
public class Customer {

    private String name;

    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
