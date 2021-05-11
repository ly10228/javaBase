package com.ly.base.jvm.gc.concept.reference;

import com.ly.base.jvm.gc.concept.reference.dto.User;

import java.lang.ref.SoftReference;

/**
 * @author luoyong
 *  * @create 2021-02-25 2:02 下午
 *  * @last modify by [luoyong 2021-02-25 2:02 下午]
 * @Description: 软引用
 **/
public class SoftReferenceTest {
    public static void main(String[] args) {
        //创建对象 并建立软引用
        User user = new User(1, "ly");
        SoftReference<User> userSoftReference = new SoftReference<User>(user);
        //取消强引用
        user = null;

        //从软引用中重新获取强引用对象
        System.out.println(userSoftReference.get());

        System.gc();

        System.out.println("After GC:");

        //垃圾回收之后获取软引用中的对象
        //堆空间足够的时候 不会回收软引用的可达对象
        System.out.println(userSoftReference.get());
        try {
            //让系统认为内存资源紧张、不够 设置VM参数
            byte[] b = new byte[1024 * 1024 * 10];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            //再次从软引用中获取对象
            System.out.println(userSoftReference.get());
        }
    }

}
