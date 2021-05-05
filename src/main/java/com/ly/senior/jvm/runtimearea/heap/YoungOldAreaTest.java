package com.ly.senior.jvm.runtimearea.heap;

/**
 * @author luoyong
 *  * @create 2021-05-05 11:24 下午
 *  * @last modify by [luoyong 2021-05-05 11:24 下午]
 * @Description: 测试：大对象直接进入老年代
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 **/
public class YoungOldAreaTest {
    public static void main(String[] args) {
        //20m
        byte[] buffer = new byte[1024 * 1024 * 20];
    }
}
