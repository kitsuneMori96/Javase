package com.itheima.javabean;

/** 学生业务操作对象：负责对学生的数据进行业务处理 */
public class StudentOperator {
    private Student s; // 记住要操作的学生对象。
    public StudentOperator(Student s) {
        this.s = s;
    }
    public void printAllScore() {
        System.out.println(s.getName() + "总成绩是：" + (s.getMath() + s.getEnglish()));
    }

    public void printAverageScore() {
        System.out.println(s.getName() + "平均成绩是：" + (s.getMath() + s.getEnglish()) / 2);
    }
}
