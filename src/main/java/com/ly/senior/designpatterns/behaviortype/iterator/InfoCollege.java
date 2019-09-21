package com.ly.senior.designpatterns.behaviortype.iterator;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * @author luoyong
 * @Description: InfoCollege
 * @create 2019-09-21 22:54
 * @last modify by [LuoYong 2019-09-21 22:54]
 **/
public class InfoCollege implements College {

    private List<Department> departments;

    public InfoCollege() {
        this.departments = Lists.newArrayList();
        addDepartment("信息安全专业", " 信息安全专业 ");
        addDepartment("网络安全专业", " 网络安全专业 ");
        addDepartment("服务器安全专业", " 服务器安全专业 ");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoColleageIterator(departments);
    }


}
