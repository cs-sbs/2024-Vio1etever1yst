package bookmanagement;

public class LogoutMenu {

    // 登出功能
    public static void logout() {
        if (LoginMenu.getCurrentUser() != null) {
            LoginMenu.setCurrentUser(null); // 设置当前用户为 null
            System.out.println("已成功登出！");
        } else {
            System.out.println("当前没有登录的用户！");
        }
    }
}
