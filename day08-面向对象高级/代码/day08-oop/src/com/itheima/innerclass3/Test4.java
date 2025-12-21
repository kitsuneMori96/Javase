package com.itheima.innerclass3;

import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 指定排序规则：
                // 如果你认为左边对象 大于 右边对象 那么返回正整数。
                // 如果你认为左边对象 小于 右边对象 那么返回负整数。
                // 如果两边相等那么返回0
//                if(o1.getAge() > o2.getAge()){
//                    return 1;
//                }else if(o1.getAge() < o2.getAge()){
//                      return -1;
//                }
//                return 0;
//                return o1.getAge() - o2.getAge(); // 按照年龄升序！
                 return o2.getAge() - o1.getAge(); // 按照年龄降序！
            }
        });

        // 遍历数组中的学生对象并输出
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            System.out.println(s);
        }
    }
}
