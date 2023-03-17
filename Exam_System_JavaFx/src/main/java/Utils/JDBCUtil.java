package Utils;
import domain.bank;
import domain.exam;
import domain.paperSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/examinations?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=GMT%2B8";
    private static final String username = "root";
    private static final String password = "ljy040226";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ResultSet selectAll(String name, Connection coon) throws SQLException {
        //定义sql
        String sql = "select * from " + name;
        //4，获取执行sqL的对象
        Statement stmt = coon.createStatement();
        //5，执sql ,返回查询结果集对象
        return stmt.executeQuery(sql);//受影响的行数
    }

    //试题库检查
    public static List<bank> check() throws SQLException {
        List<bank> banks = new ArrayList<>();
        //从数据库获取数据输出
        Connection connection = JDBCUtil.getConnection();
        ResultSet rs = JDBCUtil.selectAll("test_question_bank", connection);
        try {
            while (rs.next()) {
                bank b = new bank();
                //给对象属性赋值
                b.setId(rs.getInt("id"));
                b.setType(rs.getString("type"));
                b.setSubject(rs.getString("subject"));
                b.setTitle(rs.getString("title"));
                b.setTk(rs.getString("tk"));
                b.setChoiceA(rs.getString("choiceA"));
                b.setChoiceB(rs.getString("choiceB"));
                b.setChoiceC(rs.getString("choiceC"));
                b.setChoiceD(rs.getString("choiceD"));
                b.setDifficulty(rs.getString("difficulty"));
                b.setResult(rs.getString("result"));
                //将对象加入集合中
                banks.add(b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        closeAll(rs,null,connection);
        return banks;
    }

    public static List<exam> checkExam() throws SQLException {
        List<exam> exams = new ArrayList<>();
        //从数据库获取数据输出
        Connection connection = JDBCUtil.getConnection();
        ResultSet rs = JDBCUtil.selectAll("exam", connection);
        try {
            while (rs.next()) {
                exam e = new exam();
                //给对象属性赋值
                e.setTime(rs.getDate("time"));
                e.setSubject(rs.getString("subject"));
                e.setName(rs.getString("name"));
                e.setAddress(rs.getString("address"));
                e.setPaperName(rs.getString("PaperName"));
                exams.add(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        closeAll(rs,null,connection);
        return exams;
    }

    //试卷库检查
    public static List<paperSource> checkPaperSource() throws SQLException {
        List<paperSource> paperSourceList = new ArrayList<>();
        //从数据库获取数据输出
        Connection connection = JDBCUtil.getConnection();
        ResultSet rs = JDBCUtil.selectAll("PaperSource", connection);
        try {
            while (rs.next()) {
                paperSource p = new paperSource();
                //给对象属性赋值
                p.setId(rs.getInt("id"));
                p.setPaperName(rs.getString("PaperName"));
                //将对象加入集合中
                paperSourceList.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        closeAll(rs,null,connection);
        return paperSourceList;
    }

    //修改数据
    public static void Delete(int value,String tableName) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from "+ tableName +" where id = ?";
        PreparedStatement ps = null;
        ResultSet rs = JDBCUtil.selectAll(tableName, connection);
        while (rs.next()){
            if (rs.getInt("id") == value){
                ps = connection.prepareStatement(sql);
                ps.setInt(1,value);
                ps.execute();
                break;
            }
        }
    }

    //删除exam表的数据
    public static void Delete(String tableName,String name) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from "+ tableName +" where name = ? ";
        PreparedStatement ps = null;
        ResultSet rs = JDBCUtil.selectAll(tableName, connection);
        while (rs.next()){
            if (rs.getString("name").equals(name)){
                ps = connection.prepareStatement(sql);
                ps.setString(1,name);
                ps.execute();
                break;
            }
        }
    }

    //关闭资源
    public static void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
        try {
            if(rs!=null) {
                rs.close();  //如果要避免空指针，那么需要进行对象为空的判定
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null) {
                conn.close();  //如果要避免空指针，那么需要进行对象为空的判定
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps!=null) {
                ps.close();  //如果要避免空指针，那么需要进行对象为空的判定
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}