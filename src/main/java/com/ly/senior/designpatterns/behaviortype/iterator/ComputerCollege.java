package com.ly.senior.designpatterns.behaviortype.iterator;

import lombok.Data;

import java.util.Iterator;

/**
 * @author luoyong
 * @Description: ComputerCollege
 * @create 2019-09-21 22:41
 * @last modify by [LuoYong 2019-09-21 22:41]
 **/
@Data
public class ComputerCollege implements College {

    /**
     * 组合Department
     */
    private Department[] departments;

    /**
     * 保存当前数组的对象个数
     */
    int numOfDepartment = 0;


    public ComputerCollege() {
        this.departments = new Department[5];
        addDepartment("Java专业", " Java专业 ");
        addDepartment("PHP专业", " PHP专业 ");
        addDepartment("大数据专业", " 大数据专业 ");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartment] = department;
        numOfDepartment += 1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
