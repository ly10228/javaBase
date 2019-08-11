package com.ly.senior.datastructure.linkedlist;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luoyong
 * @Description: DoubleHeroNode
 * @create 2019-08-05 23:23
 * @last modify by [LuoYong 2019-08-05 23:23]
 **/
@Data
public class DoubleHeroNode implements Serializable {
    /**
     * 英雄编号
     */
    public int no;

    /**
     * 英雄名称
     */
    public String name;

    /**
     * 昵称
     */
    public String nickName;

    /**
     * 指向下一个节点
     */
    public DoubleHeroNode next;
    /**
     * 指向前一个节点
     */
    public DoubleHeroNode pre;

    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
