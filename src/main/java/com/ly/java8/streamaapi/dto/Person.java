package com.ly.java8.streamaapi.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luoyong
 *  * @create 2021-06-21 4:35 下午
 *  * @last modify by [luoyong 2021-06-21 4:35 下午]
 * @Description: person
 **/
@Data
public class Person implements Serializable {
    private Long id;

    private Date date;
}
