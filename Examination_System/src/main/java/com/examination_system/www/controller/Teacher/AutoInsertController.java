package com.examination_system.www.controller.Teacher;

import com.examination_system.www.po.Bank;
import com.examination_system.www.po.Paper;
import com.examination_system.www.util.JDBCUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class AutoInsertController {

    @FXML
    private TextField paperName;

    @FXML
    private Button InsertPaper;

    @FXML
    private Button Return;

    @FXML
    private Label success;

    @FXML
    private TextField subject;

    @FXML
    private Label fail;

    public void InsertPaper(Connection connection, String paperName) throws SQLException {
        ResultSet questionBank = JDBCUtil.SelectAll("bank");

        //创建集合对象
        ArrayList<Bank> banks = new ArrayList<>();

        while (questionBank.next()) {
            //创建bank对象
            Bank b = new Bank();

            b.setId(questionBank.getInt("id"));
            b.setType(questionBank.getString("type"));
            b.setSubject(questionBank.getString("subject"));
            b.setTitle(questionBank.getString("title"));
            b.setTk(questionBank.getString("tk"));
            b.setChoiceA(questionBank.getString("choiceA"));
            b.setChoiceB(questionBank.getString("choiceB"));
            b.setChoiceC(questionBank.getString("choiceC"));
            b.setChoiceD(questionBank.getString("choiceD"));
            b.setDifficulty(questionBank.getString("difficulty"));
            b.setResult(questionBank.getString("result"));

            //添加到集合对象
            banks.add(b);
        }

        //定义单选题对象集合
        ArrayList<Bank> dan = new ArrayList<>();
        //定义多选题集合对象
        ArrayList<Bank> duo = new ArrayList<>();
        //定义填空题集合对象
        ArrayList<Bank> tk = new ArrayList<>();


        //遍历集合，从中获取题目
        //获取题目
        for (Bank b : banks) {
            if (b.getType().equals("单选题") && b.getSubject().equals(subject.getText())) {
                dan.add(b);
            }
            if (b.getType().equals("多选题") && b.getSubject().equals(subject.getText())) {
                duo.add(b);
            }
            if (b.getType().equals("填空题") && b.getSubject().equals(subject.getText())) {
                tk.add(b);
            }
        }

        //创建试卷集合对象
        ArrayList<Paper> papers = new ArrayList<>();


        //把单选题加入到试卷集合中
        add(dan, papers);
        //把多选题加到试卷集合中
        add(duo, papers);
        //把填空题加到试卷集合中
        add(tk, papers);


        //定义sql
        String sql = "insert into " + paperName + "(subject, type, title, tk, choiceA, choiceB, choiceC, choiceD, difficulty,result) values (?,?,?,?,?,?,?,?,?,?)";

        //执行sql对象
        PreparedStatement ps = connection.prepareStatement(sql);

        for (Paper p : papers) {
            ps.setString(1, p.getSubject());
            ps.setString(2, p.getType());
            ps.setString(3, p.getTitle());
            ps.setString(4, p.getTk());
            ps.setString(5, p.getChoiceA());
            ps.setString(6, p.getChoiceB());
            ps.setString(7, p.getChoiceC());
            ps.setString(8, p.getChoiceD());
            ps.setString(9, p.getDifficulty());
            ps.setString(10,p.getResult());
            ps.execute();
        }
        JDBCUtil.closeAll(questionBank, ps, null);
    }

    public void add(ArrayList<Bank> arr, ArrayList<Paper> papers) {
        Random r = new Random();
        int count = 0;
        //每种题型五题
        while (count < 1) {
            //获取随机数,获取题目
            int i = r.nextInt(arr.size());
            Bank bank = arr.get(i);
            //创建paper对象
            Paper p = new Paper();
            p.setSubject(bank.getSubject());
            p.setType(bank.getType());
            p.setTitle(bank.getTitle());
            p.setTk(bank.getTk());
            p.setChoiceA(bank.getChoiceA());
            p.setChoiceB(bank.getChoiceB());
            p.setChoiceC(bank.getChoiceC());
            p.setChoiceD(bank.getChoiceD());
            p.setDifficulty(bank.getDifficulty());

            //添加对象到集合
            papers.add(p);
            count++;
        }
    }

    @FXML
    void InsertPaperOnAction(ActionEvent event) throws SQLException {

        boolean empty = isEmpty();
        if (!empty) {

            String paperNameText = paperName.getText();
            //连接数据库
            Connection connection = JDBCUtil.getConnection();

            //定义sql
            String sql2 = "insert into paperSource (PaperName) values (?)";

            //先查询试题库中是否有相同的试卷名称
            ResultSet rs = JDBCUtil.SelectAll("PaperSource");

            boolean flag = false;

            while (rs.next()) {
                if (rs.getString("PaperName").equals(paperName.getText())) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }

            boolean isCertain = false;
            if (!flag) {
                String sql3 = "create table " + paperName.getText() + "(\n" +
                        "    id int primary key auto_increment comment '题号',\n" +
                        "    subject varchar(200) comment '科目',\n" +
                        "    type varchar(20) comment '题目类型',\n" +
                        "    title varchar(2000) comment '题目',\n" +
                        "    tk varchar(500) comment '填空',\n" +
                        "    choiceA varchar(500) comment 'A选项',\n" +
                        "    choiceB varchar(500) comment 'B选项' ,\n" +
                        "    choiceC varchar(500) comment 'C选项',\n" +
                        "    choiceD varchar(500) comment 'D选项',\n" +
                        "    difficulty varchar(20) comment '难度',\n" +
                        "    result varchar(500) comment '答案' \n" +
                        ")comment '试卷';";
                PreparedStatement ps3 = connection.prepareStatement(sql3);
                ps3.execute();
                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setString(1, paperNameText);
                ps2.execute();
                InsertPaper(connection, paperNameText);
                ps3.close();
                ps2.close();
                isCertain = true;
            }

            //关闭资源
            JDBCUtil.closeAll(rs, null, connection);

            //显示成功句子
            if (isCertain) {
                success.setVisible(true);
            }
        }else {
            fail.setVisible(true);
        }
    }

    @FXML
    void ReturnOnAction(ActionEvent event) {
        Stage stage = (Stage) Return.getScene().getWindow();
        stage.close();
    }

    boolean isEmpty(){
        boolean flag = paperName.getText() == null && subject.getText() == null;
        return flag;
    }

}

