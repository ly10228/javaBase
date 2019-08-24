package com.ly.java8.streamaapi;

import com.google.common.collect.Lists;
import com.ly.java8.streamaapi.dto.StreamEmployee;
import com.ly.java8.streamaapi.enm.StatusEnm;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author luoyong
 * @Description: StreamOperateApiTest
 * @create 2019-08-24 16:38
 * @last modify by [LuoYong 2019-08-24 16:38]
 **/
public class StreamOperateApiTest {
    List<StreamEmployee> employeeList = Arrays.asList(
            new StreamEmployee(102, "李四", 59, 6666.66, StatusEnm.BUSY),
            new StreamEmployee(101, "张三", 18, 9999.99, StatusEnm.FREE),
            new StreamEmployee(103, "王五", 28, 3333.33, StatusEnm.VOCATION),
            new StreamEmployee(104, "赵六", 8, 7777.77, StatusEnm.BUSY),
            new StreamEmployee(104, "赵六", 8, 7777.77, StatusEnm.FREE),
            new StreamEmployee(104, "赵六", 8, 7777.77, StatusEnm.FREE),
            new StreamEmployee(105, "田七", 38, 5555.55, StatusEnm.BUSY)
    );

    /**
     * @param
     * @return void
     * @Description: 筛选与切片
     * 1：filter--接受lambda，从流中排除某些元素
     * 2:limit--截断流，使其元素不超过给定的数量
     * 3：skip(n) --跳过元素，返回一个扔掉了前n个元素的流 若流中元素不足n个 则返回一个空流 与limit互补
     * 4：distinct--筛选，通过流所生产元素的hashCode()和equals()去除重复元素
     * @author luoyong
     * @create 16:47 2019/8/24
     * @last modify by [LuoYong 16:47 2019/8/24 ]
     */
    @Test
    public void testFilter() {
        //中间操作-->不会执行任何操作  内部迭代：跌倒操作由stream API 操作
        Stream<StreamEmployee> streamEmployeeStream = employeeList.stream().filter((e) -> {
            System.out.println("StreamApi的中间操作");
            return e.getAge() >= 35;
        });
        //终止操作-->只有当中止操作的时候 才会触发中间操作 一次性执行全部的内容 即：惰性求值
        streamEmployeeStream.forEach(System.out::println);
    }

    /**
     * @param
     * @return void
     * @Description: limit--截断流，使其元素不超过给定的数量
     * @author luoyong
     * @create 17:13 2019/8/24
     * @last modify by [LuoYong 17:13 2019/8/24 ]
     */
    @Test
    public void testLimit() {
        employeeList.stream().filter((e) -> e.getSalary() > 5000).limit(2).forEach(System.out::println);
    }

    /**
     * @param
     * @return void
     * @Description: testSkip--skip(n) --跳过元素，返回一个扔掉了前n个元素的流 若流中元素不足n个 则返回一个空流 与limit互补
     * @author luoyong
     * @create 17:13 2019/8/24
     * @last modify by [LuoYong 17:13 2019/8/24 ]
     */
    @Test
    public void testSkip() {
        employeeList.stream().filter((e) -> e.getSalary() > 5000).skip(2).forEach(System.out::println);
    }

    /**
     * @param
     * @return void
     * @Description: distinct--筛选，通过流所生产元素的hashCode()和equals()去除重复元素
     * @author luoyong
     * @create 17:22 2019/8/24
     * @last modify by [LuoYong 17:22 2019/8/24 ]
     */
    @Test
    public void testDistinct() {
        employeeList.stream().filter((e) -> e.getSalary() > 5000).skip(2).distinct().forEach(System.out::println);
    }

    /**************************************************************************************************************/
    /**
     * 映射
     * map--接收lambda，将元素转换成其他形式或提取信息。接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * flatMap 接收一个函数作为参数，将流当中的每个值转换成另一个流，然后把所有的流连接成一个流
     */

    /**
     * @param
     * @return void
     * @Description: testMap
     * 函数作用到集合中每一个元素上面
     * @author luoyong
     * @create 18:26 2019/8/24
     * @last modify by [LuoYong 18:26 2019/8/24 ]
     */
    @Test
    public void testMap() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //1:提取员工的名称
        employeeList.stream().map(StreamEmployee::getName).forEach(System.out::println);

        Stream<Stream<Character>> stream = list.stream().map(StreamOperateApiTest::filterCharacter);
        stream.forEach((sm -> sm.forEach(System.out::println)));

        list.stream().flatMap(StreamOperateApiTest::filterCharacter).forEach(System.out::println);

    }


    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = Lists.newArrayList();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /**
     * @param
     * @return void
     * @Description: testListAddAndAddAll
     * @author luoyong
     * @create 18:51 2019/8/24
     * @last modify by [LuoYong 18:51 2019/8/24 ]
     */
    @Test
    public void testListAddAndAddAll() {
        List<String> listOne = Arrays.asList("aa", "bb", "cc");
        List listTwo = Lists.newArrayList();
        listTwo.add("dd");
        listTwo.add(listOne);
        System.out.println(listTwo);

        List listTree = Lists.newArrayList();
        listTree.add("dd");
        listTree.addAll(listOne);
        System.out.println(listTree);
    }


    /**
     * ====================================================================================
     * 排序
     * sorted() Comparable--自然排序
     * sorted(Comparator com)--定制排序
     * ====================================================================================
     */

    /**
     * @param
     * @return void
     * @Description: testSorted 测试自然排序
     * @author luoyong
     * @create 18:58 2019/8/24
     * @last modify by [LuoYong 18:58 2019/8/24 ]
     */
    @Test
    public void testSorted() {
        List<String> stringList = Arrays.asList("bb", "cc", "aa");
        stringList.stream().sorted().forEach(System.out::println);

        employeeList.stream().sorted((eOne, eTwo) -> {
            if (eOne.getAge() == eTwo.getAge()) {
                return eOne.getName().compareTo(eTwo.getName());
            } else {
                return -Integer.compare(eOne.getAge(), eTwo.getAge());
            }
        }).forEach(System.out::println);
    }

}
