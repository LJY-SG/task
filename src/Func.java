import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Func implements system{
    //创建用户对象
    User user = new User();
    Scanner sc = new Scanner(System.in);

    ArrayList<String> Read = new ArrayList<>();



    //菜单
    public void menu(){
        System.out.println("----------欢迎使用登录系统----------");
        System.out.println("          1.注册");
        System.out.println("          2.登录");
        System.out.println("          3.忘记密码");
        System.out.println("          4.退出");
        System.out.print("请选择您要使用的功能: ");
    }

    //注册功能
    public void regester() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("E:\\itcase\\user.txt", true)) {
            BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\user.txt"));

            System.out.println("----------欢迎使用注册功能！----------");
            System.out.print("请设置您的用户名: ");
            user.setName(sc.nextLine());
            System.out.print("请设置您的密码: ");
            user.setPwd(sc.nextLine());
            System.out.print("请再次输入您的密码: ");
            String pwd = sc.nextLine();

            String line;
            int flag = 0;
            ArrayList<String> strArray = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                strArray.add(line);
            }

            for (String s : strArray) {
                if (s.split(",")[0].equals(user.getName())) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0 && pwd.equals(user.getPwd())) {
                ArrayList<User> array = new ArrayList<>();
                array.add(user);
                for (User u : array) {
                    System.out.println(u.getName() + "," + u.getPwd());
                }
                    //遍历集合，得到每一个字符串数据
                    for (User s : array) {
                        fos.write((s.getName() + "," + s.getPwd()).getBytes());
                        fos.write("\n".getBytes());
                        fos.flush();
                    }
                    System.out.println("----------注册成功!----------");
                } else if (flag == 1) {
                    System.out.println("----------注册失败!该用户已存在!-----------");
                } else {
                    System.out.println("----------注册失败!----------");
                }
            }
        }

    //登录功能
    public void Login() throws IOException, InterruptedException {
        int count = 10;
        while (true) {
            System.out.println("----------欢迎使用登录功能！----------");
            System.out.print("请输入您的用户名: ");
            String name = sc.nextLine();
            System.out.print("请输入您的密码: ");
            String pwd = sc.nextLine();

            FileInputStream fis = new FileInputStream("E:\\itcase\\user.txt");
            String str;
            String[] s = {};

            // 3.读取数据
            byte[] bytes = new byte[fis.available()];
            int len;// 记录每次读取的字节的个数

            while ((len = fis.read(bytes)) != -1) {
                str = new String(bytes, 0, len);
                s = str.split("\n");
            }

            boolean flag = false;

            for (String ss : s) {
                if (name.equals(ss.split(",")[0]) && pwd.equals(ss.split(",")[1])) {
                    System.out.println("          您好!"+name);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                count--;
                System.out.println("----------登录失败,您还有"+count+"次机会----------");
                if (count == 0){
                    System.out.println("---------请30秒后再试---------");
                    Thread.sleep(30000);
                    count = 10;
                }
            }else {
                break;
            }
        }
    }

    //忘记密码功能
    public void Forget() throws IOException {
        System.out.println("----------欢迎使用忘记密码功能----------");
        System.out.print("请输入您的用户名 :");
        String name = sc.nextLine();
        System.out.print("请输入您修改的密码 :");
        String pwd2 = sc.nextLine();
        BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\user.txt"));

        String line;
        while ((line=br.readLine()) != null){
            if (!line.split(",")[0].equals(name)){
                Read.add(line);
            }
        }

        Read.add(name+","+pwd2);

        FileOutputStream fos = new FileOutputStream(new File("E:\\itcase\\user.txt"));
        //遍历集合，得到每一个字符串数据
        for(String ss : Read){
            fos.write(ss.getBytes());
            fos.write("\n".getBytes());
            fos.flush();
        }
        fos.close();
    }

    //退出功能
    public void exit(){
        System.out.println("----------您已退出登录系统，欢迎下次使用----------");
    }

}
