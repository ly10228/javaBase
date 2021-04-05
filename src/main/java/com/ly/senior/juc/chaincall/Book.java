package com.ly.senior.juc.chaincall;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author luoyong
 *  * @create 2021-04-05 11:43 上午
 *  * @last modify by [luoyong 2021-04-05 11:43 上午]
 * @Description: @Accessors(chain = true) 开始链式调用
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
    private Integer id;
    private String bookName;
    private double price;
    private String author;
}
