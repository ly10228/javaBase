package com.ly.base.generic.wildcard;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @author luoyong
 * @Description: WildCardTest 通配符的使用
 * 配符：?
 * 类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
 * @create 2019-12-23 16:55
 * @last modify by [LuoYong 2019-12-23 16:55]
 **/
public class WildCardTest {

    @Test
    public void testWriteAndRead() {
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;
        list = list1;
        list = list2;
        print(list1);
        print(list2);

        List<String> list3 = Lists.newArrayList();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //1:添加：对于List<?>就不能向其内部添加数据
        //除了null之外
        //报错
//        list.add("DD");
        list.add(null);

        //2: 获取数据：允许读取数据，读取的数据类型为Object

        Object o = list.get(0);
        System.out.println(o);
    }


    /**
     * @param list
     * @return void
     * @Description: 打印泛型集合
     * @author luoyong
     * @create 17:01 2019/12/23
     * @last modify by [LuoYong 17:01 2019/12/23 ]
     */
    public void print(List<?> list) {
        if (null == list) {
            System.out.println("集合为空");
            return;
        }
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }


    /**
     * @param
     * @return void
     * @Description: 有限制条件的通配符的使用。
     * ? extends A:
     * G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类
     * ? super A:
     * G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类
     * @author luoyong
     * @create 17:15 2019/12/23
     * @last modify by [LuoYong 17:15 2019/12/23 ]
     */
    @Test
    public void test2() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;
        List<Student> list3 = Lists.newArrayList();
        List<Person> list4 = Lists.newArrayList();
        List<Object> list5 = Lists.newArrayList();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
        //Student s = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);
        ////编译不通过
//        Person obj = list2.get(0);

        //写入数据：
        //编译不通过
//        list1.add(new Student());

        //编译通过
        list2.add(new Person());
        list2.add(new Student());

    }

}
