package com.ly.senior.datastructure.linkedlist;

import lombok.Data;

/**
 * @author luoyong
 * @Description: DoubleLinkedList
 * @create 2019-08-05 23:26
 * @last modify by [LuoYong 2019-08-05 23:26]
 **/
@Data
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
    public DoubleHeroNode getHead() {
        return head;
    }


    /**
     * @param
     * @return void
     * @Description: addDoubleHeroNode 双向列表新增节点
     * 先找到双向链表的最后节点
     * @author luoyong
     * @create 23:29 2019/8/5
     * @last modify by [LuoYong 23:29 2019/8/5 ]
     */
    public void add(DoubleHeroNode doubleHeroNode) {
        //1:获取头节点
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


    /**
     * @param doubleHeroNode
     * @return void
     * @Description: 修改双向链表值
     * 1：通过编号找到节点
     * 2：替换节点的值
     * @author luoyong
     * @create 17:33 2019/8/10
     * @last modify by [LuoYong 17:33 2019/8/10 ]
     */
    public void update(DoubleHeroNode doubleHeroNode) {
        if (null == head.next) {
            System.out.println("链表为空");
        }

        //要修改节点的编号
        int updateNo = doubleHeroNode.getNo();

        DoubleHeroNode curNode = head.next;

        //是否找到要修改的元素 默认没有被找到
        Boolean isFind = false;

        while (true) {
            if (null == curNode) {
                //到达链表底部
                break;
            }
            if (updateNo == curNode.getNo()) {
                isFind = true;
                break;
            }
            curNode = curNode.next;
        }
        if (isFind) {
            curNode.name = doubleHeroNode.name;
            curNode.nickName = doubleHeroNode.nickName;
        } else {
            // 没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", updateNo);
        }
    }

    /**
     * @param delNo 要刪除节点的编号
     * @return void
     * @Description: 通过编号删除某一个节点
     * @author luoyong
     * @create 10:52 2019/8/11
     * @last modify by [LuoYong 10:52 2019/8/11 ]
     */
    public void del(int delNo) {
        if (null == head.next) {
            System.out.printf("链表为空");
        }
        //1：头节点不可以被删除 需要一个辅助节点
        DoubleHeroNode curNode = head.next;

        //是否找到删除节点的标识
        Boolean ifFindDelNodeFlag = false;
        //遍历双向链表 找到要删除的节点
        while (true) {
            if (null == curNode) {
                //链表已经遍历完
                break;
            }
            if (delNo == curNode.no) {
                //找到该节点
                ifFindDelNodeFlag = true;
                break;
            }
            curNode = curNode.next;
        }
        if (ifFindDelNodeFlag) {
            //找到了该节点
            //当前节点的前一个节点的next域指向当前节点后一个节点
            curNode.pre.next = curNode.next;
            //当前节点的后一个节点的pre域指向当前节点的前一个节点
            //如果节点是最后一个节点 则会出现空指针异常的情况
            if (null != curNode.next) {
                curNode.next.pre = curNode.pre;
            }
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能删除\n", delNo);
        }
    }


    /**
     * @param
     * @return void
     * @Description: 遍历双向链表
     * @author luoyong
     * @create 11:03 2019/8/11
     * @last modify by [LuoYong 11:03 2019/8/11 ]
     */
    public void list() {
        if (null == head.next) {
            System.out.printf("链表为空");
        }
        DoubleHeroNode curNode = head.next;
        while (null != curNode) {
            System.out.println(curNode);
            curNode = curNode.next;
        }
    }
}
