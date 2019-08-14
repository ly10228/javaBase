package com.ly.java8.lambda.dto;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2019-08-14 16:10
 *  * @last modify by [luoyong 2019-08-14 16:10]
 * @Description: Employee
 **/
@Data
public class Employee {
    /**
     * 主键id
     */
    private int id;
    /**
     * 员工名称
     */
    private String name;
    /**
     * 员工年龄
     */
    private int age;
    /**
     * 员工薪资
     */
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
