package com.ly.senior.designpatterns.sgg.structural.proxy.statics;

/**
 * @author luoyong
 *  * @create 2021-06-14 11:31 上午
 *  * @last modify by [luoyong 2021-06-14 11:31 上午]
 * @Description: 代理一般都是和被代理对象属于同一个接口
 **/
public class LiMingTiktokProxy implements ManTikTok {
    /**
     * 组合被代理对象
     */
    private ManTikTok manTikTok;

    public void setManTikTok(ManTikTok manTikTok) {
        this.manTikTok = manTikTok;
    }

    @Override
    public void tiktok() {
        //增强功能
        System.out.println("渲染直播间....");
        System.out.println("课程只要666，仅此一天....");
        manTikTok.tiktok();
    }
}
