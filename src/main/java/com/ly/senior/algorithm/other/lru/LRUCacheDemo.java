package com.ly.senior.algorithm.other.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author luoyong
 *  * @create 2021-03-30 9:21 下午
 *  * @last modify by [luoyong 2021-03-30 9:21 下午]
 * @Description: 继承LinkedHashMap实现LRU算法
 **/
public class LRUCacheDemo<K, V> extends LinkedHashMap {
    private int capacity;

    public LRUCacheDemo(int capacity) {
        //<tt>true</tt> for access-order, <tt>false</tt> for insertion-order
        super(capacity, 0.75f, false);
        this.capacity = capacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > capacity;
    }


    /**
     * accessOrder 为true的访问顺序 access-order
     * [1, 2, 3]
     * [2, 3, 4]
     * [2, 4, 3]
     * [2, 4, 3]
     * [2, 4, 3]
     * [4, 3, 5]
     * <p>
     * accessOrder 为false的访问顺序 insertion-order
     * [1, 2, 3]
     * [2, 3, 4]
     * [2, 3, 4]
     * [2, 3, 4]
     * [2, 3, 4]
     * [3, 4, 5]
     *
     * @param args
     */
    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);

        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");

        //打印所有的key [1, 2, 3]
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(4, "d");
        //[2, 3, 4]
        System.out.println(lruCacheDemo.keySet());


        //测试访问顺序 3经过下述操作(最近最近常使用)
        lruCacheDemo.put(3, "c");
        //[2, 4, 3]
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3, "c");
        //[2, 4, 3]
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3, "c");
        //[2, 4, 3]
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(5, "x");
        //[4, 3, 5]
        System.out.println(lruCacheDemo.keySet());

    }
}
