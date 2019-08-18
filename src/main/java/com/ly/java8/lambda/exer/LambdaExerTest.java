package com.ly.java8.lambda.exer;

import com.ly.java8.lambda.dto.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author luoyong
 * @Description: LambdaExerTest
 * @create 2019-08-18 10:02
 * @last modify by [LuoYong 2019-08-18 10:02]
 **/
public class LambdaExerTest {

    /**
     * @Description: 员工集合初始化
     * @author luoyong
     * @create 10:03 2019/8/18
     * @last modify by [LuoYong 10:03 2019/8/18 ]
     * @param null
     * @return
     */
    List<Employee> employeeList = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王老五", 59, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    /**
     * @param
     * @return void
     * @Description: 员工按照年龄和姓名排序
     * 先按照年龄比 年龄相同按照姓名比
     * @author luoyong
     * @create 10:05 2019/8/18
     * @last modify by [LuoYong 10:05 2019/8/18 ]
     */
    @Test
    public void testOrderByAgeAndName() {
        Collections.sort(employeeList, (eOne, eTwo) -> {
            int ageOne = eOne.getAge();
            int ageTwo = eTwo.getAge();
            if (ageOne == ageTwo) {
                return eOne.getName().compareTo(eTwo.getName());
            }
            return -Integer.compare(ageOne, ageTwo);
        });
        employeeList.forEach(System.out::println);
    }


    /**
     * @param
     * @return void
     * @Description: testLambdaDealString 处理字符串
     * @author luoyong
     * @create 10:23 2019/8/18
     * @last modify by [LuoYong 10:23 2019/8/18 ]
     */
    @Test
    public void testLambdaDealString() {
        String trimStr = dealString("\t\t\t 20180818001   ", (str) -> str.trim());
        System.out.println(trimStr);

        String upper = dealString("java", str -> str.toUpperCase());
        System.out.println(upper);

        String subString = dealString("spring", (str) -> {
            String newSubString = str.toUpperCase();
            return newSubString.substring(1, 3);
        });
        System.out.println(subString);
    }

    /**
     * @param str           字符串
     * @param stringHandler 处理字符串的接口
     * @return java.lang.String
     * @Description: dealString
     * @author luoyong
     * @create 10:25 2019/8/18
     * @last modify by [LuoYong 10:25 2019/8/18 ]
     */
    public String dealString(String str, StringHandler stringHandler) {
        return stringHandler.handler(str);
    }


    /**
     * @param
     * @return void
     * @Description: testHandlerLong
     * @author luoyong
     * @create 10:39 2019/8/18
     * @last modify by [LuoYong 10:39 2019/8/18 ]
     */
    @Test
    public void testHandlerLong() {
        dealLong(100L,200L,(x,y)->{return x*y;});

        dealLong(100L,200L,(x,y)->{return x+y;});
    }


    /**
     * @param numOne      参数一
     * @param numTwo      参数二
     * @param longHandler Long处理的接口
     * @return void
     * @Description: dealLong
     * @author luoyong
     * @create 10:38 2019/8/18
     * @last modify by [LuoYong 10:38 2019/8/18 ]
     */
    public void dealLong(Long numOne, Long numTwo, LongHandler<Long, Long> longHandler) {
        System.out.println(longHandler.handler(numOne, numTwo));
    }


}
