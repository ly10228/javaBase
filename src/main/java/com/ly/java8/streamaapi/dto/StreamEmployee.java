package com.ly.java8.streamaapi.dto;

import com.ly.java8.streamaapi.enm.StatusEnm;
import lombok.Data;

import java.io.Serializable;

/**
 * @author luoyong
 * @Description: StreamEmployee
 * @create 2019-08-24 16:54
 * @last modify by [LuoYong 2019-08-24 16:54]
 **/
@Data
public class StreamEmployee implements Serializable {

    /**
     * 主键id
     */
    private int id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户年龄
     */
    private int age;
    /**
     * 工资
     */
    private double salary;
    /**
     * 状态
     */
    private StatusEnm status;

    public StreamEmployee(int id, String name, int age, double salary, StatusEnm status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }


}
