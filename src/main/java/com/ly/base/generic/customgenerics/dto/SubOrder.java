package com.ly.base.generic.customgenerics.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoyong
 *  * @create 2019-12-14 10:40
 *  * @last modify by [luoyong 2019-12-14 10:40]
 * @Description: SubOrder
 **/
public class SubOrder extends Order<Integer> {

    public static <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }

}
