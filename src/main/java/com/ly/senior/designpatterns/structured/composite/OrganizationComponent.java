package com.ly.senior.designpatterns.structured.composite;

import lombok.Data;

/**
 * @author luoyong
 * @Description: OrganizationComponent
 * @create 2019-09-14 23:15
 * @last modify by [LuoYong 2019-09-14 23:15]
 **/
@Data
public abstract class OrganizationComponent {
    private String name;
    private String desc;

    public OrganizationComponent(String name, String desc) {
        super();
        this.name = name;
        this.desc = desc;
    }

    protected void add(OrganizationComponent organizationComponent) {
        //默认实现
        throw new UnsupportedOperationException();
    }


    protected void remove(OrganizationComponent organizationComponent) {
        //默认实现
        throw new UnsupportedOperationException();
    }


    /**
     * 方法print, 做成抽象的, 子类都需要实现
     */
    protected abstract void print();

}
