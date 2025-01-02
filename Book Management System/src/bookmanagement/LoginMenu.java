package bookmanagement;

import java.util.Scanner;

public class LoginMenu {

    // 当前登录的用户
    private static User currentUser = null;

    // 登录方法
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名 (admin 或 guest): ");
        String username = scanner.nextLine();
        System.out.print("请输入密码: ");
        String password = scanner.nextLine();

        // 调用 UserService 进行登录验证
        currentUser = UserService.login(username, password);

        if (currentUser != null) {
            System.out.println("登录成功！ 欢迎 " + currentUser.getUsername() + "，角色：" + currentUser.getRole());
            System.out.println("当前登录账号: " + currentUser.getUsername());
        } else {
            System.out.println("用户名或密码错误！");
        }
    }


    // 获取当前登录的用户
    public static User getCurrentUser() {
        return currentUser;
    }

    // 设置当前登录的用户（用于登出或其他情况）
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
}
