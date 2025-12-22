package GUI;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    // 存储用户数据的文件
    private static final String DB_FILE = "users.txt";
    // 内存中的用户数据缓存
    private static Map<String, String> users = new HashMap<>();

    // 静态初始化块：程序启动时加载用户数据
    static {
        loadUsers();
    }

    // 从文件加载用户数据到内存
    private static void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
            System.out.println("用户数据加载完成，共 " + users.size() + " 个用户");
        } catch (FileNotFoundException e) {
            System.out.println("用户数据库文件不存在，将创建新文件");
        } catch (IOException e) {
            System.err.println("加载用户数据时出错: " + e.getMessage());
        }
    }

    // 保存用户数据到文件
    private static void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_FILE))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
            System.out.println("用户数据保存完成");
        } catch (IOException e) {
            System.err.println("保存用户数据时出错: " + e.getMessage());
        }
    }

    // 注册新用户
    public static boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("用户名已存在: " + username);
            return false;
        }

        // TODO: 在实际应用中应对密码进行哈希加密
        users.put(username, password);
        saveUsers();
        System.out.println("用户注册成功: " + username);
        return true;
    }

    // 验证用户登录
    public static boolean validateLogin(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("用户名不存在: " + username);
            return false;
        }

        String storedPassword = users.get(username);
        // TODO: 在实际应用中应比较哈希值
        return storedPassword.equals(password);
    }

    // 删除用户
    public static boolean deleteUser(String username) {
        if (users.remove(username) != null) {
            saveUsers();
            System.out.println("用户删除成功: " + username);
            return true;
        }
        System.out.println("用户不存在: " + username);
        return false;
    }

    // 列出所有用户（仅用于调试）
    public static void listUsers() {
        System.out.println("当前用户列表:");
        for (String username : users.keySet()) {
            System.out.println(" - " + username);
        }
    }

    // 测试数据库功能
    public static void main(String[] args) {
        // 测试注册
        registerUser("alice", "password123");
        registerUser("bob", "securePass");

        // 测试登录验证
        System.out.println("alice 登录: " + validateLogin("alice", "password123")); // true
        System.out.println("bob 登录: " + validateLogin("bob", "wrongPass"));      // false

        // 测试删除
        deleteUser("bob");
        System.out.println("bob 登录: " + validateLogin("bob", "securePass"));     // false

        // 列出所有用户
        listUsers();
    }
}
