package com.ly.java8.streamaapi;

import com.google.common.collect.Lists;
import com.ly.java8.lambda.dto.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author luoyong
 *  * @create 2019-08-14 16:01
 *  * @last modify by [luoyong 2019-08-14 16:01]
 * @Description: StreamCreateAPITest
 * 1：stream创建
 * 2：stream中间操作
 * 3：终止操作
 **/
public class StreamCreateAPITest {

    /**
     * @param
     * @return void
     * @Description: 测试stream的创建
     * @author luoyong
     * @create 10:15 2019/8/24
     * @last modify by [LuoYong 10:15 2019/8/24 ]
     */
    @Test
    public void testStreamCreate() {
        //1：Collection系列集合提供的stream（）或者parallelStream
        List<String> list = Lists.newArrayList();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        Stream<String> stringStream = list.stream();
        System.out.println(stringStream);

        //2:通过Arrays中静态方法stream获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(employees);

        //3：通过Stream类中的静态方法 of()
        Stream<String> stringStreamOne = Stream.of("aa", "bb", "cc");

        //4:创建无限流 迭代
        Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2).limit(10);
        integerStream.forEach(System.out::println);
        //4.1 生成
        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);
    }
}
