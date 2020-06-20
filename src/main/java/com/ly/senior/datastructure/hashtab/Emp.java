package com.ly.senior.datastructure.hashtab;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Emp
 * @create 2020-06-20 13:42
 * @last modify by [LuoYong 2020-06-20 13:42]
 **/
@Data
public class Emp {

    private int id;
    private String name;
    private Emp next;
}
