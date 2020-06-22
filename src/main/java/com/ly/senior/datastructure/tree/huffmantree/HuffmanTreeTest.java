package com.ly.senior.datastructure.tree.huffmantree;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2020-06-22 2:18 下午
 *  * @last modify by [luoyong 2020-06-22 2:18 下午]
 * @Description: HuffmanTreeTest
 **/
public class HuffmanTreeTest {

    /**
     * @return void
     * @Description: 赫夫曼树测试
     * @author luoyong
     * @create 2:19 下午 2020/6/22
     * @last modify by [LuoYong 2:19 下午 2020/6/22 ]
     */
    @Test
    public void testHuffmanTree() {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node node = HuffmanTree.createHuffmanTree(arr);
        HuffmanTree.preOrder(node);
    }
}
