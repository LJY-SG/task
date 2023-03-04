import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type","text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        //创建学生对象
        Student stu = new Student();
        //创建集合对象
        ArrayList<Student> arr = new ArrayList<>();


        BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\kk.txt"));
        ArrayList<Student> array = new ArrayList<>();

        //读写数据，复制文件
        //使用字符缓冲流特有的功能实现
        String line;
        while ((line=br.readLine()) != null){
            String[] strArray = line.split(",");

            //创建学生对象
            Student s = new Student();
            //把字符串数组中的每一个元素取出来对应的赋值给学生对象的成员变量值
            s.setId(strArray[0]);
            s.setName(strArray[1]);
            s.setSex(strArray[2]);
            s.setBirthdate(strArray[3]);
            s.setEmail(strArray[4]);
            s.setNote(strArray[5]);

            //把学生对象添加到集合
            array.add(s);
        }

        boolean flag = false;
        //遍历集合
        for (Student s : array){
            if (s.getName().equals(req.getParameter("name"))){
                flag = true;
                break;
            }
        }
        if (!flag){
            //获取填写的值，并赋给学生
            stu.setId(req.getParameter("id"));
            stu.setName(req.getParameter("name"));
            if (req.getParameter("sex").equals("on")){
                stu.setSex("男");
            }else {
                stu.setSex("女");
            }
            stu.setBirthdate(req.getParameter("birthdate"));
            stu.setEmail(req.getParameter("email"));
            stu.setNote(req.getParameter("notes"));

            //将学生添加到集合中
            arr.add(stu);

            //将信息写入文件
            //创建字符缓冲输出流对象
            BufferedWriter bw  = new BufferedWriter(new FileWriter("E:\\itcase\\kk.txt"));

            //遍历集合，得到每一个字符串数据
            for(Student s : arr){
                StringBuilder sb = new StringBuilder();
                sb.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getSex()).append(",").append(s.getBirthdate()).append(",").append(s.getEmail()).append(",").append(s.getNote());
                bw.write(sb.toString());
                bw.newLine();
                bw.flush();
            }
            bw.close();
        }

        if (!flag) {
            resp.getWriter().write("添加成功");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }else {
            resp.getWriter().write("添加失败，该用户已经存在");
        }
    }
}
