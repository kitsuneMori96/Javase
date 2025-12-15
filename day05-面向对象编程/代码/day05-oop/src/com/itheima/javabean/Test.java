package com.itheima.javabean;

public class Test {
    public static void main(String[] args) {
        // 目标：认识实体类，搞清楚实体类的作用和应用场景。
        // 实体类的基本作用：创建对象、封装数据。
        // 1、通过无参数构造器初始化对象
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(18);
        s1.setSex('男');
        s1.setMath(50);
        s1.setEnglish(100);

        // 2、通过有参数构造器初始化对象
        Student s2 = new Student("翠花", 20, '女', 60, 90);

        // 3、创建学生操作对象，处理学生的数据
        StudentOperator so = new StudentOperator(s1);
        so.printAllScore();  // ALT + ENTER
        so.printAverageScore();
    }
}
