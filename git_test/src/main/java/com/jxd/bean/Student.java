package com.jxd.bean;

/**
 * 学生实体类
 * @author jxd
 * @date 2021/9/19 13:17
 */
public class Student {
    private String name;
    private Integer age;

    public Student(){

    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}
