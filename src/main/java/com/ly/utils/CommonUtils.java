package com.ly.utils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luoyong
 *  * @create 2020-05-14 3:07 下午
 *  * @last modify by [luoyong 2020-05-14 3:07 下午]
 * @Description: CommonUtils
 **/
public class CommonUtils {
    public static <E> List<E> getDuplicateElements(List<E> list) {
        return list.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
}
