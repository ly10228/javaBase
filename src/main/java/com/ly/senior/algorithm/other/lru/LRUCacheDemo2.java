package com.ly.senior.algorithm.other.lru;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luoyong
 *  * @create 2021-03-30 9:21 下午
 *  * @last modify by [luoyong 2021-03-30 9:21 下午]
 * @Description: 不依赖jdk实现LRU算法
 * map负责查找 构建一个虚拟的双向链表 它里面包装的就是一个个Node节点 作为数据的载体
 **/
public class LRUCacheDemo2<K, V> {
    /**
     * 1：构造一个load节点 作为数据的载体
     *
     * @param <K>
     * @param <V>
     */
    @Data
    class Node<K, V> {
        K key;
        V value;
        Node pre;
        Node<K, V> next;

        public Node() {
            this.pre = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.pre = this.next = null;
        }
    }

    /**
     * 2.构造一个虚拟的双向链表
     *
     * @param <K>
     * @param <V>
     */
    @Data
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.pre = head;
        }

        /**
         * @param newNode
         * @return void
         * @Description: 添加到头
         * @author luoyong
         * @create 9:57 下午 2021/3/30
         * @last modify by [LuoYong 9:57 下午 2021/3/30 ]
         */
        public void addHead(Node newNode) {
            //设置新节点的next和 pre
            newNode.next = head.next;
            newNode.pre = head;
            //设置新增之前 head next节点的pre
            newNode.next.pre = newNode;
            //设置头节点的下一个节点
            head.next = newNode;
        }

        /**
         * @param delNode
         * @return void
         * @Description: 删除某一个节点
         * @author luoyong
         * @create 10:14 下午 2021/3/30
         * @last modify by [LuoYong 10:14 下午 2021/3/30 ]
         */
        public void delNode(Node delNode) {
            delNode.next.pre = delNode.pre;
            delNode.pre.next = delNode.next;
            delNode.next = null;
            delNode.pre = null;
        }

        /**
         * @return
         * @Description: 获取最后一个节点
         * @author luoyong
         * @create 10:21 下午 2021/3/30
         * @last modify by [LuoYong 10:21 下午 2021/3/30 ]
         */
        public Node getLastNode() {
            return tail.pre;
        }
    }


    private int cacheSize;

    /**
     * key：int类型的值 value：node
     */
    Map<Integer, Node<Integer, Integer>> map;

    /**
     * 双向链表
     */
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCacheDemo2(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            //key 不存在
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        //先删除
        doubleLinkedList.delNode(node);
        //再添加到双线链表的头部
        doubleLinkedList.addHead(node);

        return node.value;
    }


    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //值已经存在了
            //更新值
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            //先删除
            doubleLinkedList.delNode(node);
            //再添加到双线链表的头部
            doubleLinkedList.addHead(node);
            return;
        }
        if (map.size() == cacheSize) {
            //坑位已慢 需要清除最后一个数据
            Node<Integer, Integer> lastNode = doubleLinkedList.getLastNode();
            map.remove(lastNode.key);
            doubleLinkedList.delNode(lastNode);
        }
        //构造节点数据
        Node newNode = new Node(key, value);
        //放入map当中
        map.put(key, newNode);
        //添加到双线链表的头部
        doubleLinkedList.addHead(newNode);
    }

    /**
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
        LRUCacheDemo2 lruCacheDemo2 = new LRUCacheDemo2(3);

        lruCacheDemo2.put(1, 1);
        lruCacheDemo2.put(2, 2);
        lruCacheDemo2.put(3, 3);

        //打印所有的key [1, 2, 3]
        System.out.println(lruCacheDemo2.map.keySet());

        lruCacheDemo2.put(4, 4);
        //[2, 3, 4]
        System.out.println(lruCacheDemo2.map.keySet());


        //测试访问顺序 3经过下述操作(最近最近常使用)
        lruCacheDemo2.put(3, 3);
        //[2, 4, 3]
        System.out.println(lruCacheDemo2.map.keySet());

        lruCacheDemo2.put(3, 3);
        //[2, 4, 3]
        System.out.println(lruCacheDemo2.map.keySet());

        lruCacheDemo2.put(3, 3);
        //[2, 4, 3]
        System.out.println(lruCacheDemo2.map.keySet());

        lruCacheDemo2.put(5, 5);
        //[4, 3, 5]
        System.out.println(lruCacheDemo2.map.keySet());

    }
}
