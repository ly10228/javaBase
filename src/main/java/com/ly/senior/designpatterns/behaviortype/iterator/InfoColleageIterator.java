package com.ly.senior.designpatterns.behaviortype.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author luoyong
 * @Description: InfoColleageIterator
 * @create 2019-09-21 22:57
 * @last modify by [LuoYong 2019-09-21 22:57]
 **/
public class InfoColleageIterator implements Iterator {

    /**
     * 信息工程学院是以List方式存放系
     */
    private List<Department> departments;


    /**
     * 索引
     */
    int index = -1;

    public InfoColleageIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (index >= departments.size() - 1) {
            return false;
        }
        index += 1;
        return true;
    }

    @Override
    public Object next() {
        return departments.get(index);
    }

    @Override
    public void remove() {

    }
}
