package com.ly.collection;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author luoyong
 * @Description: 增强for循环的底层使用的还是迭代器
 * @create 2019-06-22 16:30
 * @last modify by [dell 2019-06-22 16:30]
 **/
public class ForTest {
    @Test
    public void testFor() {
        List<String> nameList = Lists.newArrayList();
        nameList.add("ly");
        nameList.add("com");
        //for(集合元素的类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器。
        for (String name : nameList) {
            System.out.println(name);
        }
    }
}
