package com.ly.base.jvm.monitor.commandline.jstat;

import java.util.ArrayList;

/**
 * @author luoyong
 *  * @create 2021-03-06 5:50 下午
 *  * @last modify by [luoyong 2021-03-06 5:50 下午]
 * @Description: GCTest  vm参数设置: -Xms60m -Xmx60m -XX:SurvivorRatio=8
 * 老年代新生代默比例是2:1 old-->40M  new-->20M SurvivorRatio=8 s0:s1:eden=1:1:8 s0=s1=2M eden=16M
 **/
public class GCTest {
    public static void main(String[] args) {

        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            //100KB
            byte[] arr = new byte[1024 * 100];
            list.add(arr);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
