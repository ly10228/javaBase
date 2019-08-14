package com.ly.java8.lambda.strategypattern;

import com.ly.java8.lambda.dto.Employee;

/**
 * @author luoyong
 *  * @create 2019-08-14 20:52
 *  * @last modify by [luoyong 2019-08-14 20:52]
 * @Description: FilterEmployeeForAge
 **/
public class FilterEmployeeForAge implements MyPredicate<Employee> {

    /**
     * @param employee
     * @return boolean
     * @Description: 年龄小于等于35
     * @author luoyong
     * @create 20:55 2019-08-14
     * @last modify by [luoyong 20:55 2019-08-14 ]
     */
    @Override
    public boolean isFit(Employee employee) {
        return employee.getAge() <= 35;
    }
}
