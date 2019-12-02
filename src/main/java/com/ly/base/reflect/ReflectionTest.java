package com.ly.base.reflect;

import com.ly.base.reflect.dto.Person;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author luoyong
 * @Description: ReflectionTest
 * @create 2019-12-02 20:33
 * @last modify by [LuoYong 2019-12-02 20:33]
 **/
public class ReflectionTest {

    /**
     * @param
     * @return void
     * @Description: 反射之前，对Person的操作
     * @author luoyong
     * @create 22:10 2019/12/2
     * @last modify by [LuoYong 22:10 2019/12/2 ]
     */
    @Test
    public void test1() {
        //1:创建Person类
        Person p1 = new Person("tom", 1);
        //通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();
        //在Person类外部，不可以通过Person类的对象调用其内部的私有结构。
        //比如：name ,showNation() 以及私有构造器
    }

    /**
     * @param
     * @return void
     * @Description: 反射之后 对Person的操作
     * @author luoyong
     * @create 22:14 2019/12/2
     * @last modify by [LuoYong 22:14 2019/12/2 ]
     */
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //通过反射创建Person类
        //getDeclaredConstructor方法参数类型 要与类定义的时候一直 int不能用包装类Integer代替
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
        Person person = (Person) declaredConstructor.newInstance("ly", 27);
        System.out.println(person.toString());

        //2:使用反射 调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(person, 28);
        System.out.println(person.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);
        System.out.println("*******************************");

        //通过反射可以获取Person类的私有结构，比如私有构造器、方法、属性
        //调用私有构造器
        Constructor declaredConstructor1 = clazz.getDeclaredConstructor(String.class);
        declaredConstructor1.setAccessible(true);
        Object o1 = declaredConstructor1.newInstance("罗勇");
        Person person1 = (Person) o1;
        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(person1, "中国");
        System.out.println(nation);
        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1, "大胖");
        System.out.println(person1);
    }


    /**
     * @param
     * @return void
     * @Description: 获取Class实例的三种方式
     * 1:类加载的过程
     * 程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
     * 接着我们使用java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中。
     * 此过程就是类的加载。加载到内存当中去，我们就称之为运行时类，此运行时类，就作为Class的一个实例
     * 2：Class的实例就对应一个运行时类
     * 3：加载到内存中的运行时类，会缓存一定时间，在此时间内，我们可以通过不同的方式来获取此运行时类
     * @author luoyong
     * @create 22:38 2019/12/2
     * @last modify by [LuoYong 22:38 2019/12/2 ]
     */
    @Test
    public void getClassObject() throws Exception {
        //1:调用运行类的属性 .class
        Class clazz = Person.class;
        //class com.ly.base.reflect.dto.Person
        System.out.println(clazz);

        //2:通过运行时类的对象，调用getClass()
        Person person = new Person();
        Class clazz1 = person.getClass();
        //Person()
        //class com.ly.base.reflect.dto.Person
        System.out.println(clazz1);

        //3:通过Class的静态方法 forName(String classPath)
        Class clazz2 = Class.forName("com.ly.base.reflect.dto.Person");
        //class com.ly.base.reflect.dto.Person
        System.out.println(clazz2);

        //4：使用ClassLoader类加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz3 = classLoader.loadClass("com.ly.base.reflect.dto.Person");
        //class com.ly.base.reflect.dto.Person
        System.out.println(clazz3);

        System.out.println(clazz == clazz3);
    }


    /**
     * @param
     * @return void
     * @Description: 万事万物皆对象？对象.xxx,File,URL,反射,前端、数据库操作
     * @author luoyong
     * @create 23:00 2019/12/2
     * @last modify by [LuoYong 23:00 2019/12/2 ]
     */
    @Test
    public void test4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }
}
