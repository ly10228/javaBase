package com.ly.senior.designpatterns.behaviortype.responsibilitychain;

/**
 * @author luoyong
 * @Description: Approver
 * @create 2019-09-22 18:33
 * @last modify by [LuoYong 2019-09-22 18:33]
 **/
public abstract class Approver {

    /**
     * 下一个处理者
     */
    Approver approver;
    /**
     * 名字
     */
    String name;

    public Approver(String name) {
        this.name = name;
    }


    /**
     * @param approver
     * @return void
     * @Description: 下一个处理者
     * @author luoyong
     * @create 18:34 2019/9/22
     * @last modify by [LuoYong 18:34 2019/9/22 ]
     */
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    /**
     * @param purchaseRequest
     * @return void
     * @Description: 处理审批请求的方法，得到一个请求, 处理是子类完成，因此该方法做成抽象
     * @author luoyong
     * @create 18:34 2019/9/22
     * @last modify by [LuoYong 18:34 2019/9/22 ]
     */
    public abstract void processRequest(PurchaseRequest purchaseRequest);

}
