package bookmanagement;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String category;

    // 构造函数
    public Book(String title, String author, String isbn, String category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
    }

    // Getter 方法
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategory() {
        return category;
    }

    // 显示图书信息
    public void display() {
        System.out.println("书名: " + title + ", 作者: " + author + ", ISBN: " + isbn + ", 类别: " + category);
    }
}
