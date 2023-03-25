package com.examination_system.www.controller.Student;

import com.examination_system.www.dao.Calculate;
import com.examination_system.www.dao.Check;
import com.examination_system.www.po.Student;
import com.examination_system.www.util.JDBCUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExamSituationController {

    @FXML
    private Label name;

    @FXML
    private Label id;

    @FXML
    private Label chinese;

    @FXML
    private Label math;

    @FXML
    private Label english;

    @FXML
    private Label Sum;

    @FXML
    private Button Return;

    @FXML
    private void initialize() throws SQLException {
        int sum = Calculate.GetSum();
        Student student = Check.CheckStudent();
        name.setText(student.getName());
        id.setText(String.valueOf(student.getId()));
        chinese.setText(String.valueOf(student.getChinese()));
        math.setText(String.valueOf(student.getMath()));
        english.setText(String.valueOf(student.getEnglish()));
        Sum.setText(String.valueOf(sum));
    }

    @FXML
    void ReturnOnAction(ActionEvent event) {
        Stage stage = (Stage) Return.getScene().getWindow();
        stage.close();
    }

}

