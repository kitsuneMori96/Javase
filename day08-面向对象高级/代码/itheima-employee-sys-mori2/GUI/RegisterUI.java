package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUI extends JFrame {
    private JTextField usernameField;  // 用户姓名
    private JTextField loginNameField; // 登录名
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;

    public RegisterUI() {
        // 设置窗口标题
        setTitle("注册窗口");
        // 设置窗口大小
        setSize(350, 250);
        // 设置窗口关闭操作
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 设置窗口布局
        setLayout(new GridLayout(5, 2, 10, 10));

        // 创建姓名标签和输入框
        JLabel usernameLabel = new JLabel("姓名:");
        usernameField = new JTextField();

        // 创建登录名标签和输入框
        JLabel loginNameLabel = new JLabel("登录名:");
        loginNameField = new JTextField();

        // 创建密码标签和输入框
        JLabel passwordLabel = new JLabel("密码:");
        passwordField = new JPasswordField();

        // 创建确认密码标签和输入框
        JLabel confirmPasswordLabel = new JLabel("确认密码:");
        confirmPasswordField = new JPasswordField();

        // 创建注册按钮
        registerButton = new JButton("注册");
        registerButton.addActionListener(new RegisterButtonListener());

        // 将组件按顺序添加到窗口
        add(usernameLabel);
        add(usernameField);
        add(loginNameLabel);
        add(loginNameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(new JLabel()); // 空标签用于对齐
        add(registerButton);

        // 设置窗口居中显示
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class RegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText().trim();
            String loginName = loginNameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            // 注册验证逻辑
            if (username.isEmpty() || loginName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(RegisterUI.this, "所有字段都必须填写！");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(RegisterUI.this, "密码和确认密码不一致！");
            } else {
                // 注册用户：User(username/姓名, password, loginName)
                LoginUI.UserRegister(username, password, loginName);
                JOptionPane.showMessageDialog(RegisterUI.this, "注册成功！");
                // 清空输入框
                usernameField.setText("");
                loginNameField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                // 关闭注册窗口
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        // 创建并显示注册窗口
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterUI().setVisible(true);
            }
        });
    }
}
