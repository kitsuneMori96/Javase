package com.itheima.demo;

import java.util.Scanner;

public class AllTest {
    public static void main(String[] args) {
        // 目标：完成健康计算器。
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的身高：");
        double height = sc.nextDouble();
        System.out.println("请输入您的体重：");
        double weight = sc.nextDouble();
        System.out.println("请输入您的性别：");
        String sex = sc.next();
    }

    // 2、根据个人信息，计算BMI指数（把数据交给一个独立的方法来计算并返回这个结果）
    public static double calcBMI(double height, double weight) {
        return weight / (height * height);
    }

    // 3、根据个人信息，计算BMR指数（把数据交给一个独立的方法来计算并返回这个结果）
    public static double calcBMR(double height, double weight, String sex, int age) {
       if(sex.equals("男")){
           return 66 + (13.7 * weight) + (5 * height * 100) - (6.8 * age);
       } else {
           return 655 + (9.6 * weight) + (1.8 * height * 100) - (4.7 * age);
       }
    }
}