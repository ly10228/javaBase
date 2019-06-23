package com.ly.collection;

import com.ly.collection.dto.UserDTO;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author luoyong
 * @Description: TreeSetTest
 * @create 2019-06-23 10:20
 * @last modify by [dell 2019-06-23 10:20]
 **/
public class TreeSetTest {
    /*
 1.向TreeSet中添加的数据，要求是相同类的对象。
 2.两种排序方式：自然排序（实现Comparable接口） 和 定制排序（Comparator）


 3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
 4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
  */

    /**
     * @param
     * @return void
     * @Description: 自然排序 实现Comparable接口
     * @author luoyong
     * @create 10:29 2019/6/23
     * @last modify by [dell 10:29 2019/6/23 ]
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

        //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
        set.add(new UserDTO("Tom",12));
        set.add(new UserDTO("Jerry",32));
        set.add(new UserDTO("Jim",2));
        set.add(new UserDTO("Mike",65));
        set.add(new UserDTO("Jack",33));
        set.add(new UserDTO("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    /**
     * @param
     * @return void
     * @Description: 定制排序 按照年龄从小到大排列 （Comparator）
     * @author luoyong
     * @create 10:27 2019/6/23
     * @last modify by [dell 10:27 2019/6/23 ]
     */
    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            public int compare(Object o1, Object o2) {
                if(o1 instanceof UserDTO && o2 instanceof UserDTO){
                    UserDTO u1 = (UserDTO)o1;
                    UserDTO u2 = (UserDTO)o2;
                    int compare = Integer.compare(u1.getAge(), u2.getAge());
                    return compare;
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new UserDTO("Tom",12));
        set.add(new UserDTO("Jerry",32));
        set.add(new UserDTO("Jim",2));
        set.add(new UserDTO("Mike",65));
        set.add(new UserDTO("Mary",33));
        set.add(new UserDTO("Jack",33));
        set.add(new UserDTO("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
