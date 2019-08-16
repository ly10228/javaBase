package com.ly.java8.lambda;

import com.ly.java8.lambda.strategypattern.MyFun;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author luoyong
 *  * @create 2019-08-14 14:26
 *  * @last modify by [luoyong 2019-08-14 14:26]
 * @Description: LambdaRule 表达式规则
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符
 * 箭头操作符将 Lambda 表达式拆分成两部分：
 * <p>
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能， 即 Lambda 体
 * <p>
 * 语法格式一：无参数，无返回值
 * () -> System.out.println("Hello Lambda!");
 * <p>
 * 语法格式二：有一个参数，并且无返回值
 * (x) -> System.out.println(x)
 * <p>
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * x -> System.out.println(x)
 * <p>
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 * Comparator<Integer> com = (x, y) -> {
 * System.out.println("函数式接口");
 * return Integer.compare(x, y);
 * };
 * <p>
 * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
 * Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 * <p>
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * (Integer x, Integer y) -> Integer.compare(x, y);
 * <p>
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * <p>
 * 二、Lambda 表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 * 可以检查是否是函数式接口
 **/
public class LambdaRule {

    /**
     * @return void
     * @Description: 测试无参数 无返回值
     * () -> System.out.println("Hello Lambda!");
     * @author luoyong
     * @create 16:19 2019-08-16
     * @last modify by [luoyong 16:19 2019-08-16 ]
     */
    @Test
    public void testNoParamNoResult() {
        //jdk 1.7 前，必须是 final
        int num = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!" + num);
            }
        };

        r.run();

        System.out.println("-------------------------------");
        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }

    /**
     * @return void
     * @Description: 一个参数 无返回值
     * (x) -> System.out.println(x)
     * 若只有一个参数 小括号可以省略不写
     * x -> System.out.println(x)
     * @author luoyong
     * @create 16:20 2019-08-16
     * @last modify by [luoyong 16:20 2019-08-16 ]
     */
    @Test
    public void testOneParamNoResult() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("测试20190816001");
    }


    /**
     * @return void
     * @Description: 两个参数以上 并且有返回值
     * Comparator<Integer> com = (x, y) -> {
     * System.out.println("函数式接口");
     * return Integer.compare(x, y);
     * };
     * @author luoyong
     * @create 16:24 2019-08-16
     * @last modify by [luoyong 16:24 2019-08-16 ]
     */
    @Test
    public void testTwoParamHaveResult() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    /**
     * @return void
     * @Description: 两个参数以上 并且有返回值 Lambda 体中只有一条语句
     * return 和 大括号都可以省略不写
     * Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
     * @author luoyong
     * @create 16:25 2019-08-16
     * @last modify by [luoyong 16:25 2019-08-16 ]
     */
    @Test
    public void testTwoParamHaveResultAndOnlyOneStatements() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void testFive() {
//		String[] strs;
//		strs = {"aaa", "bbb", "ccc"};

        List<String> list = new ArrayList<>();

        show(new HashMap<>());
    }

    public void show(Map<String, Integer> map) {

    }

    /**
     * @return void
     * @Description: 对一个数进行运算
     * @author luoyong
     * @create 16:30 2019-08-16
     * @last modify by [luoyong 16:30 2019-08-16 ]
     */
    @Test
    public void test6() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);

        System.out.println(operation(200, (y) -> y + 200));
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }
}
