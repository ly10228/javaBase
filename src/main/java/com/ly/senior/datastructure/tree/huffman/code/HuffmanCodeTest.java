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

    /**
     * key：Byte value：赫夫曼树编码
     * 生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
     */
    private static Map<Byte, String> huffmanByteCodeMap = Maps.newHashMap();

    //2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
    private static StringBuilder stringBuilder = new StringBuilder();

    @Test
    public void test() {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        //40
        System.out.println(contentBytes.length);
        System.out.println(Arrays.toString(contentBytes));

        //1:将字节数组转换成Node
        List<Node> nodes = getNodes(contentBytes);
        //2:用Node创建赫夫曼树
        Node huffmanTree = createHuffmanTree(nodes);
        //前序遍历
        huffmanTree.preOrder();
        //3: 生成赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTree);
        //打印结果
        //~生成的赫夫曼编码表= {32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
        System.out.println("~生成的赫夫曼编码表= " + huffmanCodes);

    }


    /**
     * @param bytes
     * @param huffmanByteCodeMap
     * @return byte[]
     * @Description: 编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
     * @author luoyong
     * @create 3:55 下午 2020/6/23
     * @last modify by [LuoYong 3:55 下午 2020/6/23 ]
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanByteCodeMap) {
        return null;
    }


    /**
     * @param root
     * @return
     * @Description: 生成赫夫曼树对应的赫夫曼编码
     * @author luoyong
     * @create 3:52 下午 2020/6/23
     * @last modify by [LuoYong 3:52 下午 2020/6/23 ]
     */
    public static Map<Byte, String> getCodes(Node root) {
        if (null == root) {
            return Maps.newHashMap();
        }

        //处理root的左子树
        getCodes(root.getLeft(), "0", stringBuilder);
        //处理root的右子树
        getCodes(root.getRight(), "1", stringBuilder);

        return huffmanByteCodeMap;
    }


    /**
     * @param node          节点
     * @param code          路径：左子节点是 0 右子节点是 1
     * @param stringBuilder 用于路径拼接
     * @return void
     * @Description: 将传入Node节点所有叶子节点的赫夫曼编码得到 并放入到Map当中
     * @author luoyong
     * @create 3:32 下午 2020/6/23
     * @last modify by [LuoYong 3:32 下午 2020/6/23 ]
     */
    public static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        //将code加入stringBuilder1
        stringBuilder1.append(code);
        if (node != null) {
            //判断当前node 是叶子节点还是非叶子节点
            if (null == node.getData()) {
                //非叶子节点
                //递归处理
                //向左递归
                getCodes(node.getLeft(), "0", stringBuilder1);
                //向右递归
                getCodes(node.getRight(), "1", stringBuilder1);
            } else {
                //是叶子节点
                huffmanByteCodeMap.put(node.getData(), stringBuilder1.toString());
            }
        }

    }


    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
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
