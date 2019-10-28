package com.ly.senior.designpatterns.behaviortype.interpreter;

import lombok.Data;

import java.util.HashMap;

/**
 * @author luoyong
 * @Description: 变量的解释器
 * @create 2019-09-22 17:54
 * @last modify by [LuoYong 2019-09-22 17:54]
 **/
@Data
public class VarExpression extends Expression {

    /**
     * key=a,key=b,key=c
     */
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     * @param var
     * @return int
     * @Description: var 就是{a=10, b=20}
     * interpreter 根据 变量名称，返回对应值
     * @author luoyong
     * @create 17:55 2019/9/22
     * @last modify by [LuoYong 17:55 2019/9/22 ]
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
