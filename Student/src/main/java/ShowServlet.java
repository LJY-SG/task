
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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

        //释放资源
        br.close();

        //遍历集合
        for(Student s : array){
            resp.getWriter().write(s.getId()+","+s.getName()+","+s.getSex()+","+s.getBirthdate()+","+s.getEmail()+","+s.getNote());
        }

        //释放资源
        br.close();
        }
    }
