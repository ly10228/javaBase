package com.ly.senior.datastructure.stack.utils;

import com.ly.senior.datastructure.stack.enm.OperatorPriorityEnum;

/**
 * @author luoyong
 * @Description: OperatorUtils
 * @create 2019-08-25 16:02
 * @last modify by [LuoYong 2019-08-25 16:02]
 **/
public class OperatorUtils {
    /**
     * @param oper 操作符
     * @return int
     * @Description: 获取操作符的优先级
     * @author luoyong
     * @create 15:55 2019/8/25
     * @last modify by [LuoYong 15:55 2019/8/25 ]
     */
    public static int getPriority(String oper) {
        if (OperatorPriorityEnum.ONE.getCode().contains(oper)) {
            return OperatorPriorityEnum.ONE.getPriority();
        } else if (OperatorPriorityEnum.ZERO.getCode().contains(oper)) {
            return OperatorPriorityEnum.ZERO.getPriority();
        } else {
            return -1;
        }
    }

    /**
     * @param oper 操作符
     * @return boolean
     * @Description: 判断操作符是合格
     * @author luoyong
     * @create 15:59 2019/8/25
     * @last modify by [LuoYong 15:59 2019/8/25 ]
     */
    public static boolean isOper(char oper) {
        return OperatorPriorityEnum.ALL.getCode().contains(String.valueOf(oper));
    }

    /**
     * @param numOne
     * @param numTwo
     * @param oper   运算符
     * @return int
     * @Description: 计算
     * @author luoyong
     * @create 16:35 2019/8/25
     * @last modify by [LuoYong 16:35 2019/8/25 ]
     */
    public static int cal(int numOne, int numTwo, String oper) {
        int res = 0; // res 用于存放计算的结果
        switch (oper) {
            case "+":
                res = numOne + numTwo;
                break;
            case "-":
                res = numTwo - numOne;// 注意顺序
                break;
            case "*":
                res = numOne * numTwo;
                break;
            case "/":
                res = numTwo / numOne;
                break;
            default:
                break;
        }
        return res;
    }


}
