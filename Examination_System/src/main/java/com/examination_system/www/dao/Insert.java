package com.examination_system.www.dao;

import com.examination_system.www.util.JDBCUtil;

import java.sql.*;

public class Insert {
    public static boolean InsertPaperSource(String subject,String paperName) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        ResultSet rs = JDBCUtil.SelectAll("PaperSource");
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        boolean flag = false;
        while (rs.next()){
            if (rs.getString("PaperName").equals(paperName)){
                flag = true;
                break;
            }
        }
        if (!flag){
            try {
                connection.setAutoCommit(false);

                String sql1 = "insert into PaperSource (PaperName) values (?)";
                String sql2 = "create table " + paperName + "(\n" +
                        "    id int primary key auto_increment comment '题号',\n" +
                        "    subject varchar(200) comment '科目',\n" +
                        "    type varchar(20) comment '题目类型',\n" +
                        "    title varchar(2000) comment '题目',\n" +
                        "    tk varchar(500) comment '填空',\n" +
                        "    choiceA varchar(500) comment 'A选项',\n" +
                        "    choiceB varchar(500) comment 'B选项' ,\n" +
                        "    choiceC varchar(500) comment 'C选项',\n" +
                        "    choiceD varchar(500) comment 'D选项',\n" +
                        "    difficulty varchar(20) comment '难度',\n" +
                        "    result varchar(500) comment '答案'\n" +
                        ")comment '试卷';";

                ps1 = connection.prepareStatement(sql1);
                ps2 = connection.prepareStatement(sql2);

                ps1.setString(1,paperName);
                ps1.execute();
                ps2.execute();

                connection.commit();
            }catch (SQLException throwables) {
                connection.rollback();   //如果失败就回滚, 不写这句也会回滚
                throwables.printStackTrace();
            }finally {
                ps2.close();
                JDBCUtil.closeAll(rs,ps1,connection);
            }
        }
        return flag;
    }

    public static void InsertTitle(String TableName,String subject, String type, String title, String choiceA, String choiceB, String choiceC, String choiceD, String difficulty, String result) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into "+ TableName +" (subject, type, title, tk, choiceA, choiceB, choiceC, choiceD, difficulty, result) values (?,?,?,?,?,?,?,?,?,?)";
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

    public static void InsertExamInfo(int id, String name, String address, String time, String subject, String PaperName) throws SQLException {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "insert into ExamInfo (id,name,time,address,subject,paperName,status) values (?,?,?,?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);

        //设置值
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setString(3,time);
        ps.setString(4,address);
        ps.setString(6,subject);
        ps.setString(5,PaperName);
        ps.setString(7,"未考");

        //执行sql
        ps.execute();
        //关闭资源
        JDBCUtil.closeAll(null,ps,connection);
    }
}
