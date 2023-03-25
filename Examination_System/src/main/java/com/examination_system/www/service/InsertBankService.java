package com.examination_system.www.service;

import com.examination_system.www.po.Bank;
import com.examination_system.www.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertBankService {
    //将数据加进数据库
    public static void InsertIntoBank(String subject, String type, String title, String choiceA, String choiceB, String choiceC, String choiceD, String difficulty, String result) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into bank (subject, type, title, tk, choiceA, choiceB, choiceC, choiceD, difficulty, result) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            //给变量赋值，存进数据库
            ps.setString(1, subject);
            ps.setString(2, type);
            ps.setString(3, title);
            if (type.equals("单选题") || type.equals("多选题")) {
                ps.setString(4, null);
                ps.setString(5, choiceA);
                ps.setString(6, choiceB);
                ps.setString(7, choiceC);
                ps.setString(8, choiceD);
            }
            if (type.equals("填空题")) {
                ps.setString(4, "_______");
                ps.setString(5, null);
                ps.setString(6, null);
                ps.setString(7, null);
                ps.setString(8, null);
            }
            ps.setString(9, difficulty);
            ps.setString(10, result);
            //执行sql
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtil.closeAll(null, ps, connection);
        }
    }

    public static List<Bank> check() throws SQLException {
        List<Bank> banks = new ArrayList<>();
        //从数据库获取数据输出
        Connection connection = JDBCUtil.getConnection();
        ResultSet rs = JDBCUtil.SelectAll("Bank");
        try {
            while (rs.next()) {
                Bank b = new Bank();
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
        JDBCUtil.closeAll(rs,null,connection);
        return banks;
    }
}
