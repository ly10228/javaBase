package com.ly.senior.datastructure.linkedlist;

/**
 * @author luoyong
 * @Description: DoubleLinkedList
 * @create 2019-08-05 23:26
 * @last modify by [LuoYong 2019-08-05 23:26]
 **/
public class DoubleLinkedList {
    /**
     * 初始化头节点
     */
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    /**
     * @param
     * @return
     * @Description: 获取头节点
     * @author luoyong
     * @create 23:28 2019/8/5
     * @last modify by [LuoYong 23:28 2019/8/5 ]
     */
    private DoubleHeroNode getHead() {
        return this.head;
    }


    /**
     * @param
     * @return void
     * @Description: addDoubleHeroNode 双向列表新增节点
     * @author luoyong
     * @create 23:29 2019/8/5
     * @last modify by [LuoYong 23:29 2019/8/5 ]
     */
    private void addDoubleHeroNode(DoubleHeroNode doubleHeroNode) {
        //1:获取头节点
        DoubleHeroNode doubleHeroNodeHead = getHead();
        DoubleHeroNode curDoubleHead = head;
        while (true) {
            if (null == curDoubleHead.next) {
                break;
            }
            curDoubleHead = curDoubleHead.next;
        }
        curDoubleHead.next = doubleHeroNode;
        doubleHeroNode.pre = curDoubleHead;

    }


}
