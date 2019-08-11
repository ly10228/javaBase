package com.ly.senior.datastructure.linkedlist;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: DoubleLinkedListTest
 * @create 2019-08-11 11:07
 * @last modify by [LuoYong 2019-08-11 11:07]
 **/
public class DoubleLinkedListTest {

    private DoubleLinkedList init() {
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        return doubleLinkedList;
    }

    /**
     * @param
     * @return void
     * @Description: 列表打印测试
     * @author luoyong
     * @create 11:26 2019/8/11
     * @last modify by [LuoYong 11:26 2019/8/11 ]
     */
    @Test
    public void listTest() {
        DoubleLinkedList doubleLinkedList = init();
        doubleLinkedList.list();
    }

    /**
     * @param
     * @return void
     * @Description: 测试双链表的更新
     * @author luoyong
     * @create 15:22 2019/8/11
     * @last modify by [LuoYong 15:22 2019/8/11 ]
     */
    @Test
    public void updateTest() {
        DoubleLinkedList doubleLinkedList = init();
        System.out.println("修改之前的链表");
        doubleLinkedList.list();
        DoubleHeroNode heroOne = new DoubleHeroNode(1, "宋江20190811", "利奇马");
        System.out.println("修改之后的链表");
        doubleLinkedList.update(heroOne);
        doubleLinkedList.list();
    }

    /**
     * @param
     * @return void
     * @Description: 双链表删除测试
     * @author luoyong
     * @create 16:05 2019/8/11
     * @last modify by [LuoYong 16:05 2019/8/11 ]
     */
    @Test
    public void delTest() {
        DoubleLinkedList doubleLinkedList = init();
        System.out.println("删除之前的链表");
        doubleLinkedList.list();
        System.out.println("删除之后的链表");
        doubleLinkedList.del(1);
        doubleLinkedList.list();
    }

}
