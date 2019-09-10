package com.ly.senior.designpatterns.creational.prototype.deepclone;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luoyong
 *  * @create 2019-09-10 14:31
 *  * @last modify by [luoyong 2019-09-10 14:31]
 * @Description: DeepCloneableTarget
 **/
@Data
public class DeepCloneableTarget implements Serializable, Cloneable {

    private static final long serialVersionUID = 1974454632644734999L;

    private String cloneName;

    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }


    /**
     * @return java.lang.Object
     * @Description: 因为该类的属性，都是String , 因此我们这里使用默认的clone完成即可
     * @author luoyong
     * @create 14:33 2019-09-10
     * @last modify by [luoyong 14:33 2019-09-10 ]
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
