package com.examination_system.www.dao;

import com.examination_system.www.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Modify {
    public static void ModifyPassWord(String password,String name,String TableName) throws SQLException {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "update " + TableName + " set password=? where name=?";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,password);
        ps.setString(2,name);

        //执行sql
        ps.execute();

        //关闭资源
        JDBCUtil.closeAll(null,ps,connection);
    }

    public static void ModifyStudentInfo(String name,String sex,String team,String TableName) throws SQLException {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "update " + TableName + " set name=?,sex=?,team=? where name=?";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,name);
        ps.setString(2,sex);
        ps.setString(3,team);
        ps.setString(4,name);

        //执行sql
        ps.execute();

        //关闭资源
        JDBCUtil.closeAll(null,ps,connection);
    }

    public static void ModifyBank(String TableName,String subject,String type,String title,String choiceA,String choiceB,String choiceC,String choiceD,String difficulty,String result,int id) throws SQLException {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "update " + TableName + " set subject=?,type=?,title=?,tk=?,choiceA=?,choiceB=?,choiceC=?,choiceD=?,difficulty=?,result=? where id=?";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);

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
        ps.setInt(11,id);
        //执行sql
        ps.execute();

        //执行sql
        ps.execute();

        //关闭资源
        JDBCUtil.closeAll(null,ps,connection);
    }

    public static void EnterMark(String name,int chinese,int math,int english) throws SQLException {
        //建立连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "update student set chinese=?,math=?,english=? where name=?";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //设置值
        ps.setInt(1,chinese);
        ps.setInt(2,math);
        ps.setInt(3,english);
        ps.setString(4,name);
        //执行sql
        ps.execute();
        //关闭资源
        JDBCUtil.closeAll(null,ps,connection);
    }

    public static void ModifyExam(int id,String name,String address,String time,String subject,String PaperName) throws SQLException {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "update ExamInfo set name=?,time=?,address=?,subject=?,paperName=? where id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        //设置值
        ps.setString(1,name);
        ps.setString(2,time);
        ps.setString(3,address);
        ps.setString(4,subject);
        ps.setString(5,PaperName);
        ps.setInt(6,id);

        //执行sql
        ps.execute();
        //关闭资源
        JDBCUtil.closeAll(null,ps,connection);
    }


}
