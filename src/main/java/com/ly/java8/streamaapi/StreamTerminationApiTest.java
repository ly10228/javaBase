package com.ly.java8.streamaapi;

import com.ly.java8.streamaapi.dto.StreamEmployee;
import com.ly.java8.streamaapi.enm.StatusEnm;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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
     * 查询与匹配
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

        //最小的年纪
        Optional<Integer> minAge = employeeList.stream().map(StreamEmployee::getAge).min(Integer::compareTo);
        System.out.println(minAge.get());
    }


    /**
     * ======================================================================
     * 终止操作
     * 规约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
     *
     * ======================================================================
     */

    /**
     * @param
     * @return void
     * @Description: testReduce
     * @author luoyong
     * @create 9:22 2019/8/25
     * @last modify by [LuoYong 9:22 2019/8/25 ]
     */
    @Test
    public void testReduce() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //求和
        Integer sum = integerList.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        //累计计算工资的总和 有起始值 和不可能为空
        Double salarySum = employeeList.stream().map(StreamEmployee::getSalary).reduce(0.0, (x, y) -> x + y);
        System.out.println(salarySum);

        //下面没有起始值 可能为空
        Optional<Double> optionalDouble = employeeList.stream().map(StreamEmployee::getSalary).reduce(Double::sum);
        System.out.println(optionalDouble.get());

        //搜索名字当中出现六的次数
        Optional<Integer> countSixOp = employeeList.stream().map(StreamEmployee::getName).flatMap(StreamOperateApiTest::filterCharacter).map(str -> {
            if (String.valueOf(str).equals("李")) {
                return 1;
            }
            return 0;
        }).reduce(Integer::sum);
        System.out.printf("李出现的次数是 %d", countSixOp.get());
    }


    /**
     * ======================================================================
     * 终止操作
     * 收集
     * collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
     *
     * ======================================================================
     */

    /**
     * @param
     * @return void
     * @Description: testCollect
     * @author luoyong
     * @create 9:52 2019/8/25
     * @last modify by [LuoYong 9:52 2019/8/25 ]
     */
    @Test
    public void testCollect() {
        System.out.println("list----------------------------------");
        List<String> list = employeeList.stream()
                .map(StreamEmployee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("set----------------------------------");
        Set<String> set = employeeList.stream()
                .map(StreamEmployee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("HashSet----------------------------------");
        HashSet<String> hs = employeeList.stream()
                .map(StreamEmployee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);
    }

    /**
     * @param
     * @return void
     * @Description: testCollectCal 测试集合计算
     * @author luoyong
     * @create 9:59 2019/8/25
     * @last modify by [LuoYong 9:59 2019/8/25 ]
     */
    @Test
    public void testCollectCal() {
        System.out.println("集合总数----------------------------------");
        Long emSum = employeeList.stream().collect(Collectors.counting());
        System.out.println(emSum);

        System.out.println("薪资平均值----------------------------------");
        Double averageSalary = employeeList.stream().collect(Collectors.averagingDouble(StreamEmployee::getSalary));
        System.out.println(averageSalary);

        System.out.println("总工资----------------------------------");
        Double sumSalary = employeeList.stream().collect(Collectors.summingDouble(StreamEmployee::getSalary));
        System.out.println(sumSalary);

        System.out.println("最大工资的员工----------------------------------");
        Optional<StreamEmployee> maxSalaryEmployeeOptional = employeeList.stream().collect(Collectors.maxBy((eOne, eTwo) -> Double.compare(eOne.getSalary(), eTwo.getSalary())));
        System.out.println(maxSalaryEmployeeOptional.get());

        System.out.println("最小工资的值----------------------------------");
        Optional<Double> minSalaryOp = employeeList.stream().map(StreamEmployee::getSalary).collect(Collectors.minBy(Double::compareTo));
        System.out.println(minSalaryOp.get());
    }

    /**
     * @param
     * @return void
     * @Description: 测试分组
     * @author luoyong
     * @create 10:14 2019/8/25
     * @last modify by [LuoYong 10:14 2019/8/25 ]
     */
    @Test
    public void testGroup() {
        System.out.println("按照员工的状态分组----------------------------------");
        Map<StatusEnm, List<StreamEmployee>> statusEnmListMap = employeeList.stream().collect(Collectors.groupingBy(StreamEmployee::getStatus));
        System.out.println(statusEnmListMap);

        System.out.println("多级分组----------------------------------");
        System.out.println("先按照员工状态分类 然后按照年龄分类----------------------------------");
        Map<StatusEnm, Map<String, List<StreamEmployee>>> map = employeeList.stream()
                .collect(Collectors.groupingBy(StreamEmployee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() >= 60)
                        return "老年";
                    else if (e.getAge() >= 35)
                        return "中年";
                    else
                        return "成年";
                })));
        System.out.println(map);
    }


    /**
     * @param
     * @return void
     * @Description: testPartition 分区
     * @author luoyong
     * @create 10:45 2019/8/25
     * @last modify by [LuoYong 10:45 2019/8/25 ]
     */
    @Test
    public void testPartition() {
        Map<Boolean, List<StreamEmployee>> map = employeeList.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));
        System.out.println(map);
    }

    /**
     * @param
     * @return void
     * @Description: testSummar
     * @author luoyong
     * @create 10:48 2019/8/25
     * @last modify by [LuoYong 10:48 2019/8/25 ]
     */
    @Test
    public void testSummary() {
        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(StreamEmployee::getSalary));
        System.out.println(doubleSummaryStatistics.getMax());
        System.out.println(doubleSummaryStatistics.getAverage());
        System.out.println(doubleSummaryStatistics.getCount());
        System.out.println(doubleSummaryStatistics.getMin());
        System.out.println(doubleSummaryStatistics.getSum());
    }

    /**
     * @param
     * @return void
     * @Description: testJoin 测试连接字符串
     * @author luoyong
     * @create 10:51 2019/8/25
     * @last modify by [LuoYong 10:51 2019/8/25 ]
     */
    @Test
    public void testJoin() {
        String str = employeeList.stream().map(StreamEmployee::getName).collect(Collectors.joining());
        System.out.println(str);

        String strOne = employeeList.stream().map(StreamEmployee::getName).collect(Collectors.joining(","));
        System.out.println(strOne);


        String strTwo = employeeList.stream().map(StreamEmployee::getName).collect(Collectors.joining(",", "----", "----"));

        System.out.println(strTwo);
    }

    @Test
    public void test() {
        String s = "null";
        if (StringUtils.isBlank(s) || s.equals("null")) {
            System.out.println("无值");
        } else {
            System.out.println("有值");
        }
    }
}
