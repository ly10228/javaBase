package com.ly.senior.designpatterns.sgg.creatation.prototype;

import lombok.Data;

/**
 * @author luoyong
 *  * @create 2021-06-14 2:53 下午
 *  * @last modify by [luoyong 2021-06-14 3 下午]
 * @Description: 从本体快速得到一个对象 但是又不对本地产生影响
 **/
@Data
public class User implements Cloneable {
    private String username;
    private Integer age;

    public User() {
        System.out.println("User对象创建");
    }

    /**
     * @return java.lang.Object
     * @Description: 再创建一个人，赋予我的所有属性 与当前对象不冲突 所有要new 每次都是新的
     * @author luoyong
     * @create 2:54 下午 2021/6/14
     * @last modify by [LuoYong 2:54 下午 2021/6/14 ]
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = new User();
        user.setUsername(username);
        user.setAge(age);
        return user;
    }
}
