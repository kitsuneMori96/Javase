package com.itheima.interface6;

public class Impl2 implements ClassDataInter {
    private Student[] student;

    public Impl2(Student[] student) {
        this.student = student;
    }

    @Override
    public void printAllStudentInfos() {
        //打印所有学生信息
        System.out.println("全班学生信息如下：");
        for (Student s : student) {
            System.out.println(s.getName() + " " + s.getSex() + " " + s.getScore());
        }
        System.out.println("---------------------");

    }

    @Override
    public void printAverageScore() {
        //输出平均分 但是去掉最高分和最低分

        double sum = 0;
        int min=101;
        int max=-1;
        for (Student s : student) {
            if(s.getScore()>max){
                max=s.getScore();
            }
            if(s.getScore()<min){
                min=s.getScore();
            }
            sum += s.getScore();
        }
        sum-=(max+min);
        System.out.println("平均分是：" + sum / (student.length-2));

    }
}
