package com.examination_system.www.dao;

import com.examination_system.www.controller.LoginController;
import com.examination_system.www.controller.Student.ExamInfoController;
import com.examination_system.www.controller.Teacher.ManageStudentController;
import com.examination_system.www.po.ExamInfo;
import com.examination_system.www.po.Paper;
import com.examination_system.www.po.Student;
import com.examination_system.www.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Check {
    public static List<Paper> checkPaper(String TableName) throws SQLException {
        ResultSet rs = JDBCUtil.SelectAll(TableName);
        List<Paper> list = new ArrayList<>();
        while (rs.next()){
            Paper paper = new Paper();
            paper.setId(rs.getInt("id"));
            paper.setSubject(rs.getString("subject"));
            paper.setType(rs.getString("type"));
            paper.setTitle(rs.getString("title"));
            paper.setChoiceA(rs.getString("choiceA"));
            paper.setChoiceB(rs.getString("choiceB"));
            paper.setChoiceC(rs.getString("choiceC"));
            paper.setChoiceD(rs.getString("choiceD"));
            paper.setDifficulty(rs.getString("difficulty"));
            paper.setResult(rs.getString("result"));

            list.add(paper);
        }
        return list;
    }

//    public static List<Student> checkStudent(String TableName) throws SQLException {
//        //获取登录的老师的姓名
//        List<String> list1 = LoginController.arr;
//
//
//        ResultSet rs = JDBCUtil.SelectAll(TableName);
//        List<Student> list2 = new ArrayList<>();
//        while (rs.next()){
//            Student student = new Student();
//            student.setId(rs.getInt("id"));
//            student.setChinese(rs.getInt("chinese"));
//            student.setMath(rs.getInt("math"));
//            student.setEnglish(rs.getInt("english"));
//
//            list2.add(student);
//        }
//        return list2;
//    }

    public static Student CheckStudent() throws SQLException {
        //获取登录的名字
        List<String> list1 = LoginController.arr;
        String name = list1.get(list1.size() -1);

        ResultSet rs = JDBCUtil.SelectAll("student");

        Student student = new Student();

        while (rs.next()){
            if (rs.getString("name").equals(name)){
                student.setName(name);
                student.setId(rs.getInt("id"));
                student.setChinese(rs.getInt("chinese"));
                student.setMath(rs.getInt("math"));
                student.setEnglish(rs.getInt("english"));
            }
        }
        return student;
    }

    public static String GetPaperData() throws SQLException {
        List<ExamInfo> names = ExamInfoController.names;

        ExamInfo examInfo = names.get(names.size() - 1);
        //获取连接
            Connection connection = JDBCUtil.getConnection();
            //获取查询返回对象
            ResultSet paper = JDBCUtil.SelectAll(examInfo.getPaperName());

            //创建集合对象
            List<Paper> papers = new ArrayList<>();

            while (paper.next()) {
                //创建paper对象
                Paper b = new Paper();

                b.setId(paper.getInt("id"));
                b.setType(paper.getString("type"));
                b.setSubject(paper.getString("subject"));
                b.setTitle(paper.getString("title"));
                b.setTk(paper.getString("tk"));
                b.setChoiceA(paper.getString("choiceA"));
                b.setChoiceB(paper.getString("choiceB"));
                b.setChoiceC(paper.getString("choiceC"));
                b.setChoiceD(paper.getString("choiceD"));
                b.setDifficulty(paper.getString("difficulty"));

                //添加到集合对象
                papers.add(b);
            }
            StringBuilder sb = new StringBuilder();
            for (Paper b : papers) {
                if (b.getType().equals("单选题") || b.getType().equals("多选题")) {
                    sb.append(b.toString1());
                }
                if (b.getType().equals("填空题")) {
                    sb.append(b.toString2());
                }
            }
            return sb.toString();
        }

    public static List<ExamInfo> CheckExamInfo() throws SQLException {
            //获取选中学生的信息
            List<Student> students = ManageStudentController.students;
            Student student = students.get(students.size() - 1);
            //获取连接
            Connection connection = JDBCUtil.getConnection();
            //获取学生表的信息结果集对象
            ResultSet rs = JDBCUtil.SelectAll("ExamInfo");
            //创建集合
            List<ExamInfo> examInfoList = new ArrayList<>();

            //将选中的学生对象所有考试信息添加至集合
            while (rs.next()){
                ExamInfo examInfo = new ExamInfo();
                if (rs.getString("name").equals(student.getName())) {
                    //给学生对象赋值
                    examInfo.setId(rs.getInt("id"));
                    examInfo.setName(rs.getString("name"));
                    examInfo.setSubject(rs.getString("subject"));
                    examInfo.setAddress(rs.getString("address"));
                    examInfo.setTime(rs.getString("time"));
                    examInfo.setPaperName(rs.getString("paperName"));
                    examInfo.setStatus(rs.getString("status"));
                    //将学生对象加到集合中
                    examInfoList.add(examInfo);
                }
            }
            return examInfoList;
        }

    public static List<ExamInfo> GetExamInfoData() throws SQLException {
        //获取登录学生的信息
        List<String> names = LoginController.arr;
        String name = names.get(names.size()-1);
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //获取学生表的信息结果集对象
        ResultSet rs = JDBCUtil.SelectAll("ExamInfo");
        //创建集合
        List<ExamInfo> examInfoList = new ArrayList<>();

        //将选中的学生对象所有考试信息添加至集合
        while (rs.next()){
            ExamInfo examInfo = new ExamInfo();
            if (rs.getString("name").equals(name)) {
                //给学生对象赋值
                examInfo.setId(rs.getInt("id"));
                examInfo.setName(rs.getString("name"));
                examInfo.setSubject(rs.getString("subject"));
                examInfo.setAddress(rs.getString("address"));
                examInfo.setTime(rs.getString("time"));
                examInfo.setPaperName(rs.getString("paperName"));
                examInfo.setStatus(rs.getString("status"));
                //将学生对象加到集合中
                examInfoList.add(examInfo);
            }
        }
        return examInfoList;
    }

}

