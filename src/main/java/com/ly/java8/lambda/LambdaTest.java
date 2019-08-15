package com.ly.java8.lambda;

import com.ly.java8.lambda.dto.Employee;
import com.ly.java8.lambda.strategypattern.FilterEmployeeForAge;
import com.ly.java8.lambda.strategypattern.FilterEmployeeForSalary;
import com.ly.java8.lambda.strategypattern.MyPredicate;
import org.junit.Test;

import java.util.*;

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

    /**
     * @return void
     * @Description: 用Lambda来实现排序
     * @author luoyong
     * @create 17:41 2019-08-14
     * @last modify by [luoyong 17:41 2019-08-14 ]
     */
    @Test
    public void testUseLambda() {
        Comparator<Employee> com = (x, y) -> Integer.compare(x.getAge(), y.getAge());
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
    }


    List<Employee> employeeList = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 8888.88),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );


    /**
     * @return void
     * @Description: 测试  获取公司中年龄小于 35 的员工信息 或者 获取公司中工资大于 5000 的员工信息
     * @author luoyong
     * @create 17:54 2019-08-14
     * @last modify by [luoyong 17:54 2019-08-14 ]
     */
    @Test
    public void testThree() {
        //1:获取公司中年龄小于 35 的员工信息
        System.out.println("获取公司中年龄小于 35 的员工信息");
        List<Employee> employeeAgeList = filterEmployeeAge(employeeList);
        for (Employee employee : employeeAgeList) {
            System.out.println(employee);
        }
        System.out.println("获取公司中工资大于 5000 的员工信息");
        //2:获取公司中工资大于 5000 的员工信息
        List<Employee> employeeSalaryList = filterEmployeeSalary(employeeList);
        for (Employee employee : employeeSalaryList) {
            System.out.println(employee);
        }
    }

    /**
     * @param employeeList 员工集合
     * @return
     * @Description: 获取公司中年龄小于 35 的员工信息
     * @author luoyong
     * @create 17:54 2019-08-14
     * @last modify by [luoyong 17:54 2019-08-14 ]
     */
    public List<Employee> filterEmployeeAge(List<Employee> employeeList) {
        List<Employee> list = new ArrayList<>();

        for (Employee emp : employeeList) {
            if (emp.getAge() <= 35) {
                list.add(emp);
            }
        }

        return list;
    }


    /**
     * @param employeeList 员工集合
     * @return
     * @Description: 获取公司中工资大于 5000 的员工信息
     * @author luoyong
     * @create 17:54 2019-08-14
     * @last modify by [luoyong 17:54 2019-08-14 ]
     */
    public List<Employee> filterEmployeeSalary(List<Employee> employeeList) {
        List<Employee> list = new ArrayList<>();

        for (Employee emp : employeeList) {
            if (emp.getSalary() >= 5000) {
                list.add(emp);
            }
        }

        return list;
    }


    /**
     * @param employeeList 员工列表
     * @param mp           员工接口
     * @return
     * @Description: 策略模式处理员工
     * @author luoyong
     * @create 16:13 2019-08-15
     * @last modify by [luoyong 16:13 2019-08-15 ]
     */
    public List<Employee> filterEmployee(List<Employee> employeeList, MyPredicate<Employee> mp) {
        List<Employee> list = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (mp.isFit(employee)) {
                list.add(employee);
            }
        }

        return list;
    }


    /**
     * @return void
     * @Description: 优化方式一--使用策略模式过滤员工信息
     * @author luoyong
     * @create 16:19 2019-08-15
     * @last modify by [luoyong 16:19 2019-08-15 ]
     */
    @Test
    public void testStrategyFilterEmp() {
        System.out.println("根据年龄过滤");
        //根据年龄过滤
        List<Employee> employeeAgeList = filterEmployee(employeeList, new FilterEmployeeForAge());
        employeeAgeList.forEach(e -> System.out.println(e));
        System.out.println("根据薪资过滤");
        List<Employee> employeeSalaryList = filterEmployee(employeeList, new FilterEmployeeForSalary());
        employeeSalaryList.forEach(e -> System.out.println(e));
    }

    /**
     * @return void
     * @Description: 优化方式二--匿名内部类来过滤员工信息
     * @author luoyong
     * @create 16:26 2019-08-15
     * @last modify by [luoyong 16:26 2019-08-15 ]
     */
    @Test
    public void testAnonymousClassFilterEmp() {
        System.out.println("根据年龄过滤");
        //根据年龄过滤
        List<Employee> employeeAgeList = filterEmployee(employeeList, new MyPredicate<Employee>() {
            @Override
            public boolean isFit(Employee employee) {
                return employee.getAge() > 10;
            }
        });
        employeeAgeList.forEach(e -> System.out.println(e));

        System.out.println("根据薪资过滤");
        List<Employee> employeeSalaryList = filterEmployee(employeeList, new MyPredicate<Employee>() {
            @Override
            public boolean isFit(Employee employee) {
                return employee.getSalary() > 1000;
            }
        });
        employeeSalaryList.forEach(e -> System.out.println(e));
    }


    /**
     * @return void
     * @Description: 优化方式三--根据Lambda表达式过滤
     * @author luoyong
     * @create 16:30 2019-08-15
     * @last modify by [luoyong 16:30 2019-08-15 ]
     */
    @Test
    public void testLambdaFilterEmp() {
        System.out.println("根据年龄过滤");
        //根据年龄过滤
        List<Employee> employeeAgeList = filterEmployee(employeeList, employee -> employee.getAge() > 10);
        employeeAgeList.forEach(System.out::println);

        System.out.println("根据薪资过滤");
        List<Employee> employeeSalaryList = filterEmployee(employeeList, employee -> employee.getSalary() > 6000);
        employeeSalaryList.forEach(System.out::println);
    }

    /**
     * @return void
     * @Description: 优化方式四--根据StreamAPI过滤员工数据
     * @author luoyong
     * @create 16:45 2019-08-15
     * @last modify by [luoyong 16:45 2019-08-15 ]
     */
    @Test
    public void testStreamAPIFilterEmp() {

        System.out.println("根据年龄过滤");
        employeeList.stream().filter(employee -> employee.getAge() > 10).forEach(System.out::println);

        System.out.println("根据年龄过滤--只显示前两条");
        employeeList.stream().filter(employee -> employee.getAge() > 10).limit(2).forEach(System.out::println);

        System.out.println("根据薪资");
        employeeList.stream().filter(employee -> employee.getSalary() > 2000).forEach(System.out::println);
    }


}
