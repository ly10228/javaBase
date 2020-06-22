package com.ly.senior.datastructure.tree.huffman.code;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author luoyong
 * @Description: HuffmanCodeTest
 * @create 2020-06-22 21:46
 * @last modify by [LuoYong 2020-06-22 21:46]
 **/
public class HuffmanCodeTest {

    @Test
    public void test() {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        //40
        System.out.println(contentBytes.length);
        System.out.println(Arrays.toString(contentBytes));
    }

    /**
     * @param bytes 字节数组
     * @return
     * @Description: 根据字节数组生成Node
     * @author luoyong
     * @create 21:49 2020/6/22
     * @last modify by [LuoYong 21:49 2020/6/22 ]
     */
    private static List<Node> getNodes(byte[] bytes) {
        //定义返回值
        List<Node> nodeList = Lists.newArrayList();

        //1:遍历bytes 统计每个byte出现的次数
        //key 字节 value：字节出现的次数
        Map<Byte, Integer> byteAppearCountMap = Maps.newHashMap();
        for (Byte b : bytes) {
            Integer byteCount = byteAppearCountMap.get(b);
            if (null == byteCount) {
                byteAppearCountMap.put(b, 1);
            } else {
                byteAppearCountMap.put(b, byteCount + 1);
            }
        }

        //2:遍历map 组装Node List
        if (byteAppearCountMap.isEmpty()) {
            return nodeList;
        }
        for (Map.Entry<Byte, Integer> entry : byteAppearCountMap.entrySet()) {
            Byte data = entry.getKey();
            Integer byteCount = entry.getValue();
            if (null == data || null == byteCount) {
                continue;
            }
            Node node = new Node(data, byteCount);
            nodeList.add(node);
        }
        return nodeList;
    }


    /**
     * @param nodeList 节点集合
     * @return
     * @Description: 创建赫夫曼树
     * @author luoyong
     * @create 21:59 2020/6/22
     * @last modify by [LuoYong 21:59 2020/6/22 ]
     */
    private static Node createHuffmanTree(List<Node> nodeList) {
        while (nodeList.size() > 1) {
            //最终只剩下一个节点

            //1:排序 从小到大
            Collections.sort(nodeList);

            //2:取出第一小和第二小节点
            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);

            //3:节点合并 创建一个新的二叉树 它的根节点 没有data 只有权值
            Node parentNode = new Node(null, leftNode.getWeight() + rightNode.getWeight());
            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);

            //4:删除之前的已经合并的最小节点
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);

            //将parentNode添加到集合当中
            nodeList.add(parentNode);
        }
        // 最后的节点只有一个 就是赫夫曼树的根节点
        return nodeList.get(0);
    }
}
