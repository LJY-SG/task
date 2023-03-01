import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        //获取填写的值，并赋给学生
        stu.setId(req.getParameter("id"));
        stu.setName(req.getParameter("name"));
        if (req.getParameter("sex").equals("on")){
            stu.setSex("男");
        }else {
            stu.setSex("女");
        }
//        stu.setSex(req.getParameter("sex"));
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
            //使用字符缓冲流对象的方法写入数据
//            bw.write(s.getId()+","+s.getName()+","+s.getSex()+","+s.getBirthdate()+","+s.getEmail()+","+s.getNote());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
