package com.ly.senior.designpatterns.behaviortype.responsibilitychain;

/**
 * @author luoyong
 * @Description: SchoolMasterApprover
 * @create 2019-09-22 18:35
 * @last modify by [LuoYong 2019-09-22 18:35]
 **/
public class SchoolMasterApprover extends Approver {

    public SchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() > 30000) {
            System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
