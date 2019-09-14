package com.ly.senior.designpatterns.structured.composite;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author luoyong
 * @Description: University
 * @create 2019-09-14 23:17
 * @last modify by [LuoYong 2019-09-14 23:17]
 **/
@Data
public class University extends OrganizationComponent {
    /**
     * 组合学院
     */
    List<OrganizationComponent> organizationComponents = Lists.newArrayList();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }


    @Override
    protected void print() {
        System.out.println("--------------" + getName() + "--------------");
        organizationComponents.forEach(item -> item.print());
    }
}
