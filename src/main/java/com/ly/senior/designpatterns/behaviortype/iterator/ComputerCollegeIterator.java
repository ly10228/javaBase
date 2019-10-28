package com.ly.senior.designpatterns.behaviortype.iterator;

import java.util.Iterator;

/**
 * @author luoyong
 * @Description: ComputerCollegeIterator
 * @create 2019-09-21 22:49
 * @last modify by [LuoYong 2019-09-21 22:49]
 **/
public class ComputerCollegeIterator implements Iterator {
    /**
     * 这里我们需要Department 是以怎样的方式存放=>数组
     */
    Department[] departments;

    /**
     * 遍历的位置
     */
    int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    /**
     * @param
     * @return boolean
     * @Description: 判断是否还有下一个元素
     * @author luoyong
     * @create 22:52 2019/9/21
     * @last modify by [LuoYong 22:52 2019/9/21 ]
     */
    @Override
    public boolean hasNext() {
        if (position >= departments.length || null == departments[position]) {
            return false;
        }
        return true;
    }

    /**
     * @param
     * @return java.lang.Object
     * @Description: 返回当前的元素
     * @author luoyong
     * @create 22:52 2019/9/21
     * @last modify by [LuoYong 22:52 2019/9/21 ]
     */
    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }

    public void remove() {

    }
}
