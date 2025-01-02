package bookmanagement;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    // 用户数据存储
    private static Map<String, User> users = new HashMap<>();

    static {
        // 初始化默认用户
        users.put("admin", new User("admin", "123456", "admin"));
        users.put("guest", new User("guest", "", "guest"));
    }

    // 注册用户
    public static void register(String username, String password, String role) {
        if (users.containsKey(username)) {
            System.out.println("用户名已存在，无法注册！");
        } else {
            if (role == null || role.isEmpty()) {
                role = "guest"; // 默认角色为 guest
            }
            users.put(username, new User(username, password, role));
            System.out.println("用户注册成功！角色: " + role);
        }
    }

    // 登录用户
    public static User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // 登录失败
    }

    // 显示所有用户
    public static void displayAllUsers() {
        System.out.println("所有用户：");
        users.forEach((key, value) -> {
            System.out.println("用户名: " + key + ", 角色: " + value.getRole() + ", 密码: " + value.getPassword());
        });
    }


    // 删除用户
    public static boolean deleteUser(String username) {
        if (users.containsKey(username)) {
            // 防止删除管理员账户
            if ("admin".equals(username)) {
                System.out.println("不能删除管理员账户！");
                return false;
            }
            users.remove(username);
            return true;
        }
        return false;
    }
}
