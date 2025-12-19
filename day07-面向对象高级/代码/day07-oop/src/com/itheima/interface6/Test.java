package com.itheima.interface6;

public class Test {
    public static void main(String[] args) {
        Student[] allStudents = new Student[10];
        allStudents[0] = new Student("张三", '男', 100);
        allStudents[1] = new Student("李四", '女', 99);
        allStudents[2] = new Student("王五", '男', 98);
        allStudents[3] = new Student("赵六", '女', 97);
        allStudents[4] = new Student("孙七", '男', 96);
        allStudents[5] = new Student("周八", '女', 95);
        allStudents[6] = new Student("吴九", '男', 94);
        allStudents[7] = new Student("郑十", '女', 93);
        allStudents[8] = new Student("赵敏", '女', 100);
        allStudents[9] = new Student("周芷若", '女', 90);
        ClassDataInter inter = new Impl2(allStudents);
        inter.printAllStudentInfos();
        inter.printAverageScore();
    }
}
