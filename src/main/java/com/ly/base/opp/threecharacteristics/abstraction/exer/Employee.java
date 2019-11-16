package com.ly.base.opp.threecharacteristics.abstraction.exer;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Employee
 * @create 2019-11-16 22:07
 * @last modify by [LuoYong 2019-11-16 22:07]
 **/
@Data
public abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee() {
        super();
    }

    public Employee(String name, int id, double salary) {
        super();
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

}
