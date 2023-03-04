import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-type","text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\kk.txt"));

        //创建结合对象
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

        int count = 0;
        boolean flag = false;
        //遍历集合
        for (Student s : array){
            if (s.getName().equals(req.getParameter("ModifyName"))){
                array.remove(count);
                count = 0;
                flag = true;
                break;
            }
            count++;
        }

        BufferedWriter bw  = new BufferedWriter(new FileWriter("E:\\itcase\\kk.txt"));
        for(Student s : array){
            StringBuilder sb = new StringBuilder();
            sb.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getSex()).append(",").append(s.getBirthdate()).append(",").append(s.getEmail()).append(",").append(s.getNote());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }

        if (flag) {
            //重新添加学生信息
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
        }else {
            resp.getWriter().write("修改失败");
        }

    }
}
