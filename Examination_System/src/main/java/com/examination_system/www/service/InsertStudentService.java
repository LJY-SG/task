package com.examination_system.www.service;

import com.examination_system.www.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudentService {
    //将学生信息添加至数据库
    public static void InsertStudent(String name,String sex,String team) throws SQLException {
        //建立连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "insert into student (name,sex,team) values (?,?,?)";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,name);
        ps.setString(2,sex);
        ps.setString(3,team);

        //执行sql
        ps.execute();
        //关闭资源
        JDBCUtil.closeAll(null,ps,connection);
    }
}
