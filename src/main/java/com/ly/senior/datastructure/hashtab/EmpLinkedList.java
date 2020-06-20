package com.ly.senior.datastructure.hashtab;

/**
 * @author luoyong
 * @Description: EmpLinkedList
 * @create 2020-06-20 13:43
 * @last modify by [LuoYong 2020-06-20 13:43]
 **/
public class EmpLinkedList {
    //头指针 指向第一个emp
    private Emp head;


    /**
     * @param emp 员工
     * @return void
     * @Description: 添加员工到链表当中
     * @author luoyong
     * @create 13:45 2020/6/20
     * @last modify by [LuoYong 13:45 2020/6/20 ]
     */
    public void add(Emp emp) {
        if (null == head) {
            //当前要添加的员工是第一个员工
            head = emp;
            return;
        }
        Emp currentEmp = head;
        //循环
        while (true) {
            if (null == currentEmp.getNext()) {
                break;
            }
            currentEmp = currentEmp.getNext();
        }
        currentEmp.setNext(emp);
    }

    /**
     * @param no 第几个链表
     * @return void
     * @Description: 遍历链表员工的信息
     * @author luoyong
     * @create 13:52 2020/6/20
     * @last modify by [LuoYong 13:52 2020/6/20 ]
     */
    public void list(int no) {
        if (null == head) {
            System.out.println("第" + (no + 1) + "链表为空");
            return;
        }
        System.out.println("第" + (no + 1) + "链表的信息为");
        //辅助指针 赋值遍历
        Emp tempEmp = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", tempEmp.getId(), tempEmp.getName());
            if (null == tempEmp.getNext()) {
                //说明tempEmp已经是最后的节点了
                break;
            }
            //后移
            tempEmp = tempEmp.getNext();
        }
        System.out.println();
    }

    /**
     * @param id 雇员id
     * @return
     * @Description: 通过雇员id查询雇员信息
     * @author luoyong
     * @create 14:00 2020/6/20
     * @last modify by [LuoYong 14:00 2020/6/20 ]
     */
    public Emp findById(int id) {
        //定义返回值
        Emp findEmp = null;
        if (null == head) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.getId() == id) {
                break;
            }
            if (null == curEmp.getNext()) {
                curEmp = null;
                break;
            }
            //后移
            curEmp = curEmp.getNext();
        }
        return curEmp;
    }
}
