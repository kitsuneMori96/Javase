package GUI;

import bean.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EmployeeManagerUI extends JFrame {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField textFieldSearch;
    private ArrayList<Employee> employees = new ArrayList<>();


    //创建十个测试数据
    {
        employees.add(new Employee(1, "张三", "男", 18, "12345678901", "程序员", "2023-01-01", 5000, "IT"));
        employees.add(new Employee(2, "李四", "女", 19, "12345678902", "程序员", "2023-01-02", 5000, "IT"));
        employees.add(new Employee(3, "王五", "男", 20, "12345678903", "程序员", "2023-01-03", 5000, "IT"));
        employees.add(new Employee(4, "赵六", "男", 21, "12345678904", "程序员", "2023-01-04", 5000, "IT"));
        employees.add(new Employee(5, "孙七", "男", 22, "12345678905", "程序员", "2023-01-05", 5000, "IT"));
        employees.add(new Employee(6, "周八", "男", 23, "12345678906", "程序员", "2023-01-06", 5000, "IT"));
        employees.add(new Employee(7, "吴九", "男", 24, "12345678907", "程序员", "2023-01-07", 5000, "IT"));
        employees.add(new Employee(8, "郑十", "男", 25, "12345678908", "程序员", "2023-01-08", 5000, "IT"));
        employees.add(new Employee(9, "冯十一", "男", 26, "12345678909", "程序员", "2023-01-09", 5000, "IT"));

    }


    public EmployeeManagerUI(String title) {
        frame = this;
        initialize(title);
        this.setVisible(true); // Set frame visibility to true
    }

    private void initialize(String title) {
        this.setTitle("欢迎"+title+"使用员工管理系统");
        this.setBounds(100, 100, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        // 输入框和搜索按钮
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        textFieldSearch = new JTextField(20);
        JButton btnSearch = new JButton("搜索");
        JButton btnAdd = new JButton("添加");
        topPanel.add(textFieldSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnAdd);

        // 创建表格模型
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "姓名", "性别", "年龄", "电话" ,"职位", "入职日期", "薪水", "部门"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 设置所有单元格为不可编辑
            }
        };

        //表格中填充测试数据
        for(Employee employee:employees){
            model.addRow(new Object[]{
                    employee.getId(),
                    employee.getName(),
                    employee.getSex(),
                    employee.getAge(),
                    employee.getPhone(),
                    employee.getPosition(),
                    employee.getEntryDate(),
                    employee.getSalary(),
                    employee.getDepartment()
            });
        }

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setRowHeight(30);

        // 右键菜单
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("编辑");
        JMenuItem deleteItem = new JMenuItem("删除");
        popupMenu.add(editItem);
        popupMenu.add(deleteItem);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) { // 明确检查是否为鼠标右键
                    int row = table.rowAtPoint(e.getPoint());
                    if (row >= 0) {
                        table.setRowSelectionInterval(row, row);
                        popupMenu.show(table, e.getX(), e.getY());
                    }
                }
            }
        });

        // 绑定事件到菜单项
        editItem.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (Integer) model.getValueAt(selectedRow, 0); // 假设ID在第一列
                JOptionPane.showMessageDialog(frame, "修改 ID: " + id);
                // 这里可以添加编辑逻辑，比如打开一个新的对话框让用户修改数据
            }
        });

        deleteItem.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (Integer) model.getValueAt(selectedRow, 0); // 假设ID在第一列
                JOptionPane.showMessageDialog(frame, "删除 ID: " + id);
                // 这里可以添加删除逻辑，比如从模型中移除该行
                System.out.println("删除事件触发");
                System.out.println("选中行: " + selectedRow);
                System.out.println("删除ID: " + id);
                System.out.println("删除前员工数: " + employees.size());


                for(int i=0;i<employees.size();i++){
                    if(employees.get(i).getId()==id){
                        employees.remove(i);
                        model.removeRow(i);
                        // ...删除操作...
                        System.out.println("删除后员工数: " + employees.size());
                        table.revalidate();
                        table.repaint();
                        break;
                    }
                }
            }
        });

        // 搜索按钮监听器
        btnSearch.addActionListener(e -> {
            String searchValue = textFieldSearch.getText();
            for(Employee employee:employees){
                if(employee.getName().contains(searchValue)){
                    //创建一个显示界面
                    JFrame searchResultFrame = new JFrame("搜索结果");
                    searchResultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    searchResultFrame.setSize(400, 300);
                    searchResultFrame.setLocationRelativeTo(null);
                    searchResultFrame.setLayout(new BorderLayout());
                    JTextArea textArea = new JTextArea(10, 20);
                    textArea.setText("ID: " + employee.getId() + "\n" +
                            "姓名: " + employee.getName() + "\n" +
                            "性别: " + employee.getSex() + "\n" +
                            "年龄: " + employee.getAge() + "\n" +
                            "电话: " + employee.getPhone() + "\n" +
                            "职位: " + employee.getPosition() + "\n" +
                            "入职日期: " + employee.getEntryDate() + "\n" +
                            "薪水: " + employee.getSalary() + "\n" +
                            "部门: " + employee.getDepartment()
                    );
                    searchResultFrame.add(textArea, BorderLayout.CENTER);
                    searchResultFrame.setVisible(true);
                    //显示结果添加关闭按钮
                    JPanel buttonPanel = new JPanel();
                    JButton btnClose = new JButton("关闭");
                    buttonPanel.add(btnClose);
                    searchResultFrame.add(buttonPanel, BorderLayout.SOUTH);
                    btnClose.addActionListener(ee -> searchResultFrame.dispose());
                }
            }
        });

        // 添加按钮监听器
        btnAdd.addActionListener(e -> {
            // 这里可以添加添加新员工的逻辑
            new AddEmployeeUI(EmployeeManagerUI.this); // Open the AddEmployeeUI window
        });

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

    }

    public void addEmployee(Employee employee) {
        // 这里可以添加保存员工信息的逻辑
        model.addRow(new Object[]{employee.getId(), employee.getName(), employee.getSex(), employee.getAge(), employee.getPhone(), employee.getPosition(), employee.getEntryDate(), employee.getSalary(), employee.getDepartment()});
        employees.add(employee);

    }

    public static void main(String[] args) {
        new EmployeeManagerUI("管理员");
    }

    public int getEmployeeSize() {
        return employees.size();
    }
}