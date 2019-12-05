package com.ly.base.opp.classstructure.keyword.interfacekey.exer2.abs;

/**
 * @author luoyong
 * @Description: AbsCompareObject
 * @create 2019-11-20 23:02
 * @last modify by [LuoYong 2019-11-20 23:02]
 **/
public abstract class AbsCompareObject {
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
    public abstract int compareTo(Object o);
}
