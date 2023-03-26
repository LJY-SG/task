package com.examination_system.www.service;

import com.examination_system.www.util.JDBCUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class LoginService {
    //判断密码是否正确
    public static boolean JudgePassWord(String password,String status,String name) throws SQLException, NoSuchAlgorithmException {
        ResultSet rs;
        if (status.equals("学生")) {
            //获取结果集对象
            rs = JDBCUtil.SelectAll("Student");
        }else {
            rs = JDBCUtil.SelectAll("Teacher");
        }

        String md5 = EncryMD5(password.getBytes());
        boolean flag = false;
        while (rs.next()){
            if (rs.getString("PassWord").equals(md5) && rs.getString("name").equals(name)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static final String KEY_MD5 = "MD5";
    public static String EncryMD5(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
        byte[] digest = md5.digest();
        return new String(digest);
    }

    //忘记密码
    public static void ForgetPassWord(String name,String password,String status) throws SQLException, NoSuchAlgorithmException {
        ResultSet rs;
        if (status.equals("学生")) {
            //获取结果集对象
            rs = JDBCUtil.SelectAll("Student");
            while (rs.next()){
                if (rs.getString("name").equals(name)){
                    //修改密码
                    ModifyPassword(name, password,"Student" );
                    break;
                }
            }
        }else {
            rs = JDBCUtil.SelectAll("Teacher");
            while (rs.next()){
                if (rs.getString("name").equals(name)){
                    //修改密码
                    ModifyPassword(name, password,"Teacher" );
                    break;
                }
            }
        }
        JDBCUtil.closeAll(rs,null,null);
    }

    //修改密码
    public static void ModifyPassword(String name,String password,String TableName) throws SQLException, NoSuchAlgorithmException {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "update " + TableName + " set password=? where name=?";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //设置值
        ps.setString(1,EncryMD5(password.getBytes()));
        ps.setString(2,name);
        //执行sql
        ps.execute();
        //关闭资源
        JDBCUtil.closeAll(null,ps,connection);
    }

}
