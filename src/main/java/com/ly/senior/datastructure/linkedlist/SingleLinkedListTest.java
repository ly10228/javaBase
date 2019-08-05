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
     * @Description: 根据编号修改单链表
     * @author luoyong
     * @create 9:53 2019/8/3
     * @last modify by [LuoYong 9:53 2019/8/3 ]
     */
    @Test
    public void updateSingleLinkedList() {
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        System.out.println("修改之前的单链表");
        singleLinkedList.list();
        HeroNode heroTwo = new HeroNode(2, "卢俊义~~", "玉麒麟~~");
        singleLinkedList.update(heroTwo);
        System.out.println("修改之后的单链表");
        singleLinkedList.list();
    }

    /**
     * @param
     * @return void
     * @Description: 删除单链表节点
     * @author luoyong
     * @create 17:22 2019/8/3
     * @last modify by [LuoYong 17:22 2019/8/3 ]
     */
    @Test
    public void delSingleLinkedList() {
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        System.out.println("删除之前的单链表");
        singleLinkedList.list();
        singleLinkedList.del(2);
        System.out.println("删除之后的单链表");
        singleLinkedList.list();
    }

    /**
     * @param
     * @return void
     * @Description: 测试获取单链表有有效节点个数
     * @author luoyong
     * @create 17:43 2019/8/3
     * @last modify by [LuoYong 17:43 2019/8/3 ]
     */
    @Test
    public void getSingleLinkedSize() {
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        int size = getLength(singleLinkedList.getHead());
        System.out.println("单链表有效节点的个数=" + size);
    }

    /**
     * @param
     * @return void
     * @Description: 获取倒数第k个节点
     * @author luoyong
     * @create 22:49 2019/8/5
     * @last modify by [LuoYong 22:49 2019/8/5 ]
     */
    @Test
    public void getHeroNodeByIndexTest() {
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        HeroNode heroNode = getHeroNodeByIndex(singleLinkedList.getHead(), 2);
        System.out.println(heroNode);
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
            //reverseHead.next赋值给curNode.next
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


    /**
     * @param head 链表的头节点
     * @return int
     * @Description: 获取单链表头节点的数量
     * @author luoyong
     * @create 17:40 2019/8/3
     * @last modify by [LuoYong 17:40 2019/8/3 ]
     */
    private int getLength(HeroNode head) {
        //定义变量
        int length = 0;
        HeroNode temp = head.next;
        while (null != temp) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * @param head 头节点
     * @param k
     * @return
     * @Description: 查找链表当中倒数第k个节点
     * @author luoyong
     * @create 17:51 2019/8/3
     * @last modify by [LuoYong 17:51 2019/8/3 ]
     */
    private HeroNode getHeroNodeByIndex(HeroNode head, int k) {
        if (null == head.next) {
            //当前链表为空
            return null;
        }
        //1:获取链表的长度
        int size = getLength(head);
        if (k < 1 || k > size) {
            return null;
        }
        //当前节点
        HeroNode currentNode = head.next;
        for (int i = 0; i < size - k; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

}
