package com.ly.senior.designpatterns.structured.composite;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Department
 * @create 2019-09-14 23:27
 * @last modify by [LuoYong 2019-09-14 23:27]
 **/
@Data
public class Department extends OrganizationComponent {

    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }
}
