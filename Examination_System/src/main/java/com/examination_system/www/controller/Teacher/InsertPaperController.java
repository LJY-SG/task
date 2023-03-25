package com.examination_system.www.controller.Teacher;

import com.examination_system.www.dao.Insert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class InsertPaperController {

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

    @FXML
    void InsertPaperOnAction(ActionEvent event) throws SQLException {
        //获取输入框的值
        String subjectText = subject.getText();
        String paperNameText = paperName.getText();

        boolean b = Insert.InsertPaperSource(subjectText, paperNameText);

        if (!b){
            success.setVisible(true);
        }else {
            fail.setVisible(true);
        }
    }

    @FXML
    void ReturnOnAction(ActionEvent event) {
        Stage stage = (Stage) Return.getScene().getWindow();
        stage.close();
    }

}
