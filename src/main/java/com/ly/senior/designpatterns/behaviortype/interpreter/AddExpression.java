package com.ly.senior.designpatterns.behaviortype.interpreter;

import java.util.HashMap;

/**
 * @author luoyong
 * @Description: AddExpression
 * @create 2019-09-22 17:56
 * @last modify by [LuoYong 2019-09-22 17:56]
 **/
public class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * @param var
     * @return int
     * @Description: 处理相加
     * var 仍然是 {a=10,b=20}..
     * @author luoyong
     * @create 17:56 2019/9/22
     * @last modify by [LuoYong 17:56 2019/9/22 ]
     */
    public int interpreter(HashMap<String, Integer> var) {
        //super.left.interpreter(var) ： 返回 left 表达式对应的值 a = 10
        //super.right.interpreter(var): 返回right 表达式对应值 b = 20
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
