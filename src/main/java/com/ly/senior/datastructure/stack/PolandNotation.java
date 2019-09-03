package com.ly.senior.datastructure.stack;

import com.google.common.collect.Lists;
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
     * @param
     * @return void
     * @Description: 测试逆波兰表达式完整版本
     * @author luoyong
     * @create 21:38 2019/8/27
     * @last modify by [LuoYong 21:38 2019/8/27 ]
     */
    @Test
    public void test() {
        //1:给出表达式
        String s = "1+((2+3)*4)-5";
        //2:将中缀表达式转换成List<String>
        //fixExpressionStringList=[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        List<String> fixExpressionStringList = toInfixExpressionList(s);
        System.out.println("fixExpressionStringList=" + fixExpressionStringList);
        //3:将中缀表达式转换成后缀表达式 1+((2+3)×4)-5  1 2 3 + 4 * + 5 -
        List<String> suffixExpreesionList = parseSuffixExpreesionList(fixExpressionStringList);
        System.out.println("suffixExpreesionList=" + suffixExpreesionList);
        //4:计算结果
        Integer result = calculate(suffixExpreesionList);
        System.out.printf("suffixExpression=%d", result);
    }


    /**
     * @param fixExpressionStringList 中缀表达式集合
     * @return
     * @Description: 将中缀表达式转换成后缀表达式
     * 转换之前 1, +, (, (, 2, +, 3, ), *, 4, ), -, 5
     * 转换之后 1 2 3 + 4 * + 5 -
     * @author luoyong
     * @create 21:42 2019/8/27
     * @last modify by [LuoYong 21:42 2019/8/27 ]
     */
    public List<String> parseSuffixExpreesionList(List<String> fixExpressionStringList) {
        //1:定一个一个符号栈
        Stack<String> operStack = new Stack<>();
        //2:定义一个结果集合
        List<String> resultStringList = Lists.newArrayList();
        fixExpressionStringList.forEach(item -> {
            if (item.matches("\\d+")) {
                //是数字
                resultStringList.add(item);
            } else if (item.equals("(")) {
                //左括号
                operStack.push(item);
            } else if (item.equals(")")) {
                //遇到右括号 将非"（"元素弹出加入到resultStringList 并将"("元素弹出
                //operStack.peek() top指针对应的元素(按照上面的案例 第一次 operStack.peek()=3 )
                while (!operStack.peek().equals("(")) {
                    resultStringList.add(operStack.pop());
                }
                //弹出"("
                operStack.pop();
            } else {
                //当item的优先级小于等于栈顶元素的优先级
                // 1：将符号栈的栈顶元素弹出并加入到resultStringList当中
                while (operStack.size() != 0) {
                    Integer topStatckPriority = OperatorUtils.getPriority(operStack.peek());
                    Integer itemPriority = OperatorUtils.getPriority(item);
                    if (itemPriority <= topStatckPriority) {
                        resultStringList.add(operStack.pop());
                    } else {
                        break;
                    }
                }
                operStack.push(item);
            }
        });
        //将运算符栈里面剩余的运算符存放到结当中
        while (operStack.size() != 0) {
            resultStringList.add(operStack.pop());
        }
        return resultStringList;
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

    /**
     * @param s
     * @return
     * @Description: 将中缀表达式转化成List
     * s="1+((2+3)×4)-5"
     * @author luoyong
     * @create 20:46 2019/8/27
     * @last modify by [LuoYong 20:46 2019/8/27 ]
     */
    public static List<String> toInfixExpressionList(String s) {
        //定义返回结果
        List<String> result = Lists.newArrayList();
        //对多位数的拼接
        String str;
        //用来存放遍历到每个字符
        char c;
        int i = 0;
        do {
            c = s.charAt(i);
            /**
             * 48～57为0到9十个阿拉伯数字。
             * 65～90为26个大写英文字母，97～122号为26个小写英文字母
             */
            if (c < 48 || c > 57) {
                //c是非数字
                result.add(String.valueOf(c));
                i++;
                c = s.charAt(i);
            } else {
                str = "";
                //数字'0'[48]->'9'[57]
                //多位数
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str = str + c;
                    i++;
                }
                result.add(str);
            }
        } while (i < s.length());

        return result;
    }

}
