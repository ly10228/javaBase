package com.ly.senior.designpatterns.behaviortype.state;

import java.util.Random;

/**
 * @author luoyong
 * @Description: 可以抽奖的状态
 * @create 2019-09-22 18:17
 * @last modify by [LuoYong 2019-09-22 18:17]
 **/
public class CanRaffleState extends State {

    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    /**
     * @param
     * @return void
     * @Description: /已经扣除了积分，不能再扣
     * @author luoyong
     * @create 18:17 2019/9/22
     * @last modify by [LuoYong 18:17 2019/9/22 ]
     */
    @Override
    public void deductMoney() {
        System.out.println("已经扣取过了积分");
    }

    /**
     * @param
     * @return boolean
     * @Description: 可以抽奖, 抽完奖后，根据实际情况，改成新的状态
     * @author luoyong
     * @create 18:17 2019/9/22
     * @last modify by [LuoYong 18:17 2019/9/22 ]
     */
    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等！");
        Random r = new Random();
        int num = r.nextInt(10);
        // 10%中奖机会
        if (num == 0) {
            // 改变活动状态为发放奖品 context
            activity.setState(activity.getDispenseState());
            return true;
        } else {
            System.out.println("很遗憾没有抽中奖品！");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRafflleState());
            return false;
        }
    }

    /**
     * @param
     * @return void
     * @Description: 不能发放奖品
     * @author luoyong
     * @create 18:18 2019/9/22
     * @last modify by [LuoYong 18:18 2019/9/22 ]
     */
    @Override
    public void dispensePrize() {
        System.out.println("没中奖，不能发放奖品");
    }
}
