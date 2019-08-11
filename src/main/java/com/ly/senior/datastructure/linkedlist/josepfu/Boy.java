package com.ly.senior.datastructure.linkedlist.josepfu;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Boy
 * @create 2019-08-11 16:21
 * @last modify by [LuoYong 2019-08-11 16:21]
 **/
@Data
public class Boy {
    /**
     * 编号
     */
    private int no;
    /**
     * 下一个节点
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
