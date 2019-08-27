package com.ly.senior.datastructure.stack;

import com.ly.senior.datastructure.stack.utils.OperatorUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author luoyong
 * @Description: PolandNotation
 * @create 2019-08-25 23:08
 * @last modify by [LuoYong 2019-08-25 23:08]
 **/
public class PolandNotation {

    /**
     * @param
     * @return void
     * @Description: 测试逆波兰表达式
     * @author luoyong
     * @create 22:39 2019/8/26
     * @last modify by [LuoYong 22:39 2019/8/26 ]
     */
    @Test
    public void testPolandNotation() {
        //(3+4)×5-6  => 3 4 + 5 × 6 - => 29
        //先给定一个逆波兰表达式(后缀表达式)
        String suffixExpression = "3 4 + 5 * 6 -";
        //1:将后缀表达式村存入到集合当中
        List<String> suffixExpressionList = Arrays.asList(suffixExpression.split(" "));
        //2:遍历集合 配合栈完成计算
        Integer result = calculate(suffixExpressionList);
        System.out.printf("suffixExpression=%d", result);
    }

    /**
     * @param suffixExpressionList 表达式转换成集合
     * @return int
     * @Description: 完成对逆波兰表达式的计算
     * 1:从左到右扫描将3和4压入栈
     * 2:遇到+运算符，将3和4弹出（4为栈顶元素 3为次栈顶元素） 计算出3+4=7 将7入栈
     * 3：将5入栈
     * 4：遇到*号运算符 将 7和5弹出 计算出 7*5=35 将35入栈
     * 5：将6 入栈
     * 6：遇到-号运算符 将35和6弹出 计算出35-6=29 将29入栈
     * @author luoyong
     * @create 23:22 2019/8/26
     * @last modify by [LuoYong 23:22 2019/8/26 ]
     */
    public static int calculate(List<String> suffixExpressionList) {

        //创建一个存储数值的栈
        Stack<String> stack = new Stack<>();
        suffixExpressionList.forEach(item -> {
            //\\d+这个是由两部分组成的，\ 转义符 加\d 是一个正字表达式，标识所有数字及0-9
            if (item.matches("\\d+")) {
                //匹配到多位数
                stack.push(item);
            } else {
                //是运算符号 则弹出栈内元素进行运算
                //第一次 4
                Integer numOne = Integer.parseInt(stack.pop());
                //第一次 3
                Integer numTwo = Integer.parseInt(stack.pop());
                Integer result = OperatorUtils.cal(numOne, numTwo, item);
                //将结果入栈
                stack.push(String.valueOf(result));
            }
        });
        //最终留在栈中的元素就是结果
        return Integer.parseInt(stack.pop());
    }


}
