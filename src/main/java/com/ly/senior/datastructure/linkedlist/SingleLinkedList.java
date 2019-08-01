package com.ly.senior.datastructure.linkedlist;

/**
 * @author luoyong
 * @Description: SingleLinkedList 管理hero
 * @create 2019-07-27 17:21
 * @last modify by [LuoYong 2019-07-27 17:21]
 **/
public class SingleLinkedList {
    /**
     * 初始化一个头结点
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * @param
     * @Description: 返回头节点
     * @author luoyong
     * @create 17:23 2019/7/27
     * @last modify by [LuoYong 17:23 2019/7/27 ]
     */
    public HeroNode getHead() {
        return head;
    }

    /**
     * @param heroNode
     * @return void
     * @Description: 单链表添加数据
     * 1：找到当前链表的最后节点
     * 2：将最后节点的next指向--新的节点
     * @author luoyong
     * @create 17:24 2019/7/27
     * @last modify by [LuoYong 17:24 2019/7/27 ]
     */
    public void add(HeroNode heroNode) {
        //1：找到当前链表的最后节点
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                //链表当中最后一个元素
                break;
            }
            //如果没有找到最后 将temp一直后移
            temp = temp.next;
        }
        //退出了while循环--temp就指向了链表的最后
        //将最后这个节点的next 指向新的节点
        temp.next = heroNode;
    }

    /**
     * @param heroNode 新节点
     * @return void
     * @Description: 添加英雄时，根据排名将英雄插入到指定位置
     * 只能位于添加位置的前一个节点 否则插入不了
     * @author luoyong
     * @create 17:31 2019/7/27
     * @last modify by [LuoYong 17:31 2019/7/27 ]
     */
    public void addByOrder(HeroNode heroNode) {
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        // flag标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //temp 已经是链表最后一个元素
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到 就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明希望添加的heroNode编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag 的值
        if (flag) {
            //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    /**
     * @param newHeroNode
     * @return void
     * @Description: 修改节点的信息
     * @author luoyong
     * @create 9:39 2019/7/28
     * @last modify by [LuoYong 9:39 2019/7/28 ]
     */
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (null == head.next) {
            System.out.println("链表为空");
            return;
        }
        //根据no找到需要修改的节点
        HeroNode temp = head.next;
        //标识是否找到该节点
        boolean flag = false;
        while (true) {
            if (null == temp) {
                //已经到链表的最后一个元素
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //找到对应的节点
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到 编号 %d 的节点,不能修改\n", newHeroNode.no);
        }
    }

    /**
     * @param no 英雄编号
     * @return void
     * @Description: 根据英雄编号删除英雄
     * head不能动
     * 因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * @author luoyong
     * @create 9:46 2019/7/28
     * @last modify by [LuoYong 9:46 2019/7/28 ]
     */
    public void del(int no) {
        //head不能动
        HeroNode temp = head;
        //是否找到要删除节点的标志
        boolean flag = false;
        while (true) {
            if (null == temp.next) {
                System.out.printf("已经到链表底部");
                break;
            }
            if (no == temp.next.no) {
                //找到删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //找到要删除的节点
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在", no);
        }
    }

    /**
     * @param
     * @return void
     * @Description: 遍历单链表
     * @author luoyong
     * @create 9:59 2019/7/28
     * @last modify by [LuoYong 9:59 2019/7/28 ]
     */
    public void list() {
        if (null == head.next) {
            System.out.printf("链表为空~");
            return;
        }
        //头节点不参与遍历
        HeroNode temp = head.next;
        while (true) {
            if (null == temp) {
                //已经到了链表的底部
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}
