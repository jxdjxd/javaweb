package com.jxd.bean;

/**
 * @author jxd
 * @date 2021/9/19 13:22
 */
public class Teacher {
    private String fullName;
    private int age;

    public Teacher(){

    }

    public Teacher(String name, int age){
        System.out.println();
        fullName = name;
        System.out.println("这是reform更改的");
        this.age = age;
    }
}
