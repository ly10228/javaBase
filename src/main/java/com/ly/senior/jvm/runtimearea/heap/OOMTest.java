package com.ly.senior.jvm.runtimearea.heap;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author luoyong
 *  * @create 2021-05-05 10:50 下午
 *  * @last modify by [luoyong 2021-05-05 10:50 下午]
 * @Description: 测试OOM--可以通过visualVM进行观察（Visual GC工具）
 * 设置堆大小： -Xms600m -Xmx600m
 **/
public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<>();
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024 * 1024)));
        }
    }
}


class Picture {
    private byte[] pixels;

    public Picture(int length) {
        this.pixels = new byte[length];
    }
}
