package com.ly.senior.designpatterns.principle.demeter.improve;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author luoyong
 * @Description: DemeterBad 迪米特法则 一个类对自己依赖的类知道的越少越好 改进
 * @create 2019-09-02 22:24
 * @last modify by [LuoYong 2019-09-02 22:24]
 **/
public class DemeterImprove {
    @Test
    public void test() {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

/**
 * 学校总部员工类
 */
class Employee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


/**
 * 学院员工类
 */
class CollegeEmployee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


/**
 * 管理学院员工的管理类
 */
class CollegeManager {
    /**
     * @param
     * @return
     * @Description: 返回学院的所有员工
     * @author luoyong
     * @create 22:26 2019/9/2
     * @last modify by [LuoYong 22:26 2019/9/2 ]
     */
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            //这里我们增加了10个员工到 list
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    /**
     * @param
     * @return void
     * @Description: 打印学院员工的所有信息(id)
     * @author luoyong
     * @create 22:31 2019/9/2
     * @last modify by [LuoYong 22:31 2019/9/2 ]
     */
    void printCollegeAllEmployee() {
        List<CollegeEmployee> list1 = this.getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}

/**
 * 学校管理类
 * 直接朋友：成员变量 方法参数 方法返回值
 * SchoolManager 类的直接朋友类有哪些 Employee、CollegeManager
 * CollegeEmployee 不是 直接朋友 而是一个陌生类，这样违背了 迪米特法则
 */
class SchoolManager {
    /**
     * @param
     * @return
     * @Description: 返回学校总部的员工
     * @author luoyong
     * @create 22:27 2019/9/2
     * @last modify by [LuoYong 22:27 2019/9/2 ]
     */
    public List<Employee> getAllEmployee() {
        List<Employee> list = Lists.newArrayList();
        //这里我们增加了5个员工到 list
        for (int i = 0; i < 5; i++) {
            //这里我们增加了5个员工到 list
            Employee emp = new Employee();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    /**
     * @param sub
     * @return void
     * @Description: 该方法完成输出学校总部和学院员工信息(id)
     * @author luoyong
     * @create 22:28 2019/9/2
     * @last modify by [LuoYong 22:28 2019/9/2 ]
     */
    void printAllEmployee(CollegeManager sub) {
        //打印所有学院员工信息
        sub.printCollegeAllEmployee();
        //获取到学校总部员工
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
