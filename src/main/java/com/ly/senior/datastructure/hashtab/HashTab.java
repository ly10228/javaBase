package com.ly.senior.datastructure.hashtab;

import lombok.Data;

/**
 * @author luoyong
 * @Description: HashTab 管理多条链表
 * 散列表（Hash table，也叫哈希表）
 * 是根据关键码值(Key value)而直接进行访问的数据结构。
 * 也就是说，它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做散列函数，
 * 存放记录的数组叫做散列表。
 * @create 2020-06-20 15:42
 * @last modify by [LuoYong 2020-06-20 15:42]
 **/
@Data
public class HashTab {
    private EmpLinkedList[] empLinkedArray;
    //表示有多少条链表 数组的长度
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedArray = new EmpLinkedList[size];
        for (int i = 0; i < empLinkedArray.length; i++) {
            //初始化数组下面的所有链表 避免空指针异常
            empLinkedArray[i] = new EmpLinkedList();
        }
    }

    /**
     * @param emp
     * @return void
     * @Description: 新增
     * @author luoyong
     * @create 15:47 2020/6/20
     * @last modify by [LuoYong 15:47 2020/6/20 ]
     */
    public void add(Emp emp) {
        //员工id
        int id = emp.getId();
        //要往哪个链表当中添加
        int empLinkedListNO = hashFun(id);
        empLinkedArray[empLinkedListNO].add(emp);
    }


    /**
     * @param
     * @return void
     * @Description: 遍历hashTable
     * @author luoyong
     * @create 15:50 2020/6/20
     * @last modify by [LuoYong 15:50 2020/6/20 ]
     */
    public void list() {
        for (int i = 0; i < empLinkedArray.length; i++) {
            empLinkedArray[i].list(i);
        }
    }


    /**
     * @param id 员工id
     * @return
     * @Description: 通过员工id查找id
     * @author luoyong
     * @create 15:53 2020/6/20
     * @last modify by [LuoYong 15:53 2020/6/20 ]
     */
    public Emp findEmpById(int id) {
        //要往哪个链表当中查询
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedArray[empLinkedListNO].findById(id);
        if (null == emp) {
            System.out.println("在哈希表当中没有找到该员工");
        } else {
            System.out.printf("在第%d条链表中找到 雇员id=%d\n", (empLinkedListNO + 1), id);
        }
        return emp;
    }

    /**
     * @param id
     * @return int
     * @Description: 编写散列函数 使用一个简单取模法
     * @author luoyong
     * @create 15:48 2020/6/20
     * @last modify by [LuoYong 15:48 2020/6/20 ]
     */
    private int hashFun(int id) {
        return id % size;
    }


}
