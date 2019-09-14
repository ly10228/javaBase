package com.ly.senior.designpatterns.structured.composite;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author luoyong
 * @Description: TODO
 * @create 2019-09-14 23:23
 * @last modify by [LuoYong 2019-09-14 23:23]
 **/
public class College extends OrganizationComponent {

    /**
     * 组合系Department
     */
    List<OrganizationComponent> organizationComponents = Lists.newArrayList();

    public College(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        //  将来实际业务中，Colleage 的 add 和  University add 不一定完全一样
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    @Override
    protected void print() {
        System.out.println("--------------" + this.getName() + "--------------");
        organizationComponents.forEach(item -> item.print());
    }
}
