package com.ly.senior.designpatterns.structured.flyewight;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: Client
 * 场景
 * 小型的外包项目，给客户A做一个产品展示网站，客户A的朋友感觉效果不错，也希
 * 望做这样的产品展示网站，但是要求都有些不同：
 * 1) 有客户要求以新闻的形式发布
 * 2) 有客户人要求以博客的形式发布
 * 3) 有客户希望以微信公众号的形式发布
 * 享元模式--共享对象
 * 内部状态和外部状态
 * 五子棋：
 * 内部状态：颜色（白色和黑色） 相对稳定 所以颜色是可以共享的
 * 外部状态：坐标
 * @create 2019-09-15 16:46
 * @last modify by [LuoYong 2019-09-15 16:46]
 **/
public class Client {

    @Test
    public void test() {
        //1:创建一个工厂类
        WebSiteFactory factory = new WebSiteFactory();

        // 客户要以新闻的形式发布网站
        WebSite webSite1 = factory.getWebSiteCategory("新闻");
        webSite1.use(new User("tom"));

        // 客户要一个以博客形式发布的网站
        WebSite webSite2 = factory.getWebSiteCategory("博客");

        webSite2.use(new User("jack"));

        // 客户要一个以博客形式发布的网站
        WebSite webSite3 = factory.getWebSiteCategory("博客");

        webSite3.use(new User("smith"));

        // 客户要一个以博客形式发布的网站
        WebSite webSite4 = factory.getWebSiteCategory("博客");

        webSite4.use(new User("king"));

        System.out.println("网站的分类共=" + factory.getWebSiteCount());
    }
}
