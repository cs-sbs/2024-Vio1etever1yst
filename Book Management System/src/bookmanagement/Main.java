package bookmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("欢迎来到图书管理系统（BMS）");
            System.out.println("1. 注册账号");
            System.out.println("2. 登录账号");
            System.out.println("3. 浏览图书");
            System.out.println("4. 寻找图书");
            System.out.println("5. 添加图书（仅管理员允许）");
            System.out.println("6. 删除图书（仅管理员允许）");
            System.out.println("7. 管理账户（仅管理员允许）");
            System.out.println("8. 登出账号");
            System.out.println("9. 退出系统");
            System.out.print("请输入你的选择（数字1-9）: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    System.out.print("请输入用户名: ");
                    String username = scanner.nextLine();
                    System.out.print("请输入密码: ");
                    String password = scanner.nextLine();
                    System.out.print("请输入角色（admin 或 guest，留空默认 guest）: ");
                    String role = scanner.nextLine();
                    UserService.register(username, password, role);
                    break;
                case 2:
                    LoginMenu.login();
                    break;
                case 3:
                    BookService.viewBooks();
                    break;
                case 4:
                    SearchMenu.searchBooks();
                    break;
                case 5:
                    AdminMenu.addBook();
                    break;
                case 6:
                    AdminMenu.deleteBook();
                    break;
                case 7:
                    AdminMenu.manageUsers();
                    break;
                case 8:
                    LogoutMenu.logout();
                    break;
                case 9:
                    ExitMenu.exitSystem();
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        } while (choice != 9);

        scanner.close();
    }
}
