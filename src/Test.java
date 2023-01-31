import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        Func func = new Func();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            func.menu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    func.regester();
                    break;
                case 2:
                    func.Login();
                    break;
                case 3:
                    func.Forget();
                    break;
                case 4:
                    func.exit();
                    flag = false;
                    break;
                default:
                    System.out.println("输入异常，请重新输入!");
            }
        }
    }
}
