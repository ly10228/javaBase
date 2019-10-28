package com.ly.senior.designpatterns.behaviortype.iterator;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author luoyong
 * @Description: Client
 * @create 2019-09-21 23:08
 * @last modify by [LuoYong 2019-09-21 23:08]
 **/
public class Client {

    /**
     * @param
     * @return void
     * @Description: 测试
     * @author luoyong
     * @create 23:08 2019/9/21
     * @last modify by [LuoYong 23:08 2019/9/21 ]
     */
    @Test
    public void test() {
        //1:创建学院
        List<College> collegeList = Lists.newArrayList();
        collegeList.add(new ComputerCollege());
        collegeList.add(new InfoCollege());
        OutPutImpl outPut = new OutPutImpl(collegeList);
        outPut.printCollege();
    }
}
