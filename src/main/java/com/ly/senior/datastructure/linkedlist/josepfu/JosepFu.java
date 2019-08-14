package com.ly.senior.datastructure.linkedlist.josepfu;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: JosepFu
 * @create 2019-08-11 17:01
 * @last modify by [LuoYong 2019-08-11 17:01]
 **/
public class JosepFu {
    @Test
    public void josepFuTest(){
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        //测试小孩的出圈顺序
        circleSingleLinkedList.countBoy(1,2,5);
    }

}
