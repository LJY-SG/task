package com.examination_system.www.service;

import com.examination_system.www.util.JDBCUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
}
