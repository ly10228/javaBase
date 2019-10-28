package com.ly.senior.designpatterns.behaviortype.responsibilitychain;

/**
 * @author luoyong
 * @Description: CollegeApprover
 * @create 2019-09-22 18:37
 * @last modify by [LuoYong 2019-09-22 18:37]
 **/
public class CollegeApprover extends Approver {
    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() < 5000 && purchaseRequest.getPrice() <= 10000) {
            System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
