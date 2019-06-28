package com.ly.collection;

import com.ly.collection.dto.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author luoyong
 * @Description: CollectionTest
 * @create 2019-06-23 11:06
 * @last modify by [dell 2019-06-23 11:06]
 **/
public class CollectionTest {
    /**
     * @param
     * @return void
     * @Description: 在List内去除重复数字值，要求尽量简单
     * @author luoyong
     * @create 11:07 2019/6/23
     * @last modify by [dell 11:07 2019/6/23 ]
     */
    @Test
    public void testTwo() {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }


    /**
     * @param
     * @return void
     * @Description: set一切运算跟hashcode有关（删除 新增 修改） 先比较hashcode 再比较equals
     * @author luoyong
     * @create 11:10 2019/6/23
     * @last modify by [dell 11:10 2019/6/23 ]
     */
    @Test
    public void test3() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.setName( "CC");
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001, "CC"));
        System.out.println(set);
        set.add(new Person(1001, "AA"));
        System.out.println(set);

    }

}
