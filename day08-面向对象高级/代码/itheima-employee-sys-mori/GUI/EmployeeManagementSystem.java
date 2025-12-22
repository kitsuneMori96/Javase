package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeManagementSystem extends JFrame {
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JLabel employeeCountLabel;
    private List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    public EmployeeManagementSystem() {
        // 初始化一些示例数据
        initializeSampleData();

        // 设置窗口属性
        setTitle("人事信息管理系统");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // 创建顶部搜索面板
        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        searchField = new JTextField(20);
        JButton searchButton = new JButton("搜索");
        searchButton.setBackground(new Color(70, 130, 180));
        searchButton.setForeground(Color.WHITE);

        searchButton.addActionListener(e -> searchEmployee());

        JPanel searchInputPanel = new JPanel();
        searchInputPanel.add(new JLabel("员工姓名:"));
        searchInputPanel.add(searchField);
        searchInputPanel.add(searchButton);

        searchPanel.add(searchInputPanel, BorderLayout.WEST);

        // 创建操作按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        JButton addButton = createStyledButton("添加员工", new Color(46, 139, 87));
        JButton editButton = createStyledButton("修改信息", new Color(255, 140, 0));
        JButton deleteButton = createStyledButton("删除员工", new Color(178, 34, 34));
        JButton refreshButton = createStyledButton("刷新数据", new Color(70, 130, 180));

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        searchPanel.add(buttonPanel, BorderLayout.EAST);
        mainPanel.add(searchPanel, BorderLayout.NORTH);

        // 创建表格
        String[] columnNames = {"ID", "姓名", "部门", "职位", "薪资", "入职日期", "联系方式"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 表格不可编辑
            }
        };

        employeeTable = new JTable(tableModel);
        employeeTable.setRowHeight(30);
        employeeTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));
        employeeTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 设置列宽
        employeeTable.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID
        employeeTable.getColumnModel().getColumn(1).setPreferredWidth(100); // 姓名
        employeeTable.getColumnModel().getColumn(2).setPreferredWidth(120); // 部门
        employeeTable.getColumnModel().getColumn(3).setPreferredWidth(120); // 职位
        employeeTable.getColumnModel().getColumn(4).setPreferredWidth(100); // 薪资
        employeeTable.getColumnModel().getColumn(5).setPreferredWidth(120); // 入职日期
        employeeTable.getColumnModel().getColumn(6).setPreferredWidth(150); // 联系方式

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("员工信息列表"));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 添加底部信息面板
        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createTitledBorder("系统信息"));
        employeeCountLabel = new JLabel("员工总数: " + employees.size() + " 人");
        infoPanel.add(employeeCountLabel);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);

        // 添加事件监听器
        addButton.addActionListener(e -> showAddEmployeeDialog());
        editButton.addActionListener(e -> showEditEmployeeDialog());
        deleteButton.addActionListener(e -> deleteSelectedEmployee());
        refreshButton.addActionListener(e -> refreshTable());

        // 填充表格数据
        refreshTable();

        add(mainPanel);
        setVisible(true);
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("微软雅黑", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 35));
        return button;
    }

    private void initializeSampleData() {
        employees.add(new Employee(nextId++, "张三", "技术部", "高级工程师", 18000, "2020-05-12", "13800138000"));
        employees.add(new Employee(nextId++, "李四", "市场部", "市场经理", 15000, "2019-11-03", "13900139000"));
        employees.add(new Employee(nextId++, "王五", "财务部", "财务主管", 16000, "2021-02-28", "13700137000"));
        employees.add(new Employee(nextId++, "赵六", "人力资源部", "招聘专员", 12000, "2022-07-15", "13600136000"));
        employees.add(new Employee(nextId++, "钱七", "技术部", "前端开发", 14000, "2021-09-01", "13500135000"));
    }

    private void refreshTable() {
        // 清空表格
        tableModel.setRowCount(0);

        // 重新填充数据
        for (Employee emp : employees) {
            Object[] rowData = {
                emp.getId(),
                emp.getName(),
                emp.getDepartment(),
                emp.getPosition(),
                String.format("¥%.2f", emp.getSalary()),
                emp.getHireDate(),
                emp.getPhone()
            };
            tableModel.addRow(rowData);
        }

        // 更新底部信息
        updateEmployeeCount();
    }

    private void updateEmployeeCount() {
        if (employeeCountLabel != null) {
            employeeCountLabel.setText("员工总数: " + employees.size() + " 人");
        }
    }

    private void searchEmployee() {
        String name = searchField.getText().trim();
        if (name.isEmpty()) {
            refreshTable();
            return;
        }

        // 清空表格
        tableModel.setRowCount(0);

        // 搜索匹配的员工
        for (Employee emp : employees) {
            if (emp.getName().contains(name)) {
                Object[] rowData = {
                    emp.getId(),
                    emp.getName(),
                    emp.getDepartment(),
                    emp.getPosition(),
                    String.format("¥%.2f", emp.getSalary()),
                    emp.getHireDate(),
                    emp.getPhone()
                };
                tableModel.addRow(rowData);
            }
        }
    }

    private void showAddEmployeeDialog() {
        JDialog dialog = new JDialog(this, "添加新员工", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTextField nameField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField positionField = new JTextField();
        JTextField salaryField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField phoneField = new JTextField();

        panel.add(new JLabel("姓名:"));
        panel.add(nameField);
        panel.add(new JLabel("部门:"));
        panel.add(deptField);
        panel.add(new JLabel("职位:"));
        panel.add(positionField);
        panel.add(new JLabel("薪资:"));
        panel.add(salaryField);
        panel.add(new JLabel("入职日期:"));
        panel.add(dateField);
        panel.add(new JLabel("联系方式:"));
        panel.add(phoneField);

        JButton saveButton = new JButton("保存");
        saveButton.setBackground(new Color(46, 139, 87));
        saveButton.setForeground(Color.WHITE);

        JButton cancelButton = new JButton("取消");
        cancelButton.setBackground(new Color(178, 34, 34));
        cancelButton.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // 添加事件监听器
        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String department = deptField.getText().trim();
                String position = positionField.getText().trim();
                double salary = Double.parseDouble(salaryField.getText().trim());
                String hireDate = dateField.getText().trim();
                String phone = phoneField.getText().trim();

                if (name.isEmpty() || department.isEmpty() || position.isEmpty() ||
                    hireDate.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "所有字段都必须填写！", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Employee newEmployee = new Employee(
                    nextId++, name, department, position, salary, hireDate, phone
                );

                employees.add(newEmployee);
                refreshTable();
                dialog.dispose();

                JOptionPane.showMessageDialog(this, "员工添加成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "薪资必须是有效的数字！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

    private void showEditEmployeeDialog() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择一个员工！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (int) employeeTable.getValueAt(selectedRow, 0);
        Employee employee = findEmployeeById(id);
        if (employee == null) return;

        JDialog dialog = new JDialog(this, "修改员工信息", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTextField nameField = new JTextField(employee.getName());
        JTextField deptField = new JTextField(employee.getDepartment());
        JTextField positionField = new JTextField(employee.getPosition());
        JTextField salaryField = new JTextField(String.valueOf(employee.getSalary()));
        JTextField dateField = new JTextField(employee.getHireDate());
        JTextField phoneField = new JTextField(employee.getPhone());

        panel.add(new JLabel("姓名:"));
        panel.add(nameField);
        panel.add(new JLabel("部门:"));
        panel.add(deptField);
        panel.add(new JLabel("职位:"));
        panel.add(positionField);
        panel.add(new JLabel("薪资:"));
        panel.add(salaryField);
        panel.add(new JLabel("入职日期:"));
        panel.add(dateField);
        panel.add(new JLabel("联系方式:"));
        panel.add(phoneField);

        JButton saveButton = new JButton("保存");
        saveButton.setBackground(new Color(46, 139, 87));
        saveButton.setForeground(Color.WHITE);

        JButton cancelButton = new JButton("取消");
        cancelButton.setBackground(new Color(178, 34, 34));
        cancelButton.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // 添加事件监听器
        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String department = deptField.getText().trim();
                String position = positionField.getText().trim();
                double salary = Double.parseDouble(salaryField.getText().trim());
                String hireDate = dateField.getText().trim();
                String phone = phoneField.getText().trim();

                if (name.isEmpty() || department.isEmpty() || position.isEmpty() ||
                    hireDate.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "所有字段都必须填写！", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                employee.setName(name);
                employee.setDepartment(department);
                employee.setPosition(position);
                employee.setSalary(salary);
                employee.setHireDate(hireDate);
                employee.setPhone(phone);

                refreshTable();
                dialog.dispose();

                JOptionPane.showMessageDialog(this, "员工信息修改成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "薪资必须是有效的数字！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

    private void deleteSelectedEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择一个员工！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (int) employeeTable.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "确定要删除该员工吗？",
            "确认删除",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            employees.removeIf(emp -> emp.getId() == id);
            refreshTable();
            JOptionPane.showMessageDialog(this, "员工删除成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Employee findEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new EmployeeManagementSystem();
        });
    }

    // 员工实体类
    static class Employee {
        private int id;
        private String name;
        private String department;
        private String position;
        private double salary;
        private String hireDate;
        private String phone;

        public Employee(int id, String name, String department, String position,
                        double salary, String hireDate, String phone) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.position = position;
            this.salary = salary;
            this.hireDate = hireDate;
            this.phone = phone;
        }

        // Getter 和 Setter 方法
        public int getId() { return id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }
        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }
        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }
        public String getHireDate() { return hireDate; }
        public void setHireDate(String hireDate) { this.hireDate = hireDate; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
    }
}
