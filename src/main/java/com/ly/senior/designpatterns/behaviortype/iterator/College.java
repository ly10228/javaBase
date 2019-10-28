package com.ly.senior.designpatterns.behaviortype.iterator;

import java.util.Iterator;

/**
 * @author luoyong
 * @Description: College
 * @create 2019-09-21 22:36
 * @last modify by [LuoYong 2019-09-21 22:36]
 **/
public interface College {

    String getName();

    /**
     * @param name
     * @param desc
     * @return void
     * @Description: 增加系
     * @author luoyong
     * @create 22:41 2019/9/21
     * @last modify by [LuoYong 22:41 2019/9/21 ]
     */
    void addDepartment(String name, String desc);

    /**
     * @param
     * @return java.util.Iterator
     * @Description: 创建一个迭代器
     * @author luoyong
     * @create 22:41 2019/9/21
     * @last modify by [LuoYong 22:41 2019/9/21 ]
     */
    Iterator createIterator();
}
