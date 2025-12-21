package com.itheima.lambda;

import com.itheima.innerclass3.Student;

import javax.swing.*;
import java.util.Arrays;

public class LamdbaDemo2 {
    public static void main(String[] args) {
        // 目标：用Lambda表达式简化实际示例。
        test1();
        test2();
    }

    public static void test1(){
        Student[] students = new Student[6];
        students[0] = new Student("殷素素", 35, 171.5, '女');
        students[1] = new Student("杨幂", 28, 168.5, '女');
        students[2] = new Student("张无忌", 25, 181.5, '男');
        students[3] = new Student("小昭", 19, 165.5, '女');
        students[4] = new Student("赵敏", 27, 167.5, '女');
        students[5] = new Student("刘亦菲", 36, 168, '女');

        // 需求：按钮年龄升序排序。可以调用sun公司写好的API直接对数组进行排序。
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge(); // 按照年龄升序！
//            }
//        });

//        Arrays.sort(students, (Student o1, Student o2) -> {
//            return o1.getAge() - o2.getAge(); // 按照年龄升序！
//        });

//        Arrays.sort(students, (o1,  o2) -> {
//            return o1.getAge() - o2.getAge(); // 按照年龄升序！
//        });

        Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());

        // 遍历数组中的学生对象并输出
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            System.out.println(s);
        }
    }

    public static void test2(){
        JFrame win = new JFrame("登录窗口");
        win.setSize(300, 200);
        win.setLocationRelativeTo(null); // 居中显示。
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        win.add(panel);

        JButton btn = new JButton("登录");
        panel.add(btn);
        // java要求必须给这个按钮添加一个点击事件监听器对象，这样就可以监听用户的点击操作，就可以做出反应。
        // 开发中不是我们要主动去写匿名内部类，而是用别人的功能的时候，别人可以让我们写一个匿名内部类吗，我们才会写！!
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("登录成功！");
//            }
//        });

//        btn.addActionListener((ActionEvent e) -> {
//                System.out.println("登录成功！");
//        });

//        btn.addActionListener((e) -> {
//            System.out.println("登录成功！");
//        });

//        btn.addActionListener(e -> {
//            System.out.println("登录成功！");
//        });

        btn.addActionListener(e ->  System.out.println("登录成功！"));

        win.setVisible(true);
    }
}
