package com.ly.senior.designpatterns.structured.flyewight;

import lombok.Data;

/**
 * @author luoyong
 * @Description: User
 * @create 2019-09-15 16:34
 * @last modify by [LuoYong 2019-09-15 16:34]
 **/
@Data
public class User {

    private String name;

    public User(String name) {
        super();
        this.name = name;
    }
}
