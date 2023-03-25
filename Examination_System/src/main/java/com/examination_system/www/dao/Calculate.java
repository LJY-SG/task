package com.examination_system.www.dao;

import com.examination_system.www.controller.LoginController;
import com.examination_system.www.po.Student;
import com.examination_system.www.service.ManageStudentService;
import com.examination_system.www.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Calculate {
    public static Double AverageChinese() throws SQLException {
        List<Student> students = ManageStudentService.GetData();
        double sum = 0;
        double i = 0;
        for (Student s : students){
            sum += s.getChinese();
            i++;
        }
        return sum / i;
    }
    public static Double AverageMath() throws SQLException {
        List<Student> students = ManageStudentService.GetData();
        double sum = 0;
        double i = 0;
        for (Student s : students){
            sum += s.getMath();
            i++;
        }
        return sum / i;
    }
    public static Double AverageEnglish() throws SQLException {
        List<Student> students = ManageStudentService.GetData();
        double sum = 0;
        double i = 0;
        for (Student s : students){
            sum += s.getEnglish();
            i++;
        }
        return sum / i;
    }

    public static int GetSum() throws SQLException {
        List<String> names = LoginController.arr;
        String name = names.get(names.size() -1);

        ResultSet rs = JDBCUtil.SelectAll("student");

        int sum = 0;
        while (rs.next()){
            if (rs.getString("name").equals(name)){
                sum = rs.getInt("chinese") + rs.getInt("math") + rs.getInt("english");
            }
        }
        return sum;
    }
}
