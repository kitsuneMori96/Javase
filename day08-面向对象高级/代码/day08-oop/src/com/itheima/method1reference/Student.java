package com.itheima.method1reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    // 姓名 年龄 身高 性别
    private String name;
    private int age;
    private double height;
    private char sex;

    // 静态方法
    public static int compareByAge(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }

    // 实例方法
    public int compareByHeight(Student o1, Student o2) {
        // 按照身高比较
        return Double.compare(o1.getHeight(), o2.getHeight());
    }
}
