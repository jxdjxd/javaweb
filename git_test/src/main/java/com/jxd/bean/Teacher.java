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
        fullName = name;
        this.age = age;
    }
}
