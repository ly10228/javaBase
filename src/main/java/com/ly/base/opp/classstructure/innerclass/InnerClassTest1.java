package com.ly.base.opp.classstructure.innerclass;

/**
 * @author luoyong
 * @Description: 局部内部类
 * @create 2019-11-24 16:54
 * @last modify by [LuoYong 2019-11-24 16:54]
 **/
public class InnerClassTest1 {

    //开发中很少见
    public void method() {
        //局部内部类
        class AA {

        }
    }


    /**
     * @param
     * @return java.lang.Comparable
     * @Description: 返回一个实现了Comparable接口的类的对象
     * @author luoyong
     * @create 16:54 2019/11/24
     * @last modify by [LuoYong 16:54 2019/11/24 ]
     */
    public Comparable getComparable() {

        //创建一个实现了Comparable接口的类:局部内部类
        //方式一：
//		class MyComparable implements Comparable{
//
//			@Override
//			public int compareTo(Object o) {
//				return 0;
//			}
//
//		}
//
//		return new MyComparable();

        /**
         * 方式二
         */
        return new Comparable() {

            @Override
            public int compareTo(Object o) {
                return 0;
            }

        };

    }

}
