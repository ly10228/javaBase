package com.ly.java8.streamaapi;

import com.ly.java8.streamaapi.dto.StreamEmployee;
import com.ly.java8.streamaapi.enm.StatusEnm;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author luoyong
 * @Description: StreamTerminationApiTest 终止操作api
 * @create 2019-08-24 20:59
 * @last modify by [LuoYong 2019-08-24 20:59]
 **/
public class StreamTerminationApiTest {
    /**
     * ======================================================================
     * 终止操作
     * allMatch——检查是否匹配所有元素
     * anyMatch——检查是否至少匹配一个元素
     * noneMatch——检查是否没有匹配的元素
     * findFirst——返回第一个元素
     * findAny——返回当前流中的任意元素
     * count——返回流中元素的总个数
     * max——返回流中最大值
     * min——返回流中最小值
     * <p>
     * ======================================================================
     */

    List<StreamEmployee> employeeList = Arrays.asList(
            new StreamEmployee(102, "李四", 59, 6666.66, StatusEnm.BUSY),
            new StreamEmployee(101, "张三", 18, 9999.99, StatusEnm.FREE),
            new StreamEmployee(103, "王五", 28, 3333.33, StatusEnm.VOCATION),
            new StreamEmployee(104, "赵六", 8, 7777.77, StatusEnm.BUSY),
            new StreamEmployee(105, "田七", 38, 5555.55, StatusEnm.BUSY),
            new StreamEmployee(106, "张三", 18, 9999.99, StatusEnm.FREE),
            new StreamEmployee(107, "张三", 18, 9999.99, StatusEnm.FREE)
    );

    /**
     * @param
     * @return void
     * @Description: testMatch 测试匹配
     * @author luoyong
     * @create 21:03 2019/8/24
     * @last modify by [LuoYong 21:03 2019/8/24 ]
     */
    @Test
    public void testMatch() {
        //全匹配
        Boolean allMatchFlag = employeeList.stream().allMatch(e -> e.getStatus().equals(StatusEnm.BUSY));
        System.out.println(allMatchFlag);

        //匹配任意一个
        Boolean anyMatchFlag = employeeList.stream().anyMatch(e -> e.getStatus().equals(StatusEnm.BUSY));
        System.out.println(anyMatchFlag);

        //全部没有匹配上
        Boolean noneMatchFlag = employeeList.stream().noneMatch(e -> e.getStatus().equals(StatusEnm.BUSY));
        System.out.println(noneMatchFlag);
    }

    /**
     * @param
     * @return void
     * @Description: 测试查找
     * @author luoyong
     * @create 21:13 2019/8/24
     * @last modify by [LuoYong 21:13 2019/8/24 ]
     */
    @Test
    public void testFind() {
        //排序后查找到第一个 有可能为空的值放在Optional里面
        Optional<StreamEmployee> streamEmployeeOptional = employeeList.stream().sorted((eOne, eTwo) -> Double.compare(eOne.getSalary(), eTwo.getSalary())).findFirst();
        System.out.println(streamEmployeeOptional.get());

        //在空闲状态当中随便找一个 串行流 查找的元素可能总是同一个
        Optional<StreamEmployee> findAnyEmployeeOp = employeeList.stream().filter(e -> e.getStatus().equals(StatusEnm.FREE)).findAny();
        System.out.println(findAnyEmployeeOp.get());

        //并行流可能查找的元素是不同的
        Optional<StreamEmployee> findAnyEmployeeOpWithParallelStream = employeeList.parallelStream().filter(e -> e.getStatus().equals(StatusEnm.FREE)).findAny();
        System.out.println(findAnyEmployeeOpWithParallelStream.get());
    }


    /**
     * @param
     * @return void
     * @Description: 测试计算
     * count——返回流中元素的总个数
     * max——返回流中最大值
     * min——返回流中最小值
     * @author luoyong
     * @create 21:24 2019/8/24
     * @last modify by [LuoYong 21:24 2019/8/24 ]
     */
    @Test
    public void testCal() {
        Long emCount = employeeList.stream().count();
        System.out.println(emCount);

        //年纪最大的员工
        Optional<StreamEmployee> maxAgeEm = employeeList.stream().max((eOne, eTwo) -> Integer.compare(eOne.getAge(), eTwo.getAge()));
        System.out.println(maxAgeEm.get());

        //最大的年纪
        Optional<Integer> maxAge = employeeList.stream().map(StreamEmployee::getAge).max(Integer::compareTo);
        System.out.println(maxAge.get());
    }

}
