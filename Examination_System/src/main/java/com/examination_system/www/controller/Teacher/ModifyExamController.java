package com.examination_system.www.controller.Teacher;

import com.examination_system.www.dao.Modify;
import com.examination_system.www.po.ExamInfo;
import com.examination_system.www.po.Paper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class ModifyExamController {

    @FXML
    private TextField time;

    @FXML
    private TextField address;

    @FXML
    private TextField subject;

    @FXML
    private TextField PaperName;

    @FXML
    private Button Sure;

    @FXML
    private Button Exit;

    @FXML
    private TextField name;

    @FXML
    private TextField id;

    @FXML
    private Label success;

    @FXML
    private void initialize() throws SQLException {
        //获取选中的学生信息
        List<ExamInfo> list = ExamManageController.examInfos;
        ExamInfo examInfo = list.get(list.size() - 1);
        subject.setText(examInfo.getSubject());
        name.setText(examInfo.getName());
        address.setText(examInfo.getAddress());
        id.setText(String.valueOf(examInfo.getId()));
        PaperName.setText(examInfo.getPaperName());
        time.setText(examInfo.getTime().toString());
    }

    @FXML
    void ExitOnAction(ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void SureOnAction(ActionEvent event) throws SQLException {
        //获取输入框数据
        String idText = id.getText();
        Integer i = Integer.valueOf(idText);
        int d = i.intValue();
        String nameText = name.getText();
        String timeText = time.getText();
        String addressText = address.getText();
        String paperNameText = PaperName.getText();
        String subjectText = subject.getText();

        Modify.ModifyExam(d,nameText,addressText,timeText,subjectText,paperNameText);
        success.setVisible(true);
    }

}

