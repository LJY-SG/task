package com.examination_system.www.controller.Teacher;

import com.examination_system.www.controller.MenuApplication;
import com.examination_system.www.dao.Modify;
import com.examination_system.www.po.Student;
import com.examination_system.www.service.RegisterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ModifyStudentController {

        @FXML
        private Button Sure;

        @FXML
        private Button Exit;

        @FXML
        private TextField Name;
        @FXML
        private RadioButton male;

        @FXML
        private ToggleGroup SexGroup;

        @FXML
        private RadioButton female;

        @FXML
        private ChoiceBox<String> choiceClass;

        @FXML
        private Label success;

        @FXML
        private Label fail;

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("ModifyStudent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 498, 550);
        stage.setTitle("个人信息");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize() throws SQLException {
        choiceClass.getItems().addAll("一班","二班","三班");
        for (Student student : ManageStudentController.students) {
            Name.setText(student.getName());
            if (student.getSex().equals("男")){
                male.setSelected(true);
            }else {
                female.setSelected(true);
            }
            choiceClass.setValue(student.getTeam());
        }
    }

        @FXML
        void ExitOnAction(ActionEvent event) {
            Stage stage = (Stage) Exit.getScene().getWindow();
            stage.close();
        }

        @FXML
        void SureOnAction(ActionEvent event) throws SQLException {
            //获取输入的值
            String nameText = Name.getText();
            String classValue = choiceClass.getValue();

            //判断性别
            String judgeSex = RegisterService.JudgeSex(male.isSelected());

            if (isEmpty()) {
                Modify.ModifyStudentInfo(nameText, judgeSex, classValue, "student");
                success.setVisible(true);
            }else {
                fail.setVisible(true);
            }
        }

    boolean isEmpty(){
        boolean flag = false;
        boolean maleSelected = male.isSelected();
        //判断性别
        String judgeSex = RegisterService.JudgeSex(maleSelected);
        if (Name.getText() != null && choiceClass.getValue() != null && judgeSex != null){
            flag = true;
        }
        return flag;
    }

}
