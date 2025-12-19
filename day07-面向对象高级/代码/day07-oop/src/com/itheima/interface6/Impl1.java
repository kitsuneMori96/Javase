package com.itheima.interface6;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class Impl1 implements ClassDataInter{
    private Student[] student;

    @Override
    public void printAllStudentInfos() {
        //打印所有学生信息
        System.out.println("全班学生信息如下：");
        for (Student s : student) {
            System.out.println(s.getName() + " " + s.getSex() + " " + s.getScore());
        }
    }

    @Override
    public void printAverageScore() {
        //打印平均分数
        double sum = 0;
        for (Student s : student) {
            sum += s.getScore();
        }
        System.out.println("全班平均成绩为：" + sum / student.length);
    }


}
