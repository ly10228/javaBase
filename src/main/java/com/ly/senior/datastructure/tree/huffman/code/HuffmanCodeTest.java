package com.ly.senior.datastructure.tree.huffman.code;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.*;
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

        //4:通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
        System.out.println("压缩后的长度是=" + huffmanCodeBytes.length);
        System.out.println("huffmanCodeBytes=" + Arrays.toString(huffmanCodeBytes));
    }


    /**
     * @return void
     * @Description: 测试解码
     * @author luoyong
     * @create 11:44 上午 2020/6/27
     * @last modify by [LuoYong 11:44 上午 2020/6/27 ]
     */
    @Test
    public void testDecode() {
        String content = "i like like like java do you like a java";
        //原始byte数组
        byte[] contentBytes = content.getBytes();
        System.out.println("原始byte数组=" + Arrays.toString(contentBytes));

        //压缩后的byte数组
        byte[] huffmanCodes = huffmanZip(contentBytes);
        System.out.println("压缩后的byte数组=" + Arrays.toString(huffmanCodes));

        //进行压缩后的byte数组进行解码
        byte[] decodeHuffmanCodes = decode(huffmanCodes, huffmanByteCodeMap);
        // "i like like like java do you like a java"
        System.out.println("原来的字符串=" + new String(decodeHuffmanCodes));
    }


    /**
     * @return void
     * @Description: 测试使用赫夫曼编码对文件进行压缩和解压
     * @author luoyong
     * @create 5:07 下午 2020/6/27
     * @last modify by [LuoYong 5:07 下午 2020/6/27 ]
     */
    @Test
    public void testZip() {
        String srcFile = "/Users/luoyong/java/doc/hello.txt";
        String dstFile = "/Users/luoyong/java/doc/hello.zip";
        zipFile(srcFile, dstFile);
        System.out.println("压缩文件ok~~");
    }


    /**
     * @return void
     * @Description: 测试文件解压
     * @author luoyong
     * @create 5:13 下午 2020/6/27
     * @last modify by [LuoYong 5:13 下午 2020/6/27 ]
     */
    @Test
    public void testUnzip() {
        String zipFile = "/Users/luoyong/java/doc/hello.zip";
        String dstFile = "/Users/luoyong/java/doc/helloUnzip.txt";
        unzipFile(zipFile, dstFile);
        System.out.println("解压成功~~");
    }

    /**
     * @param zipFile 准备解压的文件
     * @param dstFile 将文件解压到那个路径
     * @return void
     * @Description: 完成对压缩文件的解压
     * @author luoyong
     * @create 4:56 下午 2020/6/27
     * @last modify by [LuoYong 4:56 下午 2020/6/27 ]
     */
    public static void unzipFile(String zipFile, String dstFile) {
        //定义文件输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义一个文件输出流
        OutputStream os = null;
        try {
            //1:读源文件当中的数据
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和is 关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼code对照表
            huffmanByteCodeMap = (Map<Byte, String>) ois.readObject();

            //2 进行解码
            byte[] decodeHuffmanBytes = decode(huffmanBytes, huffmanByteCodeMap);

            //3:写到目的文件当中
            os = new FileOutputStream(dstFile);
            os.write(decodeHuffmanBytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
                os.close();
                ois.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * @param srcFile 源文件
     * @param dstFile 压缩到指定文件
     * @return void
     * @Description: 压缩文件到执行的文件 无损
     * @author luoyong
     * @create 4:15 下午 2020/6/27
     * @last modify by [LuoYong 4:15 下午 2020/6/27 ]
     */
    public static void zipFile(String srcFile, String dstFile) {
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //创建文件的输入流
        FileInputStream is = null;
        try {
            //1：创建文件的输入流 读数据
            is = new FileInputStream(srcFile);
            //创建一个源文件一样大小的的字节数组
            byte[] b = new byte[is.available()];
            //把流中的数据读入到指定的字节数组当中
            is.read(b);


            //2: 直接对源文件进行压缩
            byte[] huffmanBytes = huffmanZip(b);

            //3:创建文件的输出流 存放压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //这里我们以对象流的方式写入赫夫曼编码 是为了以后我们恢复源文件时使用
            oos.writeObject(huffmanByteCodeMap);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * @param huffmanByteCodeMap key:字节 value：字节对应的赫夫曼编码
     * @param huffmanCodeBytes   赫夫曼编码压缩后的字节数组
     * @return byte[]
     * @Description: 解码
     * @author luoyong
     * @create 11:15 上午 2020/6/27
     * @last modify by [LuoYong 11:15 上午 2020/6/27 ]
     */
    private static byte[] decode(byte[] huffmanCodeBytes, Map<Byte, String> huffmanByteCodeMap) {
        //1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder builder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanCodeBytes.length; i++) {
            byte b = huffmanCodeBytes[i];
            //判断是否是最后一个字节
            boolean flag = (i == huffmanCodeBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }

        //2:把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        //key 赫夫曼编码 value：byte
        Map<String, Byte> map = Maps.newHashMap();
        for (Map.Entry<Byte, String> entry : huffmanByteCodeMap.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建要给集合，存放byte
        List<Byte> byteList = Lists.newArrayList();
        for (int i = 0; i < stringBuilder.length(); ) {
            //计数器
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                //i 不动，让count移动，指定匹配到一个字符
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (null == b) {
                    //没有匹配到
                    count++;
                } else {
                    //匹配到了
                    flag = false;
                }
            }
            byteList.add(b);
            //i直接移动到count
            i += count;
        }

        //当for循环结束后，我们list中就存放了所有的字符  "i like like like java do you like a java"
        //把list 中的数据放入到byte[] 并返回
        byte[] decodeBytes = new byte[byteList.size()];
        for (int i = 0; i < decodeBytes.length; i++) {
            decodeBytes[i] = byteList.get(i);
        }
        return decodeBytes;
    }

    /**
     * @param flag 标志是否需要补高位如果是true 表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @param b    字节
     * @return
     * @Description: 将一个byte转换成一个二进制的字符串 二进制的原码，反码，补码 直接返回的是补码
     * @author luoyong
     * @create 11:19 上午 2020/6/27
     * @last modify by [LuoYong 11:19 上午 2020/6/27 ]
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存 b
        //将 b 转成 int
        int temp = b;
        //如果是正数我们还存在补高位
        if (flag) {
            /**
             * 按位与   只要有一个为0，其值为0。  例子：10&9： 0000 1010 & 0000 1001 = 0000 1000 = 8
             * 按位或   只要有一个为1，其值为1。  例子：3|5　即 0000 0011 | 0000 0101 = 0000 0111 因此，3|5的值得7。
             * 按位异或 如果两个相应位为“异”（值不同），则该位结果为1，否则为0。 例子：10^9 即 0000 1010 ^ 0000 1001= 0000 0011 即10^9 = 3
             * 按位取反 对一个二进制数按位取反，即将0变1，1变0。 例子：就是0变为1 ，1变为0比如 二进制 1001 0011 按位取反后得：0110 1100
             */
            //按位或 256  1 0000 0000  | 0000 0001 => 1 0000 0001
            temp |= 256;
        }
        //返回的是temp对应的二进制的补码
        String str = Integer.toBinaryString(temp);

        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }


    /**
     * @param bytes 原始的字符串对应的字节数组
     * @return byte[]
     * @Description: 使用赫夫曼编码压缩后的字节数组
     * @author luoyong
     * @create 11:03 上午 2020/6/27
     * @last modify by [LuoYong 11:03 上午 2020/6/27 ]
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //1:将字节数组转换成Node
        List<Node> nodes = getNodes(bytes);

        //2:用Node创建赫夫曼树
        Node huffmanTree = createHuffmanTree(nodes);

        //前序遍历
        huffmanTree.preOrder();

        //3: 生成赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTree);

        //4:赫夫曼编码压缩后的字节数组
        return zip(bytes, huffmanCodes);
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
        //1:利用huffmanCodes 将  bytes 转成  赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanByteCodeMap.get(b));
        }
        //2:8个bit一组 确定长度
        //int len = (stringBuilder.length() + 7) / 8;
        int len = 0;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }

        //3:创建存储压缩后的byte数组
        byte[] huffmanByteCodes = new byte[len];
        //记录是第几个byte
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            //每8位对应一个byte 所以步长+8
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                //不够8位 一般到最后才会出现不够八位的情况
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //parseInt（String s, int radix） radix 进制类型
            huffmanByteCodes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanByteCodes;
    }


    /**
     * @param root
     * @return
     * @Description: 生成赫夫曼树对应的赫夫曼编码 key:叶子节点 value：赫夫曼编码
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
