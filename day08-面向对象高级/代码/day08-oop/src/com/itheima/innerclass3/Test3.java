package com.itheima.innerclass3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 {
    public static void main(String[] args) {
        // 目标：搞清楚几个匿名内部类的使用场景。
        // 需求：创建一个登录窗口，窗口上只有一个登录按钮
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
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("登录成功！");
            }
        });

        win.setVisible(true);
    }
}


