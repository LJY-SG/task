import java.sql.*;
import java.util.Scanner;

public class Func implements system{
    //创建用户对象
    User user = new User();
    Scanner sc = new Scanner(System.in);

    String url="jdbc:mysql://localhost:3306/itcast?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT%2B8";
    String username ="root";
    String password ="ljy040226";

    Connection conn = DriverManager.getConnection(url,username,password);

    public Func() throws SQLException {
    }


    public void menu(){
        System.out.println("----------欢迎使用登录系统----------");
        System.out.println("          1.注册");
        System.out.println("          2.登录");
        System.out.println("          3.忘记密码");
        System.out.println("          4.退出");
        System.out.print("请选择您要使用的功能: ");
    }

    //注册功能
    public void regester() throws SQLException {
        System.out.println("----------欢迎使用注册功能！----------");
        System.out.print("请设置您的用户名: ");
        user.setName(sc.nextLine());
        System.out.print("请设置您的密码: ");
        user.setPwd(sc.nextLine());
        System.out.print("请再次输入您的密码: ");
        String pwd = sc.nextLine();

        String sql = "select * from User where name = ? ";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置？的值
        pstmt.setString(1,user.getName());

        ResultSet rs = pstmt.executeQuery();

        //4，获取执行sqL的对象 Statement
        conn.createStatement();

        boolean flag = start(user.getPwd());

        if (rs.next()){
            System.out.println("--------注册失败,该用户已经存在--------");
        }else if(!flag && user.getPwd().equals(pwd)){
            String sql1 = "insert into User (name,password) values(?,?);";
            PreparedStatement pstmt2 = conn.prepareStatement(sql1);
            pstmt2.setString(1,user.getName());
            pstmt2.setString(2,user.getPwd());
            pstmt2.execute();
            System.out.println("-----------注册成功----------");
        }else if (!pwd.equals(user.getPwd())){
            System.out.println("-----您两次输入的密码不一致,请重新设置密码------");
        }else {
            System.out.println("----------您输入的密码不符合规范，请重新设置您的密码----------");
        }
    }

    //登录功能
    public void Login() throws SQLException, InterruptedException {
        int count = 10;
        while (true) {
            System.out.println("----------欢迎使用登录功能！----------");
            System.out.print("请输入您的用户名: ");
            String name = sc.nextLine();
            System.out.print("请输入您的密码: ");
            String pwd = sc.nextLine();

            String sql = "select * from User where name = ? and password = ?";

            //获取pstmt对象
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //设置？的值
            pstmt.setString(1,name);
            pstmt.setString(2,pwd);

            ResultSet rs = pstmt.executeQuery();

            //4，获取执行sqL的对象 Statement
            conn.createStatement();


            boolean flag = false;
            while (rs.next()){
                System.out.println("----------你好!" +name+  "----------");
                flag = true;
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
    public void Forget() throws SQLException {
        System.out.println("----------欢迎使用忘记密码功能----------");
        System.out.print("请输入您的用户名 :");
        String name = sc.nextLine();
        System.out.print("请输入您修改的密码 :");
        String pwd2 = sc.nextLine();

        //定义sql
        String sql = "select * from user where name = ? ";
        //获取pstmt对象
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        //设置？的值
        pstmt1.setString(1,name);
        ResultSet rs1 = pstmt1.executeQuery();

        //4，获取执行sqL的对象 Statement
        conn.createStatement();

        boolean judge = start(pwd2);

        boolean flag = false;
        while (rs1.next()){
            //定义sql
            if (!judge){
            String sql2 = "update user set password= ? where name = ?";
            //获取pstmt对象
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            //设置？的值
            pstmt2.setString(1,pwd2);
            pstmt2.setString(2,name);
            pstmt2.execute();
            System.out.println("----------修改成功!----------");
            }
            flag=true;
        }
        if (!flag){
            System.out.println("-----------该用户不存在-----------");
        }
        if (judge==true){
            System.out.println("----------您输入的密码不符合规范，请重新设置您的密码----------");
        }
    }

    //退出功能
    public void exit(){
        System.out.println("----------您已退出登录系统，欢迎下次使用----------");
    }


    //判断密码是否有特殊字符开头
    public boolean start(String pwd) {
        boolean flag = false;
        String[] s = {"!","@","#","$","%","^","&","*","(",")","-","_","=","+","——","[","]","{","}","/","?",";","|","~","'","<",".",">",","," "};
        for (String ss :s){
            if (pwd.startsWith(ss)){
                flag = true;
            }
        }
        return  flag;
    }
}
