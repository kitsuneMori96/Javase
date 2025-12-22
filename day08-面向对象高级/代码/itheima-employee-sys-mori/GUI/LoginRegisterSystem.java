package GUI;

import javax.swing.*;
import java.awt.*;

public class LoginRegisterSystem {
    public static void main(String[] args) {
        // 创建主窗口
        JFrame frame = new JFrame("用户系统");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // 使用卡片布局管理登录和注册面板
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // 1. 登录面板
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField loginUsername = new JTextField();
        JPasswordField loginPassword = new JPasswordField();
        JButton loginButton = new JButton("登录");
        JButton goToRegister = new JButton("去注册");

        loginPanel.add(new JLabel("用户名:"));
        loginPanel.add(loginUsername);
        loginPanel.add(new JLabel("密码:"));
        loginPanel.add(loginPassword);
        loginPanel.add(loginButton);
        loginPanel.add(goToRegister);

        // 2. 注册面板
        JPanel registerPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField regUsername = new JTextField();
        JPasswordField regPassword = new JPasswordField();
        JPasswordField confirmPassword = new JPasswordField();
        JButton registerButton = new JButton("注册");
        JButton goToLogin = new JButton("去登录");

        registerPanel.add(new JLabel("用户名:"));
        registerPanel.add(regUsername);
        registerPanel.add(new JLabel("密码:"));
        registerPanel.add(regPassword);
        registerPanel.add(new JLabel("确认密码:"));
        registerPanel.add(confirmPassword);
        registerPanel.add(registerButton);
        registerPanel.add(goToLogin);

        // 添加面板到主卡片面板
        mainPanel.add(loginPanel, "LOGIN");
        mainPanel.add(registerPanel, "REGISTER");

        // 添加事件监听器
        goToRegister.addActionListener(e -> cardLayout.show(mainPanel, "REGISTER"));
        goToLogin.addActionListener(e -> cardLayout.show(mainPanel, "LOGIN"));

        // 登录按钮事件
        loginButton.addActionListener(e -> {
            String username = loginUsername.getText();
            String password = new String(loginPassword.getPassword());

            // 这里添加实际登录逻辑
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "用户名和密码不能为空");
            } else {
                if(UserDatabase.validateLogin(username, password)){
                    // 登录成功后显示欢迎消息
                    JOptionPane.showMessageDialog(frame, "欢迎" + username + "登录！");
                    // 关闭登录窗口
                    frame.dispose();
                    EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();
                    employeeManagementSystem.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(frame, "密码错误");
                }
            }
        });

        // 注册按钮事件
        registerButton.addActionListener(e -> {
            String username = regUsername.getText();
            String password = new String(regPassword.getPassword());
            String confirm = new String(confirmPassword.getPassword());

            if (!password.equals(confirm)) {
                JOptionPane.showMessageDialog(frame, "两次输入的密码不一致");
            } else if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "用户名和密码不能为空");
            } else if(UserDatabase.registerUser(username, password)){
                JOptionPane.showMessageDialog(frame, "注册成功！");
                cardLayout.show(mainPanel, "LOGIN");
            }
            else{
                JOptionPane.showMessageDialog(frame, "用户已存在！");
            }
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
