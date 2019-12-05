package com.ly.base.opp.threecharacteristics.abstraction.exer2;

import org.junit.Test;

import java.util.Calendar;

/**
 * @author luoyong
 * @Description: PayrollSystem
 * @create 2019-11-18 21:47
 * @last modify by [LuoYong 2019-11-18 21:47]
 **/
public class PayrollSystem {

    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();
        //获取当前的月份
        int month = calendar.get(Calendar.MONTH);

        Employee[] employees = new Employee[2];
        employees[0] = new SalariedEmployee("马超", 1002, new MyDate(1992, 2, 28), 10000);
        employees[1] = new HourlyEmployee("孙膑", 2001, new MyDate(1991, 11, 6), 60, 240);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
            double salary = employees[i].earnings();
            System.out.println("月工资为：" + salary);

            if ((month + 1) == employees[i].getBirthday().getMonth()) {
                System.out.println("生日快乐！奖励100元");
            }

        }
    }
}
