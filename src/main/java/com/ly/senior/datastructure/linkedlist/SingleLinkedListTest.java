package com.ly.senior.datastructure.linkedlist;

import org.junit.Test;

import java.util.Stack;

/**
 * @author luoyong
 * @Description: SingleLinkedListTest
 * @create 2019-07-27 17:16
 * @last modify by [LuoYong 2019-07-27 17:16]
 **/
public class SingleLinkedListTest {

    /**
     * @param
     * @return void
     * @Description: 遍历单链表数据
     * @author luoyong
     * @create 10:08 2019/7/28
     * @last modify by [LuoYong 10:08 2019/7/28 ]
     */
    @Test
    public void listSingleLinkedList() {
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        //遍历链表
        singleLinkedList.list();
    }

    /**
     * @param
     * @return void
     * @Description: 单链表反转功能 该变其结构
     * @author luoyong
     * @create 10:11 2019/7/28
     * @last modify by [LuoYong 10:11 2019/7/28 ]
     */
    @Test
    public void reverseSingleLinkedList() {
        //初始化单链表
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        //单链表反转
        reversetList(singleLinkedList.getHead());
        //打印
        singleLinkedList.list();
    }

    /**
     * @param
     * @return void
     * @Description: 逆序打印单链表 不改变其结构
     * @author luoyong
     * @create 10:42 2019/7/28
     * @last modify by [LuoYong 10:42 2019/7/28 ]
     */
    @Test
    public void reversePrintSingleLinkedList() {
        //初始化单链表
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        reversePrint(singleLinkedList.getHead());
    }


    /**
     * @param
     * @return void
     * @Description: 加入按照编号的顺序
     * @author luoyong
     * @create 22:52 2019/7/28
     * @last modify by [LuoYong 22:52 2019/7/28 ]
     */
    @Test
    public void addByOrder() {
        HeroNode heroNodeOne = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroTwo = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroThree = new HeroNode(3, "吴用", "智多星");
        HeroNode heroFour = new HeroNode(4, "林冲", "豹子头");

        //创建单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.addByOrder(heroNodeOne);
        singleLinkedList.addByOrder(heroFour);
        singleLinkedList.addByOrder(heroTwo);
        singleLinkedList.addByOrder(heroThree);
        singleLinkedList.list();
    }

    /**
     * @param
     * @return void
     * @Description: 逆序打印单链表 不修改单链表的结构
     * 可以利用栈的特性 先进后出 实现了逆序打印的效果
     * @author luoyong
     * @create 10:36 2019/7/28
     * @last modify by [LuoYong 10:36 2019/7/28 ]
     */
    private void reversePrint(HeroNode head) {
        if (null == head.next) {
            System.out.printf("链表数据为空");
            return;
        }
        //创建一个栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode currentNode = head.next;
        while (null != currentNode) {
            stack.push(currentNode);
            //后移
            currentNode = currentNode.next;
        }
        //将栈中的节点打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * @param head 头节点
     * @return void
     * @Description: 将单链表反转
     * @author luoyong
     * @create 10:14 2019/7/28
     * @last modify by [LuoYong 10:14 2019/7/28 ]
     */
    public void reversetList(HeroNode head) {
        //当前链表为空或者只有一个节点 直接返回
        if (null == head.next || null == head.next.next) {
            return;
        }
        //定义一个辅助的变量遍历原来的链表
        HeroNode curNode = head.next;
        //指向当前节点curNode的下一个节点
        HeroNode next = null;
        //定义反转之后的头节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (null != curNode) {
            //当前节点不为空
            //先暂时保存当前节点的下一个节点
            next = curNode.next;
            //将curNode的下一个节点指向新链表的最前端
            curNode.next = reverseHead.next;
            //将curNod连接到新的链表上
            reverseHead.next = curNode;
            //让curNode后移
            curNode = next;
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    /**
     * @param
     * @return
     * @Description: 初始化单链表
     * @author luoyong
     * @create 10:09 2019/7/28
     * @last modify by [LuoYong 10:09 2019/7/28 ]
     */
    private SingleLinkedList initSingleLinkedList() {
        HeroNode heroNodeOne = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroTwo = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroThree = new HeroNode(3, "吴用", "智多星");
        HeroNode heroFour = new HeroNode(4, "林冲", "豹子头");

        //创建单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.add(heroNodeOne);
        singleLinkedList.add(heroTwo);
        singleLinkedList.add(heroThree);
        singleLinkedList.add(heroFour);
        return singleLinkedList;
    }

}
