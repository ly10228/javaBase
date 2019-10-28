package com.ly.senior.designpatterns.behaviortype.interpreter;

import java.util.HashMap;

/**
 * @author luoyong
 * @Description: Expression
 * @create 2019-09-22 17:49
 * @last modify by [LuoYong 2019-09-22 17:49]
 **/
public abstract class Expression {
    /**
     * @param var
     * @return int
     * @Description: interpreter
     * a + b - c
     * 解释公式和数值, key 就是公式(表达式) 参数[a,b,c], value就是就是具体值
     * HashMap {a=10, b=20}
     * @author luoyong
     * @create 17:49 2019/9/22
     * @last modify by [LuoYong 17:49 2019/9/22 ]
     */
    public abstract int interpreter(HashMap<String, Integer> var);
}
