package bookmanagement;

import java.util.Scanner;

public class AdminMenu {

    // 添加图书（只有管理员能添加）
    public static void addBook() {
        if (isAdminLoggedIn()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入书名: ");
            String title = scanner.nextLine();
            System.out.print("请输入作者: ");
            String author = scanner.nextLine();
            System.out.print("请输入ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("请输入图书类别: ");
            String category = scanner.nextLine();

            // 检查是否已经存在相同ISBN的图书
            for (Book book : BookService.getBooks()) {
                if (book.getIsbn().equals(isbn)) {
                    System.out.println("该ISBN的图书已存在，无法重复添加！");
                    return;
                }
            }

            // 创建新图书并添加到图书列表中
            BookService.getBooks().add(new Book(title, author, isbn, category));
            System.out.println("图书添加成功！");
        } else {
            System.out.println("只有管理员才能添加图书！");
        }
    }

    // 删除图书（只有管理员能删除）
    public static void deleteBook() {
        if (isAdminLoggedIn()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入要删除的图书ISBN: ");
            String isbn = scanner.nextLine();

            Book bookToDelete = null;
            for (Book book : BookService.getBooks()) {
                if (book.getIsbn().equals(isbn)) {
                    bookToDelete = book;
                    break;
                }
            }

            if (bookToDelete != null) {
                BookService.getBooks().remove(bookToDelete);
                System.out.println("图书删除成功！");
            } else {
                System.out.println("未找到该图书！");
            }
        } else {
            System.out.println("只有管理员才能删除图书！");
        }
    }

    // 管理用户账户（只有管理员能管理）
    public static void manageUsers() {
        if (!isAdminLoggedIn()) {
            System.out.println("只有管理员可以管理账户！");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n用户管理菜单：");
            System.out.println("1. 查看所有用户");
            System.out.println("2. 删除用户");
            System.out.println("3. 返回主菜单");
            System.out.print("请输入你的选择: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    UserService.displayAllUsers();
                    break;
                case 2:
                    System.out.print("请输入要删除的用户名: ");
                    String username = scanner.nextLine();
                    if (UserService.deleteUser(username)) {
                        System.out.println("用户删除成功！");
                    } else {
                        System.out.println("用户不存在，无法删除！");
                    }
                    break;
                case 3:
                    return; // 返回主菜单
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    // 检查是否管理员已登录
    private static boolean isAdminLoggedIn() {
        return LoginMenu.getCurrentUser() != null && "admin".equals(LoginMenu.getCurrentUser().getRole());
    }
}
