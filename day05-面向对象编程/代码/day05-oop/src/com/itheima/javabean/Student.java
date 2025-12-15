package com.itheima.javabean;

public class Student {
    // 1、成员变量需要私有
    private String name;
    private int age;
    private char sex;
    private double math;
    private double english;


    // 3、必须提供无参构造器。有参数构造器可有可无的。
    public Student() {
    }

    public Student(String name, int age, char sex, double math, double english) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.math = math;
        this.english = english;
    }

    // 2、必须提供getter和setter方法。
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }
}
