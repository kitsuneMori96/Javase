package com.itheima.gui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JFrameDemo1 {
    public static void main(String[] args) {
        // 目标：快速入门一下GUI Swing的编程。
        // 1、创建一个窗口，有一个登录按钮。
        JFrame jf = new JFrame("登录窗口");

        JPanel panel = new JPanel(); // 创建一个面板
        jf.add(panel); // 将面板添加到窗口中

        jf.setSize(400, 300); // 设置窗口大小
        jf.setLocationRelativeTo(null); // 设置窗口居中
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭窗口的默认操作: 关闭窗口退出程序

        JButton jb = new JButton("登录"); // 创建一个按钮
        panel.add(jb); // 将按钮添加到面板中
        //弹出登录消息
        jb.addActionListener(e -> JOptionPane.showMessageDialog(jf, "登录成功！"));

        // 2、添加键盘监听器
        jf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    System.out.println("按下了上键");
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    System.out.println("按下了下键");
                }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    System.out.println("按下了左键");
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    System.out.println("按下了右键");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        jf.setVisible(true); // 显示窗口
        //设置jf为焦点
        jf.requestFocus();
    }
}
