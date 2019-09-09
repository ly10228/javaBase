package com.ly.senior.designpatterns.uml.aggregation;

import lombok.Data;

/**
 * @author luoyong
 * @Description: Computer
 * @create 2019-09-07 17:04
 * @last modify by [LuoYong 2019-09-07 17:04]
 **/
@Data
public class Computer {
    /**
     * 鼠标可以和computer分离
     */
    private Mouse mouse;
    /**
     * 显示器可以和Computer分离
     */
    private Moniter moniter;
}
