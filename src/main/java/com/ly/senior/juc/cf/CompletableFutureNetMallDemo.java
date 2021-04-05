package com.ly.senior.juc.cf;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author luoyong
 *  * @create 2021-04-04 11:39 上午
 *  * @last modify by [luoyong 2021-04-04 11:39 上午]
 * @Description: 案例说明：电商比价需求
 * 1 同一款产品，同时搜索出同款产品在各大电商的售价;
 * 2 同一款产品，同时搜索出本产品在某一个电商平台下，各个入驻门店的售价是多少
 * 出来结果希望是同款产品的在不同地方的价格清单列表，返回一个List<String>
 * 《mysql》 in jd price is 88.05
 * 《mysql》 in pdd price is 86.11
 * 《mysql》 in taobao price is 90.43
 * 3 要求深刻理解
 * 3.1 函数式编程
 * 3.2 链式编程
 * 3.3 Stream流式计算
 **/
public class CompletableFutureNetMallDemo {

    /**
     * 初始化各大电商店铺
     */
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("pdd"),
            new NetMall("tb"),
            new NetMall("ddw"),
            new NetMall("tm")
    );

    /**
     * @param malls
     * @param productName
     * @return
     * @Description: 同步的方法获取价格 step by step
     * @author luoyong
     * @create 3:21 下午 2021/4/4
     * @last modify by [LuoYong 3:21 下午 2021/4/4 ]
     */
    public static List<String> getPriceByStep(List<NetMall> malls, String productName) {
        return malls.stream().map(netMall -> {
            return String.format(productName + " in %s price is %.2f", netMall.getMallName(),
                    netMall.calcPrice(productName));
        }).collect(Collectors.toList());
    }


    /**
     * @param mallList
     * @param productName
     * @return
     * @Description: 异步的方式获取价格
     * @author luoyong
     * @create 11:19 上午 2021/4/5
     * @last modify by [LuoYong 11:19 上午 2021/4/5 ]
     */
    public static List<String> getPriceByASync(List<NetMall> mallList, String productName) {
        return mallList.stream()
                .map(netMall -> CompletableFuture.supplyAsync(() -> String.format(productName + " in %s price is %" +
                                ".2f", netMall.getMallName(),
                        netMall.calcPrice(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> list1 = getPriceByStep(list, "mysql");
        for (String element : list1) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime - startTime) + " 毫秒");

        System.out.println();

        long startTime2 = System.currentTimeMillis();
        List<String> list2 = getPriceByASync(list, "mysql");
        for (String element : list2) {
            System.out.println(element);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime2 - startTime2) + " 毫秒");

    }
}


@Data
class NetMall {
    private String mallName;

    public NetMall(String mallName) {
        this.mallName = mallName;
    }

    /**
     * @param productName
     * @return double
     * @Description: 根据产品名称得出产品价格
     * @author luoyong
     * @create 3:15 下午 2021/4/4
     * @last modify by [LuoYong 3:15 下午 2021/4/4 ]
     */
    public double calcPrice(String productName) {
        //假设检索需要1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}
