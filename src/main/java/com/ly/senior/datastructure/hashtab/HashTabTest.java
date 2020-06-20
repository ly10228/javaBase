package com.ly.senior.datastructure.hashtab;

import java.util.Scanner;

/**
 * @author luoyong
 * @Description: HashTabTest
 * @create 2020-06-20 16:00
 * @last modify by [LuoYong 2020-06-20 16:00]
 **/
public class HashTabTest {


    public static void main(String[] args) {
        //1:创建hash表
        HashTab hashTab = new HashTab(7);

        //2:写一个简单的菜单来进行操作
        String key = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit:  退出系统");

            key = sc.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = sc.nextInt();
                    System.out.println("输入名称");
                    String name = sc.next();
                    //创建雇员
                    Emp emp = new Emp();
                    emp.setId(id);
                    emp.setName(name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入要查找的id");
                    id = sc.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
