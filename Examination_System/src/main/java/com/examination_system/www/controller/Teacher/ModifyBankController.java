package com.examination_system.www.controller.Teacher;

import com.examination_system.www.dao.Modify;
import com.examination_system.www.po.Bank;
import com.examination_system.www.po.Paper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class ModifyBankController {
        @FXML
        private TextField subject;

        @FXML
        private ChoiceBox<String> choiceType;

        @FXML
        private TextArea title;

        @FXML
        private TextField a;

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
        private Button Sure;

        @FXML
        private Label success;

        @FXML
        private Button Exit;

        @FXML
        private void initialize() throws SQLException {
            choiceType.getItems().addAll("单选题","多选题","填空题");
            difficulty.getItems().addAll("*","**","***","****","*****");
            List<Paper> list = PaperController.paperList;
            Paper paper = list.get(0);
            subject.setText(paper.getSubject());
            choiceType.setValue(paper.getType());
            title.setText(paper.getTitle());
            a.setText(paper.getChoiceA());
            b.setText(paper.getChoiceB());
            c.setText(paper.getChoiceC());
            d.setText(paper.getChoiceD());
            difficulty.setValue(paper.getDifficulty());
            result.setText(paper.getResult());
        }

        @FXML
        void ExitOnAction(ActionEvent event) {
            Stage stage = (Stage) Exit.getScene().getWindow();
            stage.close();
        }

        @FXML
        void SureOnAction(ActionEvent event) throws SQLException {
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

            List<Bank> banks = BankController.banks;
            Bank bank = banks.get(0);
            //将值写入数据库
            Modify.ModifyBank("Bank",subjectText,typeValue,titleText,aText,bText,cText,dText,difficultyValue,resultText,bank.getId());
            success.setVisible(true);
        }

}
