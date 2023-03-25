package com.examination_system.www.controller.Teacher;

import com.examination_system.www.dao.Modify;
import com.examination_system.www.po.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.List;

public class EnterMarkController {
        @FXML
        private Button Sure;

        @FXML
        private TextField name;

        @FXML
        private TextField chinese;

        @FXML
        private TextField math;

        @FXML
        private TextField english;

        @FXML
        private Button Exit;

        @FXML
        private Label success;

        @FXML
        private void initialize() {
            getData();
        }

        private void getData(){
            List<Student> students = ExamSituationController.students;
            Student student = students.get(students.size() -1);

            name.setText(student.getName());
            chinese.setText(transform(student.getChinese()));
            math.setText(transform(student.getMath()));
            english.setText(transform(student.getEnglish()));
        }

        private String transform(int mark){
            return String.valueOf(mark);
        }

        @FXML
        void ExitOnAction(ActionEvent event) {
            Stage stage = (Stage) Exit.getScene().getWindow();
            stage.close();
        }

        private int ToInt(String s){
            Integer i = Integer.valueOf(s);
            return i.intValue();
        }

        @FXML
        void SureOnAction(ActionEvent event) throws SQLException {
            //获取输入框的值
            String nameText = name.getText();
            int c = ToInt(chinese.getText());
            int m = ToInt(math.getText());
            int e = ToInt(english.getText());

            Modify.EnterMark(nameText,c,m,e);
            success.setVisible(true);
        }
}
