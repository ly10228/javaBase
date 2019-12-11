package com.ly.base.collection;

import com.ly.base.collection.dto.Person;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author luoyong
 *  * @create 2019-12-11 20:28
 *  * @last modify by [luoyong 2019-12-11 20:28]
 * @Description: ListTest
 **/
public class ListTest {
    @Test
    public void testCreate() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);
        System.out.println(list);
    }
}
