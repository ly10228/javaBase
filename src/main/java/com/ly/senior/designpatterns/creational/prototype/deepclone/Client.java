package com.ly.senior.designpatterns.creational.prototype.deepclone;

import org.junit.Test;

/**
 * @author luoyong
 *  * @create 2019-09-10 14:50
 *  * @last modify by [luoyong 2019-09-10 14:50]
 * @Description: Client
 **/
public class Client {


    /**
     * @return
     * @Description: 新建要拷贝的对象
     * @author luoyong
     * @create 14:52 2019-09-10
     * @last modify by [luoyong 14:52 2019-09-10 ]
     */
    private DeepProtoType getDeepProtoType() {
        DeepProtoType p = new DeepProtoType();
        p.name = "宋江";
        p.deepCloneableTarget = new DeepCloneableTarget("大牛", "小牛");
        return p;
    }

    /**
     * @return void
     * @Description: 通过clone
     * @author luoyong
     * @create 14:50 2019-09-10
     * @last modify by [luoyong 14:50 2019-09-10 ]
     */
    @Test
    public void testByClone() throws Exception {
        DeepProtoType p = getDeepProtoType();
        DeepProtoType p2 = (DeepProtoType) p.clone();
        System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p2.name=" + p.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());
    }

    /**
     * @return void
     * @Description: 通过序列化clone
     * @author luoyong
     * @create 14:56 2019-09-10
     * @last modify by [luoyong 14:56 2019-09-10 ]
     */
    @Test
    public void testBySerializable() {
        DeepProtoType p = getDeepProtoType();
        DeepProtoType p2 = (DeepProtoType) p.deepCloneBySerializable();
        System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p2.name=" + p.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());
    }
}
