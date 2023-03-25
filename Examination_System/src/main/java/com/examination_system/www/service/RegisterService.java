package com.examination_system.www.service;

import com.examination_system.www.util.JDBCUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterService {
    //判断用户是否已经注册
    public static boolean isRegister(String UserName,String status) throws SQLException {
        //查询数据库获取结果集对象
        boolean flag;
        ResultSet rs;
        if (status.equals("学生")) {
            rs = JDBCUtil.SelectAll("Student");
        }else {
            rs = JDBCUtil.SelectAll("Teacher");
        }
            flag = false;
            while (rs.next()) {
                if (rs.getString("Name").equals(UserName) && rs.getString("password") != null) {
                    //如果有该用户名,且密码不等于null,即只是初始化用户
                    flag = true;
                }
            }
        return flag;
    }

    //判断用户性别
    public static String JudgeSex(boolean sex){
        String s = "男";
        if (!sex){
            s = "女";
        }
        return s;
    }

    //判断用户身份
    public static String JudgeStatus(boolean status){
        String s = "学生";
        if (!status){
            s = "老师";
        }
        return s;
    }

    //将数据添加至数据库
    public static void Insert(String TableName,String UserName,String PassWord,String Sex) throws SQLException, NoSuchAlgorithmException {
        //获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "insert into "+ TableName +" (name,password,sex) values (?,?,?)";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //设置值
        ps.setString(1,UserName);
        ps.setString(2,EncryMD5(PassWord.getBytes()));
        ps.setString(3,Sex);
        //执行sql
        ps.execute();
    }

    //密码加密
    public static final String KEY_MD5 = "MD5";
    public static String EncryMD5(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
        byte[] digest = md5.digest();
        return new String(digest);
    }

}
