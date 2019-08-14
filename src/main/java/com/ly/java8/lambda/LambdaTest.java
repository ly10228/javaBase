package com.ly.java8.lambda;

import com.ly.java8.lambda.dto.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author luoyong
 *  * @create 2019-08-14 14:26
 *  * @last modify by [luoyong 2019-08-14 14:26]
 * @Description: LambdaTest
 **/
public class LambdaTest {
    /**
     * @return void
     * @Description: 测试匿名类
     * @author luoyong
     * @create 16:07 2019-08-14
     * @last modify by [luoyong 16:07 2019-08-14 ]
     */
    @Test
    public void testAnonymousClass() {
        //按照员工年龄从小到大排序
        Comparator<Employee> com = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int emOneAge = o1.getAge();
                int emTwoAge = o2.getAge();
                int compare = Integer.compare(emOneAge, emTwoAge);
                return compare;
            }
        };

        TreeSet<Employee> employeeTreeSet = new TreeSet<>(com);

        employeeTreeSet.add(new Employee(1, "Tom", 12, 50000));
        employeeTreeSet.add(new Employee(2, "Jerry", 32, 6000));
        employeeTreeSet.add(new Employee(3, "Jim", 2, 7000));
        employeeTreeSet.add(new Employee(4, "Mike", 65, 8000));
        employeeTreeSet.add(new Employee(5, "Mary", 33, 9000));
        employeeTreeSet.add(new Employee(6, "Jack", 36, 10000));
        employeeTreeSet.add(new Employee(7, "Jack", 56, 11000));

        //遍历
        for (Employee employee : employeeTreeSet) {
            System.out.println(employee);
        }

        TreeSet<String> tsTwo = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }

        });

        tsTwo.add("aaaaaaa");
        tsTwo.add("aaa");
        tsTwo.add("aaaa");
        for (String string : tsTwo) {
            System.out.println(string);
        }

    }


}
