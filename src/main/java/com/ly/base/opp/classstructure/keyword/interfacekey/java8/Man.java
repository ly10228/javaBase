package com.ly.base.opp.classstructure.keyword.interfacekey.java8;

/**
 * @author luoyong
 * @Description: Man
 * @create 2019-11-24 15:54
 * @last modify by [LuoYong 2019-11-24 15:54]
 **/
public class Man extends Father implements Filial, Spoony {
    @Override
    public void help() {
        //继承了父类 如果不重写 默认执行父类的方法
        Filial.super.help();
        Spoony.super.help();
    }
}

/**
 * 孝顺的
 */
interface Filial {
    default void help() {
        System.out.println("mom,我来救你了");
    }
}

class Father {
    public void help() {
        System.out.println("儿子，救我媳妇！");
    }
}

/**
 * 痴情的
 */
interface Spoony {
    default void help() {
        System.out.println("媳妇,我来救你了");
    }
}