package com.ly.senior.designpatterns.behaviortype.visitor;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author luoyong
 * @Description: ObjectStructure
 * @create 2019-09-16 23:16
 * @last modify by [LuoYong 2019-09-16 23:16]
 **/
public class ObjectStructure {
    /**
     * 维护了一个集合
     */
    private List<Person> persons = Lists.newArrayList();

    /**
     * 增加到list
     *
     * @param p
     */
    public void attach(Person p) {
        persons.add(p);
    }


    /**
     * 移除
     *
     * @param p
     */
    public void detach(Person p) {
        persons.remove(p);
    }

    /**
     * 显示测评情况
     *
     * @param action
     */
    public void display(Action action) {
        for (Person p : persons) {
            p.accept(action);
        }
    }

}
