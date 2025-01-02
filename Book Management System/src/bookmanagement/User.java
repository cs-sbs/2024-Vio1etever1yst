package bookmanagement;

public class User {
    private String username;
    private String password;
    private String role; // "admin" 或 "guest"

    // 构造方法
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter 和 Setter 方法
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
