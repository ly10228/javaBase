package com.ly.base.opp;

import com.google.common.collect.Maps;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author luoyong
 * @Description: 面向对象
 * 一、Java面向对象学习的三条主线：（第4-6章）
 * <p>
 * 1.Java类及类的成员：属性、方法、构造器；代码块、内部类
 * <p>
 * 2.面向对象的三大特征：封装性、继承性、多态性、(抽象性)
 * <p>
 * 3.其它关键字：this、super、static、final、abstract、interface、package、import等
 * “大处着眼，小处着手”
 * <p>
 * 二、“人把大象装进冰箱”
 * <p>
 * 1.面向过程：强调的是功能行为，以函数为最小单位，考虑怎么做。
 * ① 把冰箱门打开
 * ② 抬起大象，塞进冰箱
 * ② 把冰箱门关闭
 * <p>
 * 2.面向对象：强调具备了功能的对象，以类/对象为最小单位，考虑谁来做。
 * 人{
 * 打开(冰箱){
 * 冰箱.开开();
 * }
 * <p>
 * 抬起(大象){
 * 大象.进入(冰箱);
 * }
 * <p>
 * 关闭(冰箱){
 * 冰箱.闭合();
 * }
 * <p>
 * }
 * 冰箱{
 * 开开(){}
 * 闭合(){}
 * }
 * <p>
 * 大象{
 * 进入(冰箱){
 * }
 * }
 * <p>
 * 三、面向对象的两个要素：
 * 类：对一类事物的描述，是抽象的、概念上的定义
 * 对象：是实际存在的该类事物的每个个体，因而也称为实例(instance)
 * >面向对象程序设计的重点是类的设计
 * >设计类，就是设计类的成员。
 * @create 2019-09-23 22:14
 * @last modify by [LuoYong 2019-09-23 22:14]
 **/
public class OOPTest {
    public static void main(String[] args) {
//        Foo<String> foo = new Foo<String>(){};
        Map<String, String> maps = Maps.newHashMap();
        Foo<Map> foo = new Foo<Map>() {
        };
        // 在类的外部这样获取
        Type type = ((ParameterizedType) foo.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(type.getTypeName());
        // 在类的内部这样获取
        System.out.println(foo.getTClass());
        System.out.println(foo.getTClass().getTypeName());

    }

}

abstract class Foo<T> {
    public Class<T> getTClass() {
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }
}
