package com.ly.senior.designpatterns.structured.flyewight;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @author luoyong
 * @Description: 网站工厂类，根据需要返回一网站
 * @create 2019-09-15 16:41
 * @last modify by [LuoYong 2019-09-15 16:41]
 **/
public class WebSiteFactory {
    private HashMap<String, ConcreteWebSite> pool = Maps.newHashMap();

    /**
     * @param type 网站类型
     * @return
     * @Description: 根据网站类型，返回一个网站，如果么有就创建一个，并放入到池中 并返回
     * @author luoyong
     * @create 16:44 2019/9/15
     * @last modify by [LuoYong 16:44 2019/9/15 ]
     */
    public WebSite getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            //就创建一个网站，并放入到池中
            pool.put(type, new ConcreteWebSite(type));
        }
        return (WebSite) pool.get(type);
    }

    /**
     * 获取网站分类的总数 (池中有多少个网站类型)
     *
     * @return
     */
    public int getWebSiteCount() {
        return pool.size();
    }
}
