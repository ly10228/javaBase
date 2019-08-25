package com.ly.senior.datastructure.stack;

import com.ly.senior.datastructure.stack.utils.OperatorUtils;
import org.junit.Test;

/**
 * @author luoyong
 * @Description: Calculator
 * @create 2019-08-25 15:20
 * @last modify by [LuoYong 2019-08-25 15:20]
 **/
public class Calculator {
    @Test
    public void testCalculator() {
        //1:定义表达式
//        String expression = "7*2*2-5+1-5+3-4";
        String expression = "7*2+3";
        //1.1 初始化两个栈 栈1存数值 栈2存储运算符号
        //数值栈
        ArrayStack numStack = new ArrayStack(40);
        //运算符号栈
        ArrayStack operStack = new ArrayStack(40);
        //1.2 定义需要用到的变量
        int index = 0;
        //每次扫描对应的值
        char ch = ' ';
        while (true) {
            //开始扫描expression
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么
            if (OperatorUtils.isOper(ch)) {
                //是运算符
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                    index++;
                } else {
                    //栈不为空
                    index = dealOperStack(operStack, ch, index, numStack);
                }
            } else {
                //是数值 直接入栈操作
                index = dealNumStack(expression, ch, numStack, index);
            }
            if (index == expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
        while (true) {
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if (operStack.isEmpty()) {
                break;
            }
            int numOne = numStack.pop();
            int numTwo = numStack.pop();
            char lastCh = (char) operStack.pop();
            int result = OperatorUtils.cal(numOne, numTwo, String.valueOf(lastCh));
            numStack.push(result);//入栈
        }
        //将数栈的最后数，pop出，就是结果
        int result = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, result);
    }

    /**
     * @param expression 表达式
     * @param index      当前ch的下标
     * @param ch         字符
     * @param numStack   数值栈
     * @return void
     * @Description: 处理数值栈
     * 入栈的可能是一个多位数
     * 1:当处理多位数的时候 不能立即入栈
     * 2：在处理的时候需要再看ch的后一位，如果是数值就在进行扫描 如果是符号就入栈
     * @author luoyong
     * @create 16:52 2019/8/25
     * @last modify by [LuoYong 16:52 2019/8/25 ]
     */
    private int dealNumStack(String expression, char ch, ArrayStack numStack, int index) {
        //用户拼接多位数
        String keepNum = "";
        keepNum += ch;
        if (index == expression.length() - 1) {
            //最后一个元素了
            numStack.push(Integer.parseInt(keepNum));
            return index += 1;
        }
        //判断下一个字符是不是数字 如果是数字 就继续扫描 如果是运算符则进行运算
        char nextCh = expression.substring(index + 1, index + 2).charAt(0);
        if (OperatorUtils.isOper(nextCh)) {
            //ch的下一位是操作符
            //最后一个元素了
            numStack.push(Integer.parseInt(keepNum));
            index += 1;
            keepNum = "";
            return index;
        }
        if (index >= expression.length()) {
            return index;
        }
        return index;
    }


    /**
     * @param operStack 运算符栈
     * @param ch        字符
     * @param index     下标
     * @param numStack  数值栈
     * @return void
     * @Description: 运算
     * @author luoyong
     * @create 17:21 2019/8/25
     * @last modify by [LuoYong 17:21 2019/8/25 ]
     */
    private int dealOperStack(ArrayStack operStack, char ch, int index, ArrayStack numStack) {
        //1:判断运算符号栈是否为空
        if (operStack.isEmpty()) {
            //运算符号栈为空
            operStack.push(ch);
            index += 1;
            return index;
        }
        //不为空 获取上一个运算符
        char preChar = (char) operStack.getTopValue();
        int preCharPriority = OperatorUtils.getPriority(String.valueOf(preChar));

        //本次运算符的优先级
        int currentCharPriority = OperatorUtils.getPriority(String.valueOf(ch));

        if (currentCharPriority <= preCharPriority) {
            //做运算
            int numOne = numStack.pop();
            //栈地元素
            int numTwo = numStack.pop();
            //运算符栈出栈
            operStack.pop();
            operStack.push(ch);
            int resultNum = OperatorUtils.cal(numOne, numTwo, String.valueOf(preChar));
            //存入数值栈
            numStack.push(resultNum);
            index += 1;

        } else {
            //不做运算 入栈
            operStack.push(ch);
            index += 1;
        }
        return index;
    }
}

