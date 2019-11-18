package com.ly.base.opp.threecharacteristics.abstraction.exer2;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Employee 抽象类不能实例化
 * @create 2019-11-17 9:46
 * @last modify by [LuoYong 2019-11-17 9:46]
 **/
@Data
public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public Employee(String name, int number, MyDate birthday) {
        super();
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return "name=" + name + ", number=" + number + ", birthday=" + birthday.toDateString();
    }


}
