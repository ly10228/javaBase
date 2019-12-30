package com.ly.base.collection.list;

import com.ly.base.collection.list.dto.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author luoyong
 * @Description: IteratorTest
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext() 和  next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 * 默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 * @create 2019-12-10 22:53
 * @last modify by [LuoYong 2019-12-10 22:53]
 **/
public class IteratorTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
//        System.out.println(iterator.next());

        //方式二：不推荐
//        for(int i = 0;i < coll.size();i++){
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        ////hasNext():判断是否还有下一个元素
        while (iterator.hasNext()) {
            //next():①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2() {

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //错误方式一：
//        Iterator iterator = coll.iterator();
//        while((iterator.next()) != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next());
        }
    }


    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中"Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
//            iterator.remove();
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
//                iterator.remove();
            }

        }
        //遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testArrayCopy() {
        Object[] src = {123, 456, "Jerry", "Tom", false};
        System.arraycopy(src, 4, src, 3,
                1);
        Arrays.stream(src).forEach(System.out::println);
    }


}
