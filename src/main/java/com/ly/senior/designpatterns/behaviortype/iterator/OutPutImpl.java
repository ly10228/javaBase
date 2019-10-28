package com.ly.senior.designpatterns.behaviortype.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author luoyong
 * @Description: OutPutImpl
 * @create 2019-09-21 23:01
 * @last modify by [LuoYong 2019-09-21 23:01]
 **/
public class OutPutImpl {
    /**
     * 聚合学院集合
     */
    private List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    /**
     * @param
     * @return void
     * @Description: 遍历所有的学院 然后输出各个学院的院系
     * @author luoyong
     * @create 23:03 2019/9/21
     * @last modify by [LuoYong 23:03 2019/9/21 ]
     */
    public void printCollege() {
        Iterator<College> iterator = collegeList.iterator();
        while (iterator.hasNext()) {
            College college = iterator.next();
            System.out.println("=================" + college.getName() + "==================");
            //得到不同学院对应的迭代器
            printDepartment(college.createIterator());
        }
    }

    /**
     * @param iterator
     * @return void
     * @Description: 学院输出系
     * @author luoyong
     * @create 23:06 2019/9/21
     * @last modify by [LuoYong 23:06 2019/9/21 ]
     */
    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department department = (Department) iterator.next();
            System.out.println(department.getName());
        }
    }

}
