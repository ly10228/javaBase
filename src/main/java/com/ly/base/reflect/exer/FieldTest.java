package com.ly.base.reflect.exer;

import com.google.common.collect.Lists;
import com.ly.base.reflect.exer.dto.Person;
import lombok.Data;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author luoyong
 * @Description: FieldTest--获取当前运行时类的属性结构
 * @create 2019-12-05 23:26
 * @last modify by [LuoYong 2019-12-05 23:26]
 **/
public class FieldTest {

    /**
     * @param
     * @return void
     * @Description: 获取属性集合
     * getFields()
     * getDeclaredFields()
     * @author luoyong
     * @create 23:33 2019/12/5
     * @last modify by [LuoYong 23:33 2019/12/5 ]
     */
    @Test
    public void getFields() {
        Class<Person> personClass = Person.class;
        //获取属性结构
        //getFields() 获取当前运行时类父类中声明为public访问权限的属性
        Field[] fields = personClass.getFields();
        System.out.println(Arrays.toString(fields));

        //getDeclaredFields()获取当前运行时类中所有的属性--》不包含父类当中的声明的属性
        Field[] declaredFields = personClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
    }


    /**
     * @param
     * @return void
     * @Description: 获取属性的权限修饰符+数据类型+变量名称
     * @author luoyong
     * @create 23:42 2019/12/5
     * @last modify by [LuoYong 23:42 2019/12/5 ]
     */
    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //1:权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //2:数据类型
            Class type = field.getType();
            System.out.println(type.getName() + "\t");

            //变量名
            String fieldName = field.getName();
            System.out.println(fieldName);

            //属性上面的注解
            Annotation[] annotations = field.getAnnotations();
            System.out.println("注解是:" + Arrays.toString(annotations));
            System.out.println();
        }
    }


    @Test
    public void testRand() {
        List<AgentStatus> agentStatuses = Lists.newArrayList();
        agentStatuses.add(new AgentStatus("1", "ly", "0"));
        agentStatuses.add(new AgentStatus("2", "lll", "0"));
        agentStatuses.add(new AgentStatus("3", "zy", "0"));


        for (int i = 0; i < 5; i++) {
            //取随机数
            long seed = System.nanoTime();
            Random seedRandom = new Random(seed);
            int index = seedRandom.nextInt(agentStatuses.size());
            System.out.print(index + "-->");
        }
        System.out.println("===================================");

        for (int i = 0; i < 5; i++) {
            Random seedRandom = new Random();
            int index = seedRandom.nextInt(agentStatuses.size());
            System.out.print(index + "-->");
        }


    }


    @Data
    static class AgentStatus {

        private String cno;

        private String name;

        private String state;

        public AgentStatus(String cno, String name, String state) {
            this.cno = cno;
            this.name = name;
            this.state = state;
        }
    }
}
