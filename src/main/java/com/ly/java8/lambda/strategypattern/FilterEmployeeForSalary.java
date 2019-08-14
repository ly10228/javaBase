package com.ly.java8.lambda.strategypattern;

import com.ly.java8.lambda.dto.Employee;

/**
 * @author luoyong
 *  * @create 2019-08-14 20:52
 *  * @last modify by [luoyong 2019-08-14 20:52]
 * @Description: FilterEmployeeForSalary
 **/
public class FilterEmployeeForSalary implements MyPredicate<Employee> {

    /**
     * @param employee
     * @return boolean
     * @Description: 月薪大约等于5000
     * @author luoyong
     * @create 20:54 2019-08-14
     * @last modify by [luoyong 20:54 2019-08-14 ]
     */
    @Override
    public boolean isFit(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
