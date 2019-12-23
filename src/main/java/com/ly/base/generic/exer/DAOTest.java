package com.ly.base.generic.exer;

import org.junit.Test;

import java.util.List;

/**
 * @author luoyong
 * @Description: DAOTest
 * @create 2019-12-23 17:53
 * @last modify by [LuoYong 2019-12-23 17:53]
 **/
public class DAOTest {

    @Test
    public void test() {
        DAO<User> dao = new DAO<User>();

        dao.save("1001", new User(1001, 34, "周杰伦"));
        dao.save("1002", new User(1002, 20, "昆凌"));
        dao.save("1003", new User(1003, 25, "蔡依林"));

        dao.update("1003", new User(1003, 30, "方文山"));

        dao.delete("1002");

        List<User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);
    }
}
