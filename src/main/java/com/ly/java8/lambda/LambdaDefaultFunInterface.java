package com.ly.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author luoyong
 *  * @create 2019-08-16 16:46
 *  * @last modify by [luoyong 2019-08-16 16:46]
 * @Description: LambdaDefaultFunInterface 内置四大函数式接口
 * Java8 内置的四大核心函数式接口
 * <p>
 * Consumer<T> : 消费型接口
 * void accept(T t);
 * <p>
 * Supplier<T> : 供给型接口
 * T get();
 * <p>
 * Function<T, R> : 函数型接口
 * R apply(T t);
 * <p>
 * Predicate<T> : 断言型接口
 * boolean test(T t);
 **/
public class LambdaDefaultFunInterface {

    /**
     * @return void
     * @Description: Predicate<T>  boolean test(T t) 断言型接口： 返回true或者false
     * @author luoyong
     * @create 16:47 2019-08-16
     * @last modify by [luoyong 16:47 2019-08-16 ]
     */
    @Test
    public void testPredicate() {
        List<String> list = Arrays.asList("Hello", "ly", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);

        for (String str : strList) {
            System.out.println(str);
        }
    }

    /**
     * @param list 字符串集合
     * @param pre  接口实现
     * @return
     * @Description: 将满足条件的字符串，放入集合中
     * @author luoyong
     * @create 16:48 2019-08-16
     * @last modify by [luoyong 16:48 2019-08-16 ]
     */
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }

        return strList;
    }


    /**
     * @return void
     * @Description: 测试消费型接口 void accept(T t)
     * @author luoyong
     * @create 16:53 2019-08-16
     * @last modify by [luoyong 16:53 2019-08-16 ]
     */
    @Test
    public void testConsumer() {
        happy(10000, (m) -> System.out.println("你们刚哥喜欢大宝剑，每次消费：" + m + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    /**
     * @return void
     * @Description: 测试供给型接口    T get()
     * @author luoyong
     * @create 16:55 2019-08-16
     * @last modify by [luoyong 16:55 2019-08-16 ]
     */
    @Test
    public void testSupplier() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    //需求：产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }

        return list;
    }


    /**
     * @return void
     * @Description: Function<T, R> 函数型接口：   R apply(T t)
     * @author luoyong
     * @create 16:56 2019-08-16
     * @last modify by [luoyong 16:56 2019-08-16 ]
     */
    @Test
    public void testFunction() {
        String newStr = strHandler("\t\t\t 我大别山威武   ", (str) -> str.trim());
        System.out.println(newStr);

        String subStr = strHandler("我大别山威武", (str) -> str.substring(2, 5));
        System.out.println(subStr);
    }

    //需求：用于处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }


}
