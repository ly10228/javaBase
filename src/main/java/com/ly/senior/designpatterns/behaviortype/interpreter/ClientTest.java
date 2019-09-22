package com.ly.senior.designpatterns.behaviortype.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author luoyong
 * @Description: ClientTest
 * @create 2019-09-22 17:59
 * @last modify by [LuoYong 2019-09-22 17:59]
 **/
public class ClientTest {

    public static void main(String[] args) throws IOException {
        // a+b
        String expStr = getExpStr();
        // var {a=10, b=20}
        HashMap<String, Integer> var = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println("运算结果：" + expStr + "=" + calculator.run(var));
    }

    /**
     * @param
     * @return java.lang.String
     * @Description: 获取表达式
     * @author luoyong
     * @create 18:01 2019/9/22
     * @last modify by [LuoYong 18:01 2019/9/22 ]
     */
    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    /**
     * @param expStr
     * @return
     * @Description: 获得值映射
     * @author luoyong
     * @create 18:01 2019/9/22
     * @last modify by [LuoYong 18:01 2019/9/22 ]
     */
    public static HashMap<String, Integer> getValue(String expStr) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) {
                    System.out.print("请输入" + String.valueOf(ch) + "的值：");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }

        return map;
    }


}
