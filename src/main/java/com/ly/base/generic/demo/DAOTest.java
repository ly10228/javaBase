package com.ly.base.generic.demo;

import com.ly.base.generic.demo.dto.Customer;
import com.ly.base.generic.demo.dto.Student;
import org.junit.Test;

import java.util.List;

/**
 * @author luoyong
 *  * @create 2019-12-16 21:32
 *  * @last modify by [luoyong 2019-12-16 21:32]
 * @Description: DAOTest
 **/
public class DAOTest {

    @Test
    public void test() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());
        List<Customer> forList = customerDAO.getForList(10);

        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getIndex(1);
    }
}
