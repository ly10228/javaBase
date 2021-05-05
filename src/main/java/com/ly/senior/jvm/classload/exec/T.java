package com.ly.senior.jvm.classload.exec;

/**
 * @author luoyong
 *  * @create 2021-05-05 1:00 下午
 *  * @last modify by [luoyong 2021-05-05 1:00 下午]
 * @Description: 使用系统类加载器加载。
 **/
public class T {
    //clinit---start
    public static int k = 0;
    public static T t1 = new T("t1");
    public static T t2 = new T("t2");
    public static int i = print("i");
    public static int n = 99;

    static {
        print("静态块");
    }
    //clinit---end

    //init()---start
    public int j = print("j");

    {
        print("构造块");
    }

    public T(String str) {
        System.out.println((++k) + ":" + str + "  i=" + i + "  n=" + n);
        ++n;
        ++i;
    }
    //init()---end


    public static int print(String str) {
        System.out.println((++k) + ":" + str + "  i=" + i + "  n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {
        //String:使用引导类加载器加载
//        String str = "info";
    }
}
