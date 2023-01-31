import java.io.IOException;

public interface system {
    //菜单
    void menu();
    //注册功能
    void regester() throws IOException;
    //登录功能
    void Login() throws IOException, InterruptedException;
    //忘记密码功能
    void Forget() throws IOException;
    //退出功能
    void exit();
}
