package com.examination_system.www.controller.Student;

import com.examination_system.www.dao.Check;
import com.examination_system.www.po.AnswerPaper;
import com.examination_system.www.po.ExamInfo;
import com.examination_system.www.po.Paper;
import com.examination_system.www.service.ExamService;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryController {
    @FXML
    private AnchorPane page;
    @FXML
    private Button admit;
    @FXML
    private RadioButton OptionA;
    @FXML
    private RadioButton OptionB;
    @FXML
    private RadioButton OptionC;
    @FXML
    private RadioButton OptionD;
    @FXML
    private TextField tkAnswer;
    private int currentQuestion;

    List<ExamInfo> names = new ArrayList<>();

    List<AnswerPaper> answerPaperList = new ArrayList<>();

    List<Paper> papers = new ArrayList<>();

    ToggleGroup choice = new ToggleGroup();

    AnchorPane root = new AnchorPane();

    public void start(Stage stage) throws IOException, SQLException {

        CreateQuestion();
        Scene scene = new Scene(root);
        stage.setTitle("欢迎使用考试系统");
        stage.setScene(scene);
        stage.show();
    }

    private void CreateQuestion() throws SQLException {
        //获取选中的对象
        names =  ExamInfoController.names;
        ExamInfo examInfo = names.get(names.size() - 1);
        //获取考生答案
        answerPaperList = ExamService.getAnswer();
        AnswerPaper answerPaper = answerPaperList.get(currentQuestion);
        //获取试卷名字和考试状态
        String paperName = examInfo.getPaperName();

            //获取题目信息
            papers = Check.checkPaper(paperName);
            Paper paper = papers.get(this.currentQuestion);

            page = new AnchorPane();
            page.setPrefHeight(400);
            page.setPrefWidth(500);
            //设置按钮
            admit = new Button("下一题");
            admit.setPrefHeight(40);
            admit.setPrefWidth(75);
            admit.setFont(Font.font(15));
            admit.setLayoutX(60);
            admit.setLayoutY(300);
            page.getChildren().addAll(admit);

            //题型
            Label t1 = new Label();
            t1.setFont(Font.font(20));
            t1.setLayoutX(60);
            t1.setLayoutY(0);
            t1.setText(paper.getId() + "." + paper.getType());

            //题目
            TextArea textArea = new TextArea();
            textArea.setText(paper.getTitle());
            textArea.setFont(Font.font(20));
            textArea.setPrefHeight(60);
            textArea.setPrefWidth(400);
            textArea.setLayoutX(60);
            textArea.setLayoutY(40);
            textArea.setDisable(true);

            page.getChildren().addAll(t1, textArea);
//            判断题目类型输出答题形式
            if (paper.getType().equals("填空题")) {
                tkAnswer = new TextField();
                tkAnswer.setLayoutX(60);
                tkAnswer.setLayoutY(200);
                tkAnswer.setPrefHeight(50);
                tkAnswer.setPrefWidth(300);
                tkAnswer.setText(answerPaper.getStudentAnswer());
                tkAnswer.setDisable(true);
                tkAnswer.setFont(Font.font(20));
                page.getChildren().addAll(tkAnswer);
            } else if (paper.getType().equals("单选题")) {
                //设置按钮
                OptionA = new RadioButton("A." + paper.getChoiceA());
                OptionB = new RadioButton("B." + paper.getChoiceB());
                OptionC = new RadioButton("C." + paper.getChoiceC());
                OptionD = new RadioButton("D." + paper.getChoiceD());
                //分组
                choice = new ToggleGroup();
                OptionA.setToggleGroup(choice);
                OptionB.setToggleGroup(choice);
                OptionC.setToggleGroup(choice);
                OptionD.setToggleGroup(choice);
                //字体大小
                OptionA.setFont(Font.font(20));
                OptionB.setFont(Font.font(20));
                OptionC.setFont(Font.font(20));
                OptionD.setFont(Font.font(20));
                //位置
                OptionA.setLayoutX(60);
                OptionA.setLayoutY(200);
                OptionB.setLayoutX(60 + 100);
                OptionB.setLayoutY(200);
                OptionC.setLayoutX(60 + 200);
                OptionC.setLayoutY(200);
                OptionD.setLayoutX(60 + 300);
                OptionD.setLayoutY(200);
                //设置哪个按钮被选
                tkAnswer = new TextField();
                tkAnswer.setLayoutX(60);
                tkAnswer.setLayoutY(140);
                tkAnswer.setPrefHeight(50);
                tkAnswer.setPrefWidth(300);
                tkAnswer.setText(answerPaper.getStudentAnswer());
                tkAnswer.setDisable(true);
                tkAnswer.setFont(Font.font(20));

                page.getChildren().addAll(OptionA, OptionB, OptionC, OptionD,tkAnswer);
            } else {
                //设置按钮
                OptionA = new RadioButton("A." + paper.getChoiceA());
                OptionB = new RadioButton("B." + paper.getChoiceB());
                OptionC = new RadioButton("C." + paper.getChoiceC());
                OptionD = new RadioButton("D." + paper.getChoiceD());
                //字体大小
                OptionA.setFont(Font.font(20));
                OptionB.setFont(Font.font(20));
                OptionC.setFont(Font.font(20));
                OptionD.setFont(Font.font(20));
                //位置
                OptionA.setLayoutX(60);
                OptionA.setLayoutY(200);
                OptionB.setLayoutX(60 + 100);
                OptionB.setLayoutY(200);
                OptionC.setLayoutX(60 + 200);
                OptionC.setLayoutY(200);
                OptionD.setLayoutX(60 + 300);
                OptionD.setLayoutY(200);
                tkAnswer = new TextField();
                tkAnswer.setLayoutX(60);
                tkAnswer.setLayoutY(140);
                tkAnswer.setPrefHeight(50);
                tkAnswer.setPrefWidth(300);
                tkAnswer.setText(answerPaper.getStudentAnswer());
                tkAnswer.setDisable(true);
                tkAnswer.setFont(Font.font(20));
                page.getChildren().addAll(tkAnswer);
                page.getChildren().addAll(OptionA, OptionB, OptionC, OptionD,tkAnswer);
            }
            admit.setOnAction(event  -> {
                try {
                    SureAnswer();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            });
        root.getChildren().addAll(page);
        }

    @FXML
    void SureAnswer() throws SQLException {
        if (currentQuestion < papers.size()-1){
            this.currentQuestion++;
            updateQuestion();
        }else {
            AnchorPane ap = new AnchorPane();
            root.getChildren().removeAll(root.getChildren());
            ap.setPrefWidth(200);
            ap.setPrefHeight(100);
            Label label = new Label();
            label.setText("您已查看全部答题情况!");
            label.setFont(Font.font(30));
            label.setLayoutX(100);
            label.setLayoutY(100);

            ap.getChildren().add(label);
            root.getChildren().addAll(ap);
        }
    }

    private void updateQuestion() throws SQLException {
        AnchorPane ap = new AnchorPane();

        root.getChildren().removeAll(root.getChildren());

        ap.setPrefWidth(500);
        ap.setPrefHeight(400);
        //获取选中的对象
        names =  ExamInfoController.names;
        ExamInfo examInfo = names.get(names.size() - 1);
        //获取试卷名字和考试状态
        String paperName = examInfo.getPaperName();
        //获取考生答案
        answerPaperList = ExamService.getAnswer();
        AnswerPaper answerPaper = answerPaperList.get(currentQuestion);

        papers = Check.checkPaper(paperName);
        Paper paper = papers.get(this.currentQuestion);

        //题型
        Label t1 = new Label();
        t1.setFont(Font.font(20));
        t1.setLayoutX(60);
        t1.setLayoutY(0);
        t1.setText(paper.getId() + "." + paper.getType());

        //题目
        TextArea textArea = new TextArea();
        textArea.setText(paper.getTitle());
        textArea.setFont(Font.font(20));
        textArea.setPrefHeight(60);
        textArea.setPrefWidth(400);
        textArea.setLayoutX(60);
        textArea.setLayoutY(40);
        textArea.setDisable(true);

        //按钮
        admit = new Button("下一题");
        admit.setPrefHeight(40);
        admit.setPrefWidth(75);
        admit.setFont(Font.font(15));
        admit.setLayoutX(60);
        admit.setLayoutY(300);
        ap.getChildren().add(admit);

        ap.getChildren().addAll(t1,textArea);

//            判断题目类型输出答题形式
        if (paper.getType().equals("填空题")){
            tkAnswer = new TextField();
            tkAnswer.setPrefHeight(50);
            tkAnswer.setPrefWidth(300);
            tkAnswer.setLayoutY(200);
            tkAnswer.setLayoutX(60);
            tkAnswer.setText(answerPaper.getStudentAnswer());
            tkAnswer.setDisable(true);
            tkAnswer.setFont(Font.font(20));
            ap.getChildren().addAll(tkAnswer);
        }else if (paper.getType().equals("单选题")) {
            //设置按钮
            OptionA = new RadioButton("A." + paper.getChoiceA());
            OptionB = new RadioButton("B." + paper.getChoiceB());
            OptionC = new RadioButton("C." + paper.getChoiceC());
            OptionD = new RadioButton("D." + paper.getChoiceD());
            //分组
            choice = new ToggleGroup();
            OptionA.setToggleGroup(choice);
            OptionB.setToggleGroup(choice);
            OptionC.setToggleGroup(choice);
            OptionD.setToggleGroup(choice);
            //字体大小
            OptionA.setFont(Font.font(20));
            OptionB.setFont(Font.font(20));
            OptionC.setFont(Font.font(20));
            OptionD.setFont(Font.font(20));
            //位置
            OptionA.setLayoutX(60);
            OptionA.setLayoutY(200);
            OptionB.setLayoutX(60 + 100);
            OptionB.setLayoutY(200);
            OptionC.setLayoutX(60 + 200);
            OptionC.setLayoutY(200);
            OptionD.setLayoutX(60 + 300);
            OptionD.setLayoutY(200);
            tkAnswer = new TextField();
            tkAnswer.setLayoutX(60);
            tkAnswer.setLayoutY(140);
            tkAnswer.setPrefHeight(50);
            tkAnswer.setPrefWidth(300);
            tkAnswer.setText(answerPaper.getStudentAnswer());
            tkAnswer.setDisable(true);
            tkAnswer.setFont(Font.font(20));
            ap.getChildren().addAll(OptionA,OptionB,OptionC,OptionD,tkAnswer);
        } else {
            //设置按钮
            OptionA = new RadioButton("A." + paper.getChoiceA());
            OptionB = new RadioButton("B." + paper.getChoiceB());
            OptionC = new RadioButton("C." + paper.getChoiceC());
            OptionD = new RadioButton("D." + paper.getChoiceD());
            //字体大小
            OptionA.setFont(Font.font(20));
            OptionB.setFont(Font.font(20));
            OptionC.setFont(Font.font(20));
            OptionD.setFont(Font.font(20));
            //位置
            OptionA.setLayoutX(60);
            OptionA.setLayoutY(200);
            OptionB.setLayoutX(60 + 100);
            OptionB.setLayoutY(200);
            OptionC.setLayoutX(60 + 200);
            OptionC.setLayoutY(200);
            OptionD.setLayoutX(60 + 300);
            OptionD.setLayoutY(200);
            tkAnswer = new TextField();
            tkAnswer.setLayoutX(60);
            tkAnswer.setLayoutY(140);
            tkAnswer.setPrefHeight(50);
            tkAnswer.setPrefWidth(300);
            tkAnswer.setText(answerPaper.getStudentAnswer());
            tkAnswer.setDisable(true);
            tkAnswer.setFont(Font.font(20));
            ap.getChildren().addAll(OptionA,OptionB,OptionC,OptionD,tkAnswer);
        }

        admit.setOnAction(event  -> {
            try {
                SureAnswer();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        root.getChildren().addAll(ap);
    }
}
