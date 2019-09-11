package com.ly.senior.designpatterns.creational.builder.improve;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2019-09-11 16:40
 *  * @last modify by [luoyong 2019-09-11 16:40]
 * @Description: House --产品--Product
 **/
@Data
public class House {
    /**
     * 地基
     */
    private String foundation;

    /**
     * 墙
     */
    private String wall;

    /**
     * 房顶
     */
    private String roofed;


}
