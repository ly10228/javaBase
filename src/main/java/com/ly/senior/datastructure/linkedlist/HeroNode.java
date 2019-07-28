package com.ly.senior.datastructure.linkedlist;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luoyong
 * @Description: HeroNode
 * @create 2019-07-27 17:11
 * @last modify by [LuoYong 2019-07-27 17:11]
 **/
@Data
public class HeroNode implements Serializable {

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
    public HeroNode next;

    /**
     * @param no
     * @param name
     * @param nickName
     * @return
     * @Description: 构造函数初始化类
     * @author luoyong
     * @create 17:15 2019/7/27
     * @last modify by [LuoYong 17:15 2019/7/27 ]
     */
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

}
