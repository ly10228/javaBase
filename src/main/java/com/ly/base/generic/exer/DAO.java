package com.ly.base.generic.exer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author luoyong
 * @Description: DAO
 * @create 2019-12-23 17:51
 * @last modify by [LuoYong 2019-12-23 17:51]
 **/
public class DAO<T> {

    private Map<String, T> map = Maps.newHashMap();

    //保存 T 类型的对象到 Map 成员变量中
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    //从 map 中获取 id 对应的对象
    public T get(String id) {
        return map.get(id);
    }

    //替换 map 中key为id的内容,改为 entity 对象
    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    //返回 map 中存放的所有 T 对象
    public List<T> list() {
        //错误的：
//        Collection<T> values = map.values();
//        return (List<T>) values;
        //正确的：
        ArrayList<T> list = Lists.newArrayList();
        Collection<T> values = map.values();
        for (T t : values) {
            list.add(t);
        }
        return list;

    }

    //删除指定 id 对象
    public void delete(String id) {
        map.remove(id);
    }

}
