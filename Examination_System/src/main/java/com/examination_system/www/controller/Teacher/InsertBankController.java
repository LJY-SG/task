package com.examination_system.www.controller.Teacher;

import com.examination_system.www.service.InsertBankService;
import com.examination_system.www.service.InsertStudentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InsertBankController {
        @FXML
        private TextField subject;

        @FXML
        private ChoiceBox<String> choiceType;

        @FXML
        private TextArea title;

        @FXML
        private Label choiceA;

        @FXML
        private TextField a;

        @FXML
        private Label choiceD;

        @FXML
        private Label choiceC;

        @FXML
        private Label choiceB;

        @FXML
        private TextField d;

        @FXML
        private TextField c;

        @FXML
        private TextField b;

        @FXML
        private ChoiceBox<String> difficulty;

        @FXML
        private TextField result;

        @FXML
        private Button Add;

        @FXML
        private Label success;

        @FXML
        private Button Exit;

        @FXML
        private void initialize(){
            choiceType.getItems().addAll("单选题","多选题","填空题");
            difficulty.getItems().addAll("*","**","***","****","*****");
        }

        @FXML
        void AddOnAction(ActionEvent event) {
            //获取输入框的值
            String subjectText = subject.getText();
            String typeValue = choiceType.getValue();
            String titleText = title.getText();
            String aText = a.getText();
            String bText = b.getText();
            String cText = c.getText();
            String dText = d.getText();
            String difficultyValue = difficulty.getValue();
            String resultText = result.getText();

            //判断是否为空
            boolean empty = isEmpty();
            if (!empty) {
                InsertBankService.InsertIntoBank(subjectText, typeValue, titleText, aText, bText, cText, dText, difficultyValue, resultText);
                success.setVisible(true);

            }
        }

        @FXML
        void ExitOnAction(ActionEvent event) {
            Stage stage = (Stage) Exit.getScene().getWindow();
            stage.close();
        }

    boolean isEmpty(){
        return subject.getText() == null || choiceType.getValue() == null || title.getText() == null || a.getText() == null || b.getText() == null || c.getText() == null || d.getText() == null || difficulty.getValue() == null || result.getText() == null;
    }
}
