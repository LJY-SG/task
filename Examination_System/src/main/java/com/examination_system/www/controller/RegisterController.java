package com.examination_system.www.controller;

import com.examination_system.www.service.RegisterService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class RegisterController {

    @FXML
    private TextField Name;

    @FXML
    private Label success;

    @FXML
    private Label isRegister;

    @FXML
    private PasswordField PassWord;


    @FXML
    private Button Sure;

    @FXML
    private Button Exit;

    @FXML
    private RadioButton Student;

    @FXML
    private ToggleGroup StatusGroup;

    @FXML
    private RadioButton Teacher;

    @FXML
    private ToggleGroup SexGroup;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("Register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 498, 550);
        stage.setTitle("注册");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ExitOnAction(ActionEvent event) {
        Platform.runLater(() -> {
            //获取按钮所在窗口
            Stage primaryStage = (Stage) Exit.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载目标窗口
            try{
                new MenuController().start(primaryStage);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    @FXML
    void SureOnAction(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
        //设置分组
        this.Teacher.setToggleGroup(StatusGroup);
        this.Student.setToggleGroup(StatusGroup);
        this.male.setToggleGroup(SexGroup);
        this.female.setToggleGroup(SexGroup);

        //获取变量
        String nameText = Name.getText();
        String passWordText = PassWord.getText();
        boolean maleSelected = male.isSelected(); //性别
        boolean studentSelected = Student.isSelected();

        //判断性别
        String sex = RegisterService.JudgeSex(maleSelected);

        //判断身份
        String status = RegisterService.JudgeStatus(studentSelected);

        //判断用户是否已经注册
        boolean register = RegisterService.isRegister(nameText,status);

        if (register){
            isRegister.setVisible(true);
        }else {
            if (status.equals("学生")) {
                RegisterService.Insert("Student", nameText, passWordText, sex);
                success.setVisible(true);
            }else {
                RegisterService.Insert("Teacher", nameText, passWordText, sex);
                success.setVisible(true);
            }
        }
    }
}

