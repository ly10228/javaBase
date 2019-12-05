package com.ly.base.exception.exceptionhand.throwex;

/**
 * @author luoyong
 * @Description: MyException
 * 如何自定义异常类？
 * 1. 继承于现有的异常结构：RuntimeException 、Exception
 * 2. 提供全局常量：serialVersionUID
 * 3. 提供重载的构造器
 * @create 2019-11-24 23:21
 * @last modify by [LuoYong 2019-11-24 23:21]
 **/
public class MyException extends RuntimeException {

    private static final long serialVersionUID = -8297779310060627715L;

    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }
}
