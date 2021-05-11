package com.ly.base.jvm.gc.concept.reference.dto;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2021-02-25 2:03 下午
 *  * @last modify by [luoyong 2021-02-25 2:03 下午]
 * @Description: 用户
 **/
@Data
public class User {

    private int id;

    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
