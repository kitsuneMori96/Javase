package com.itheima.innerclass3;

import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
        // 目标：完成给数组排序，理解其中匿名内部类的用法。
        // 准备一个学生类型的数组，存放6个学生对象。
        Student[] students = new Student[6];
        students[0] = new Student("殷素素", 35, 171.5, '女');
        students[1] = new Student("杨幂", 28, 168.5, '女');
        students[2] = new Student("张无忌", 25, 181.5, '男');
        students[3] = new Student("小昭", 19, 165.5, '女');
        students[4] = new Student("赵敏", 27, 167.5, '女');
        students[5] = new Student("刘亦菲", 36, 168, '女');

        // 需求：按钮年龄升序排序。可以调用sun公司写好的API直接对数组进行排序。
        // public static void sort(T[] a, Comparator<T> c)
        //           参数一： 需要排序的数组
        //           参数二： 需要给sort方法声明一个Comparator比较器对象（指定排序的规则）
        //    sort方法内部会调用匿名内部类对象的compare方法，对数组中的学生对象进行两两比较，从而实现排序。

        Arrays.sort(students, (s1, s2) -> s1.getAge() - s2.getAge());

        // 遍历数组中的学生对象并输出
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
