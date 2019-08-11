package com.ly.senior.datastructure.linkedlist.josepfu;

/**
 * @author luoyong
 * @Description: CircleSingleLinkedList 环形单向链表
 * @create 2019-08-11 16:22
 * @last modify by [LuoYong 2019-08-11 16:22]
 **/
public class CircleSingleLinkedList {
    /**
     * 创建一个first节点,当前没有编号
     */
    private Boy first = null;

    /**
     * @param nums 数量
     * @return void
     * @Description: 创建相应数量的环形单向链表
     * @author luoyong
     * @create 16:24 2019/8/11
     * @last modify by [LuoYong 16:24 2019/8/11 ]
     */
    public void addBoy(int nums) {
        if (1 > nums) {
            System.out.println("nums的值不正确");
            return;
        }
        //辅助指针（链表元素移动） 帮助构建环形链表
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                //是第一个男孩 如果只有一个元素 自己指向自己
                first = boy;
                first.setNext(first);
                //指向第一个小孩
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }


    /**
     * @param
     * @return void
     * @Description: showBoy 显示循环单向链表
     * @author luoyong
     * @create 16:34 2019/8/11
     * @last modify by [LuoYong 16:34 2019/8/11 ]
     */
    public void showBoy() {
        //判断链表是否为空
        if (null == first) {
            System.out.println("链表为空");
            return;
        }
        //第一个元素不可以动
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                //最后一个元素
                break;
            }
            //后移
            curBoy = curBoy.getNext();
        }
    }

    /**
     * @param startNo  表示从第几个小孩开始数数(k)
     * @param countNum 表示数几下(m)
     * @param nums     表示小孩的数量(n)
     * @return void
     * @Description: 根据用户的输入 计算出小孩出圈的顺序
     * @author luoyong
     * @create 16:38 2019/8/11
     * @last modify by [LuoYong 16:38 2019/8/11 ]
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //校验
        if (null == first || 1 > startNo || 1 > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建辅助指针(指向环形链表的最后一个节点) 帮助小孩出圈
        Boy last = first;
        while (true) {
            if (last.getNext() == first) {
                //最后一个节点
                break;
            }
            last = last.getNext();
        }

        //从第k个小孩开始报数 将第一个报数的孩子设置成为头节点
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            last = last.getNext();
        }

        //进行报数操作
        while (true) {
            if (last == first) {
                //链表当中只有一个对象
                break;
            }
            //让头节点和未节点同时移动 countNum-1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                last = last.getNext();
            }
            //经过移动之后 first指向的节点就是要出圈小孩的节点
            System.out.printf("小孩%d出圈", first.getNo());
            System.out.println();
            //将该头节点移除
            first = first.getNext();
            last.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }

}
