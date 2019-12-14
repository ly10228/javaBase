package com.ly.base.generic.customgenerics.dto;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luoyong
 *  * @create 2019-12-14 10:16
 *  * @last modify by [luoyong 2019-12-14 10:16]
 * @Description: 自定义泛型类
 **/
@Data
@NoArgsConstructor
public class Order<T> {

    private String orderName;

    private int orderId;

    private T orderT;

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }


    /**
     * 静态方法当中不能使用泛型
     * 静态方法是随着类的加载而加载
     * 泛型在运行期间
     *
     * @param
     */
//    public static void show(T orderT) {
//        System.out.append(orderT);
//    }

//    public  void  show(){
//        try {
//
//        }catch (T t){
//
//        }
//    }

    /**
     * @param arr
     * @return
     * @Description: 泛型方法
     * 1：在方法当中出了泛型结构，方法的泛型参数与类的泛型参数没有关系
     * 2：泛型方法所属的类是不是泛型类都没有关系。
     * 3：泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
     * @author luoyong
     * @create 10:25 2019-12-14
     * @last modify by [LuoYong 10:25 2019-12-14 ]
     */
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        if (null == arr || arr.length <= 0) {
            return Lists.newArrayList();
        }
        ArrayList<E> list = Lists.newArrayList();

        Arrays.stream(arr).forEach(item -> {
            if (null != item) {
                list.add(item);
            }
        });

        return list;
    }

}
