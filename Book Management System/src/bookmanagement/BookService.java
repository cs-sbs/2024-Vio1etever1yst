package bookmanagement;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("Java语言程序设计", "深泽刚", "1234567890", "计算机"));
        books.add(new Book("百年孤独", "Gabriel José de la Concordia García Márquez", "0987654321", "文学"));
        books.add(new Book("最好的告别：关于衰老与死亡，你必须知道的常识", "Atul Gawande", "1122334455", "医学"));
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("目前没有图书！");
            return;
        }
        for (Book book : books) {
            book.display();
        }
    }
}
