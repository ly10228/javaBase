package com.ly.senior.designpatterns.creational.prototype.deepclone;

import lombok.Data;

import java.io.*;

/**
 * @author luoyong
 *  * @create 2019-09-10 14:34
 *  * @last modify by [luoyong 2019-09-10 14:34]
 * @Description: DeepProtoType
 **/
@Data
public class DeepProtoType implements Serializable, Cloneable {
    /**
     * 基本类型
     */
    public String name;
    /**
     * 引用类型
     */
    public DeepCloneableTarget deepCloneableTarget;

    public DeepProtoType() {
        super();
    }

    /**
     * @return
     * @Description: 使用clone方法
     * @author luoyong
     * @create 14:51 2019-09-10
     * @last modify by [luoyong 14:51 2019-09-10 ]
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //整理完成基本类型String的拷贝
        deep = super.clone();
        //对引用类型的属性 进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    /**
     * @return
     * @Description: 通过序列化实现对象的深拷贝
     * @author luoyong
     * @create 14:39 2019-09-10
     * @last modify by [luoyong 14:39 2019-09-10 ]
     */
    public Object deepCloneBySerializable() {
        //创建流对象
        //写数据
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        //读数据
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化 将内存当中的对象转换为字节序列，方便持久化到磁盘或者网络传输
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            //当前这个对象以对象流的方式输出
            oos.writeObject(this);
            //反序列化 将字节序列转换为内存中的对象
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType) ois.readObject();
            return copyObj;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
