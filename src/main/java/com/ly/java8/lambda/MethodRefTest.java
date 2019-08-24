package com.ly.java8.lambda;

import com.ly.java8.lambda.dto.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @author luoyong
 * @Description: MethodRefTest
 * 方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * @create 2019-08-18 10:58
 * @last modify by [LuoYong 2019-08-18 10:58]
 **/
public class MethodRefTest {

    /**
     * @param
     * @return void
     * @Description: 第一种-->对象::方法名
     * 方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
     * @author luoyong
     * @create 11:07 2019/8/18
     * @last modify by [LuoYong 11:07 2019/8/18 ]
     */
    @Test
    public void testObjectMethod() {
        PrintStream ps = System.out;
        Consumer<String> conOne = (str) -> ps.println(str);
        conOne.accept("Hello World！");

        System.out.println("--------------------------------");

        Consumer<String> conTwo = ps::println;
        conTwo.accept("Hello Java8！");

        Consumer<String> conThree = System.out::println;
        conThree.accept("spring");

        Employee employee = new Employee(101, "张三", 18, 9999.99);
        Supplier<String> supEmName = () -> employee.getName();
        String emName = supEmName.get();
        System.out.println(emName);

        Supplier<String> supplierEmName = employee::getName;
        String emNameTwo = supplierEmName.get();
        System.out.println(emNameTwo);

        Supplier<Integer> supplierAge = employee::getAge;
        System.out.println(supplierAge.get());
    }

    /**
     * @param
     * @return void
     * @Description: 类 :: 方法名
     * @author luoyong
     * @create 15:33 2019/8/18
     * @last modify by [LuoYong 15:33 2019/8/18 ]
     */
    @Test
    public void testObjectStaticMethod() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> integerComparator = Integer::compareTo;
        //原始形式
        System.out.println("原始形式");
        BiFunction<Integer, Integer, Integer> fun = (x, y) -> Math.max(x, y);
        Integer max = fun.apply(1, 3);
        System.out.printf("max=%d\n", max);
        //类::方法名形式
        System.out.println("类::方法名形式");
        BiFunction<Integer, Integer, Integer> funTwo = Math::max;
        System.out.printf("funTwoMax=%d", funTwo.apply(1, 6));

        //方式一Function
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        System.out.println(biPredicate.test("abc", "abc"));

        //方式二
        //类::方法名形式
        BiPredicate<String, String> biPredicateTwo = String::equals;
        System.out.println(biPredicateTwo.test("abc", "abc"));

        Function<Employee, String> function = employee -> employee.show();
        System.out.println(function.apply(new Employee()));

        Function<Employee, String> functionTwo =Employee::show;
        System.out.println(functionTwo.apply(new Employee()));

    }

}
