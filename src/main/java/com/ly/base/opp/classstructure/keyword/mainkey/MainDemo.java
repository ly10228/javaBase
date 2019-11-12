package com.ly.base.opp.classstructure.keyword.mainkey;

/**
 * @author luoyong
 * @Description: MainDemo
 * @create 2019-11-12 23:32
 * @last modify by [LuoYong 2019-11-12 23:32]
 **/
public class MainDemo {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("*****" + args[i]);

            int num = Integer.parseInt(args[i]);
            System.out.println("#####" + num);

        }

    }
}
