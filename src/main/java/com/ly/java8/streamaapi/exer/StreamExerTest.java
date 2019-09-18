package com.ly.java8.streamaapi.exer;

import com.google.common.collect.Lists;
import com.ly.java8.streamaapi.dto.StreamEmployee;
import com.ly.java8.streamaapi.enm.StatusEnm;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author luoyong
 * @Description: StreamExerTest
 * @create 2019-08-25 11:04
 * @last modify by [LuoYong 2019-08-25 11:04]
 **/
public class StreamExerTest {

    /**
     * @param
     * @return void
     * @Description: 1.    给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     * 给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
     * @author luoyong
     * @create 11:05 2019/8/25
     * @last modify by [LuoYong 11:05 2019/8/25 ]
     */
    @Test
    public void testSquare() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream().map(x -> x * x).forEach(System.out::println);
    }

    /**
     * @param
     * @return void
     * @Description: testCalEmCountByMapAndReduce
     * 怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？
     * @author luoyong
     * @create 11:09 2019/8/25
     * @last modify by [LuoYong 11:09 2019/8/25 ]
     */
    @Test
    public void testCalEmCountByMapAndReduce() {
        Optional<Integer> optionalInteger = employeeList.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println(optionalInteger.get());
    }

    List<StreamEmployee> employeeList = Arrays.asList(
            new StreamEmployee(102, "李四", 59, 6666.66, StatusEnm.BUSY),
            new StreamEmployee(101, "张三", 18, 9999.99, StatusEnm.FREE),
            new StreamEmployee(103, "王五", 28, 3333.33, StatusEnm.VOCATION),
            new StreamEmployee(104, "赵六", 7, 7777.77, StatusEnm.BUSY),
            new StreamEmployee(104, "赵六", 8, 7777.77, StatusEnm.FREE),
            new StreamEmployee(104, "赵六", 9, 7777.77, StatusEnm.FREE),
            new StreamEmployee(105, "田七", 38, 5555.55, StatusEnm.BUSY)
    );


    /**
     * @return void
     * @Description: 集合转换成map key重复 value合并
     * @author luoyong
     * @create 21:13 2019-09-18
     * @last modify by [luoyong 21:13 2019-09-18 ]
     */
    @Test
    public void testMapKeyepeatValueMerge() {
        Map<Integer, List<Integer>> map =
                employeeList.stream().collect(Collectors.toMap(key -> key.getId(),
                        value -> Lists.newArrayList(value.getAge()), (List<Integer> newValueList,
                                                                      List<Integer> oldValueList) -> {
                            oldValueList.addAll(newValueList);
                            return oldValueList;

                        }));

        System.out.println(map);
    }

}
