import java.io.IOException;
import java.sql.SQLException;

public interface system {
    //菜单
    void menu();
    //注册功能
    void regester() throws IOException, SQLException;
    //登录功能
    void Login() throws IOException, InterruptedException, SQLException;
    //忘记密码功能
    void Forget() throws IOException, Exception;
    //退出功能
    void exit();
}
