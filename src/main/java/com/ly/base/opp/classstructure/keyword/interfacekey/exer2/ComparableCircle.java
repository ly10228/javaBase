package com.ly.base.opp.classstructure.keyword.interfacekey.exer2;

/**
 * @author luoyong
 * @Description: 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
 * 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 * @create 2019-11-20 22:44
 * @last modify by [LuoYong 2019-11-20 22:44]
 **/
public class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle(Double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            //如果当前对象和比较的对象指向的同一个内存地址 两个对象是同一个对象
            return 0;
        }

        if (o instanceof ComparableCircle) {
            ComparableCircle comparableCircle = (ComparableCircle) o;
            //类型一致
            //正确方式一
//            if (this.getRadius() > comparableCircle.getRadius()) {
//                return 1;
//            } else if (this.getRadius() == comparableCircle.getRadius()) {
//                return 0;
//            } else {
//                return -1;
//            }
            //正确方式二
            return this.getRadius().compareTo(comparableCircle.getRadius());
        } else {
            //类型不一致
            throw new RuntimeException("传入的数据类型不匹配");
        }
    }
}
