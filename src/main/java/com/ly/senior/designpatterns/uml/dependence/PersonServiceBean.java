package com.ly.senior.designpatterns.uml.dependence;

import lombok.Data;

/**
 * @author luoyong
 * @Description: PersonServiceBean
 * @create 2019-09-07 16:40
 * @last modify by [LuoYong 2019-09-07 16:40]
 **/
@Data
public class PersonServiceBean {
    // 类
    private PersonDao personDao;

    public void save(Person person) {
    }

    public IDCard getIDCard(Integer personid) {
        return null;
    }

    public void modify() {
        Department department = new Department();
    }
}
