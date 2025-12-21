package com.itheima.gui;

import javax.swing.*;
import java.awt.*;

public class LoginUI {
    public static void main(String[] args) {
            JFrame frame = new JFrame("公司项目登录界面");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null); // 居中显示

            // 设置背景颜色
            frame.getContentPane().setBackground(new Color(245, 245, 245)); // 灰白色背景

            // 创建面板
            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // 内边距
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // 标题标签
            JLabel titleLabel = new JLabel("欢迎登录");
            titleLabel.setFont(new Font("楷体", Font.BOLD, 24));
            titleLabel.setForeground(new Color(64, 64, 64)); // 深灰色文字
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(titleLabel, gbc);

            // 用户名输入框
            gbc.gridy++;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            panel.add(new JLabel("用户名:"), gbc);
            gbc.gridx++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            JTextField usernameField = new JTextField(20);
            panel.add(usernameField, gbc);

            // 密码输入框
            gbc.gridy++;
            gbc.gridx = 0;
            gbc.fill = GridBagConstraints.NONE;
            panel.add(new JLabel("密码:"), gbc);
            gbc.gridx++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            JPasswordField passwordField = new JPasswordField(20);
            panel.add(passwordField, gbc);

            // 登录按钮
            gbc.gridy++;
            gbc.gridx = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            JButton loginButton = new JButton("登录");
            loginButton.setBackground(new Color(0, 128, 255)); // 蓝色按钮
            loginButton.setForeground(Color.WHITE);
            loginButton.setFont(new Font("楷体", Font.BOLD, 14));
            panel.add(loginButton, gbc);

            frame.add(panel);
            frame.setVisible(true);
    }
}