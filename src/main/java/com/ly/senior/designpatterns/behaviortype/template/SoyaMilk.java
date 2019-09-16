package com.ly.senior.designpatterns.behaviortype.template;

/**
 * @author luoyong
 * @Description: SoyaMilk
 * @create 2019-09-16 22:29
 * @last modify by [LuoYong 2019-09-16 22:29]
 **/
public abstract class SoyaMilk {

    /**
     * @param
     * @return void
     * @Description: 模板方法 make 模板方法可以做成final ，不让子类去覆盖
     * @author luoyong
     * @create 22:30 2019/9/16
     * @last modify by [LuoYong 22:30 2019/9/16 ]
     */
    final void make() {
        select();
        addCondiments();
        soak();
        beat();
    }


    /**
     * 选材料
     */
    void select() {
        System.out.println("第一步：选择好的新鲜黄豆  ");
    }

    /**
     * 添加不同的配料， 抽象方法, 子类具体实现
     */
    abstract void addCondiments();

    /**
     * 浸泡
     */
    void soak() {
        System.out.println("第三步， 黄豆和配料开始浸泡， 需要3小时 ");
    }

    /**
     * 黄豆和配料放到豆浆机去打碎
     */
    void beat() {
        System.out.println("第四步：黄豆和配料放到豆浆机去打碎  ");
    }
}
