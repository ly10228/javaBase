package com.ly.base.opp.classstructure.keyword.interfacekey.exer2;

/**
 * @author luoyong
 * @Description: CompareObject
 * @create 2019-11-20 22:41
 * @last modify by [LuoYong 2019-11-20 22:41]
 **/
public interface CompareObject {

    /**
     * @param o
     * @return int
     * @Description: 大小比较
     * 当前对象和传入对象的一个比较
     * 0：相等 正数-》当前对象大 负数-》当前对象小
     * @author luoyong
     * @create 22:42 2019/11/20
     * @last modify by [LuoYong 22:42 2019/11/20 ]
     */
    int compareTo(Object o);
}
