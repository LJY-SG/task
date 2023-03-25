package com.examination_system.www.service;

import com.examination_system.www.controller.LoginController;
import com.examination_system.www.controller.Student.ExamInfoController;
import com.examination_system.www.controller.Teacher.ExamManageController;
import com.examination_system.www.dao.Check;
import com.examination_system.www.po.AnswerPaper;
import com.examination_system.www.po.ExamInfo;
import com.examination_system.www.po.Paper;
import com.examination_system.www.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamService {
    //将学生答题情况存储到数据库
    public static void SaveAnswer(String answer, String paperName, int currentQuestion) throws SQLException {
        //获取学生姓名
        List<String> names = LoginController.arr;
        String StudentName = names.get(names.size() - 1);

        //获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        //试题信息
        List<Paper> papers = Check.checkPaper(paperName);
        //获取该题的信息
        Paper paper = papers.get(currentQuestion);

        boolean isExist = JudgeIsExist(StudentName + paperName);
        if (!isExist) {
            //定义sql,把学生的答题情况单独放在一个表里
            String sql1 = "create table " +StudentName+paperName+
                    "(\n" +
                    "    question varchar(500),\n" +
                    "    answer   varchar(500) ,\n" +
                    "    studentAnswer      varchar(500),\n" +
                    "    judge char(1) \n"+
                    ");";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            //执行sql
            ps1.execute();

            String AnswerPaper = StudentName+paperName;
            String sql3 = "insert into StudentAnswerPaper (name) values (?)";
            PreparedStatement ps3 = connection.prepareStatement(sql3);
            ps3.setString(1,AnswerPaper);
            ps3.execute();
            ps1.close();
            ps3.close();
        }
                String sql2 = "insert into "+ StudentName+paperName+ "(question,answer,studentAnswer) values (?,?,?)";
                //获取执行sql对像
                PreparedStatement ps2 = connection.prepareStatement(sql2);
                //设置值
                ps2.setString(1, paper.getTitle());
                ps2.setString(2, paper.getResult());
                ps2.setString(3, answer);
                //执行sql
                ps2.execute();
                JDBCUtil.closeAll(null,ps2,connection);
    }

        //判断答题卡是否存在
        public static boolean JudgeIsExist (String name) throws SQLException {
            ResultSet rs = JDBCUtil.SelectAll("StudentAnswerPaper");
            boolean flag = false;
            while (rs.next()) {
                if (rs.getString("name").equals(name)) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }

        //把状态修改成已考
    public static void ChangeStatus() throws SQLException {
        //获取考生信息
        List<ExamInfo> examInfoList = ExamInfoController.names;
        ExamInfo examInfo = examInfoList.get(examInfoList.size() - 1);

        //获取sql连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "update examInfo set status=? where paperName=?&&name=?";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //设置值
        ps.setString(1,"已考");
        ps.setString(2,examInfo.getPaperName());
        ps.setString(3,examInfo.getName());
        //执行sql
        ps.execute();
        //关闭资源
        JDBCUtil.closeAll(null,ps,connection);
    }

    //获取学生答案
    public static List<AnswerPaper> getAnswer() throws SQLException {
        //获取考生信息
        List<ExamInfo> examInfoList = ExamInfoController.names;
        ExamInfo examInfo = examInfoList.get(examInfoList.size() - 1);

        List<AnswerPaper> answerPaperList = new ArrayList<>();
        ResultSet rs = JDBCUtil.SelectAll(examInfo.getName() + examInfo.getPaperName());

        while (rs.next()){
            AnswerPaper answerPaper = new AnswerPaper();
            answerPaper.setQuestion(rs.getString("question"));
            answerPaper.setAnswer(rs.getString("answer"));
            answerPaper.setStudentAnswer(rs.getString("studentAnswer"));
            answerPaperList.add(answerPaper);
        }
        return answerPaperList;
    }

    //获取学生答案
    public static List<AnswerPaper> TeacherGetAnswer() throws SQLException {
        //获取考生信息
        List<ExamInfo> examInfoList = ExamManageController.examInfos;
        ExamInfo examInfo = examInfoList.get(examInfoList.size() - 1);

        List<AnswerPaper> answerPaperList = new ArrayList<>();
        ResultSet rs = JDBCUtil.SelectAll(examInfo.getName() + examInfo.getPaperName());

        while (rs.next()){
            AnswerPaper answerPaper = new AnswerPaper();
            answerPaper.setQuestion(rs.getString("question"));
            answerPaper.setAnswer(rs.getString("answer"));
            answerPaper.setStudentAnswer(rs.getString("studentAnswer"));
            answerPaperList.add(answerPaper);
        }
        return answerPaperList;
    }

    //将改卷对错存入答题卡
    public static void SaveJudge(String name,String paperName,String judge,String title) throws SQLException {
        //获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        //定义sql
        String sql = "update "+ name+paperName +" set judge=? where question = ?";
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //设置值
        ps.setString(1,judge);
        ps.setString(2,title);
        //执行sql
        ps.execute();
    }

    //计算分数
    public static int GetScore() throws SQLException {
        //获取选中的对象
        List<ExamInfo> examInfoList = ExamManageController.examInfos;
        ExamInfo examInfo = examInfoList.get(examInfoList.size() - 1);

        String name = examInfo.getName();
        String paperName = examInfo.getPaperName();

        ResultSet rs = JDBCUtil.SelectAll(name + paperName);

        int sum = 0;
        while (rs.next()){
            if (rs.getString("judge").equals("√")){
                sum += 10;
            }
        }

        String subject = examInfo.getSubject();

        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql ="";
        //定义sql
        if (subject.equals("数学")){
            sql = "update student set math=? where name=?";
        } else if (subject.equals("语文")) {
            sql = "update student set chinese=? where name=?";
        }else {
            sql = "update student set english=? where name=?";
        }
        //获取执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //设置值
        ps.setInt(1,sum);
        ps.setString(2,name);
        //执行sql
        ps.execute();
        //关闭资源
        JDBCUtil.closeAll(rs,ps,connection);
        return sum;
    }

}
