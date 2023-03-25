package com.examination_system.www.service;

import com.examination_system.www.controller.LoginController;
import com.examination_system.www.po.Student;
import com.examination_system.www.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageStudentService {

    //获取数据库数据
    public static List<Student> GetData() throws SQLException {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //获取学生表的信息结果集对象
        ResultSet rs = JDBCUtil.SelectAll("student");
        //创建集合
        List<Student> students = new ArrayList<>();

        //获取登录的老师名字
        List<String> teachers =  LoginController.arr;
        String teacherName = teachers.get(teachers.size()-1);

        //获取老师信息结果集对象
        ResultSet teacher = JDBCUtil.SelectAll("teacher");
        String t = "";
        while (teacher.next()){
            if (teacher.getString("name").equals(teacherName)){
                t = teacher.getString("team");
            }
        }

        //将老师执教班级的学生对象添加至集合
        while (rs.next()){
            Student student = new Student();
            if (rs.getString("team").equals(t)) {
                //给学生对象赋值
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setTeam(rs.getString("team"));
                student.setChinese(rs.getInt("chinese"));
                student.setMath(rs.getInt("math"));
                student.setEnglish(rs.getInt("english"));
                //将学生对象加到集合中
                students.add(student);
            }
        }
        return students;
    }
}
