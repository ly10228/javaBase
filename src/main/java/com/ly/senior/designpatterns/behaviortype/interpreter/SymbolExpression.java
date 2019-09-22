package com.ly.senior.designpatterns.behaviortype.interpreter;

import lombok.Data;

import java.util.HashMap;

/**
 * @author luoyong
 * @Description: SymbolExpression
 * @create 2019-09-22 17:51
 * @last modify by [LuoYong 2019-09-22 17:51]
 **/
@Data
public class SymbolExpression extends Expression {

    protected Expression left;

    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * @param var
     * @return int
     * @Description: 因为 SymbolExpression 是让其子类来实现，因此 interpreter 是一个默认实现
     * @author luoyong
     * @create 17:52 2019/9/22
     * @last modify by [LuoYong 17:52 2019/9/22 ]
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
