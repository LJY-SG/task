package com.examination_system.www.controller.Teacher;

import com.examination_system.www.dao.Insert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.SQLException;

public class EnterExamController {

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

        Insert.InsertExamInfo(d,nameText,addressText,timeText,paperNameText,subjectText);
        success.setVisible(true);
    }
}

