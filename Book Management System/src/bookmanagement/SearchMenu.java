package bookmanagement;

import java.util.Scanner;

public class SearchMenu {

    // 搜索图书
    public static void searchBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要搜索的图书名称或ISBN: ");
        String query = scanner.nextLine();

        boolean found = false;

        // 使用 BookService 提供的接口访问 books
        for (Book book : BookService.getBooks()) {
            // 检查书名或 ISBN 是否包含查询内容
            if (book.getTitle().contains(query) || book.getIsbn().contains(query)) {
                book.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("未找到相关图书！");
        }
    }
}
