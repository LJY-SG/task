package com.examination_system.www.util;

import java.sql.*;

public class JDBCUtil {

    private static final String url = "jdbc:mysql://localhost:3306/exam_system?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
    private static final String username = "root";
    private static final String password = "ljy040226";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //查询数据库
    public static ResultSet SelectAll(String TableName) throws SQLException {
        //获取连接
        Connection connection = getConnection();
        //定义sql
        String sql = "select * from " + TableName;
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //执行sql
        ResultSet rs = ps.executeQuery();
        //返回结果集对象
        return rs;
    }

    //删除数据库数据
    public static void DeleteAll(String TableName,int id) throws SQLException {
        //获取连接
        Connection connection = getConnection();
        //定义sql
        String sql = "delete from " + TableName + " where id = ?";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        //执行sql
        ps.execute();
        //关闭资源
        closeAll(null,ps,connection);
    }

    //将数据修改写入数据库
    public static void Modify(String name,String sex,String team,String TableName) throws SQLException {
        //获取连接
        Connection connection = getConnection();

        //定义sql
        String sql = "update "+TableName+" set name=?,sex=?,team=? where name=?";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,name);
        ps.setString(2,sex);
        ps.setString(3,team);
        ps.setString(4,name);

        //执行sql
        ps.execute();
        //关闭资源
        closeAll(null,ps,connection);
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
