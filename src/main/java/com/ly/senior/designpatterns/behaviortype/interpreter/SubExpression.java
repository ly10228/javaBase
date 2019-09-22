package com.ly.senior.designpatterns.behaviortype.interpreter;

import java.util.HashMap;

/**
 * @author luoyong
 * @Description: SubExpression
 * @create 2019-09-22 17:50
 * @last modify by [LuoYong 2019-09-22 17:50]
 **/
public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }


    /**
     * @param var
     * @return int
     * @Description: 求出left 和 right 表达式相减后的结果
     * @author luoyong
     * @create 17:53 2019/9/22
     * @last modify by [LuoYong 17:53 2019/9/22 ]
     */
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }

}
