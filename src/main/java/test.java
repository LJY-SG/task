import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        Func func = new Func();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            func.menu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try {
                        func.regester();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    func.Login();
                    break;
                case 3:
                    try {
                        func.Forget();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
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
