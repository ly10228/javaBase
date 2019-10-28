package com.ly.senior.designpatterns.behaviortype.iterator;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luoyong
 * @Description: Department
 * @create 2019-09-21 22:41
 * @last modify by [LuoYong 2019-09-21 22:41]
 **/
@Data
public class Department implements Serializable {

    private String name;

    private String desc;

    public Department(String name, String desc) {
        super();
        this.name = name;
        this.desc = desc;
    }
}
