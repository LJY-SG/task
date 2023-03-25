package com.examination_system.www.controller;

import com.examination_system.www.controller.Student.StudentController;
import com.examination_system.www.controller.Teacher.TeacherController;
import com.examination_system.www.service.LoginService;
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
import java.util.ArrayList;
import java.util.List;

public class LoginController {
        @FXML
        private TextField name;

        @FXML
        private PasswordField password;

        @FXML
        private Label success;

        @FXML
        private Label fail;

        @FXML
        private Button Login;
        @FXML
        private Button Exit;

        @FXML
        private RadioButton student;

        @FXML
        private ToggleGroup StatusGroup;

        @FXML
        private RadioButton teacher;

        @FXML
        private Label NoRegister;

        public static List<String> arr = new ArrayList<>();

        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("登录");
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
    void LoginOnAction(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
        //设置分组
        student.setToggleGroup(StatusGroup);
        teacher.setToggleGroup(StatusGroup);

        //获取输入框的值
        String nameText = name.getText();
        String passwordText = password.getText();
        boolean studentSelected = student.isSelected();

        //判断身份
        String status = RegisterService.JudgeStatus(studentSelected);

        //判断用户是否已经注册
        boolean register = RegisterService.isRegister(nameText, status);

        //判断密码是否正确
        boolean judgePassWord = LoginService.JudgePassWord(passwordText, status,nameText);

        //如果已经注册判断密码是否正确
        if (register){
            if (judgePassWord) {
                arr.add(nameText);
                //如果已经注册且密码正确,登录成功
                success.setVisible(true);
                //判断是学生，跳转到学生界面
                if (status.equals("学生")){
                    Platform.runLater(() -> {
                        //获取按钮所在窗口
                        Stage primaryStage = (Stage) Login.getScene().getWindow();
                        //当前窗口隐藏
                        primaryStage.hide();
                        //加载目标窗口
                        try{
                            new StudentController().start(primaryStage);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    });
                }else {
                    //判断是老师，跳转到教师界面
                    Platform.runLater(() -> {
                        //获取按钮所在窗口
                        Stage primaryStage = (Stage) Login.getScene().getWindow();
                        //当前窗口隐藏
                        primaryStage.hide();
                        //加载目标窗口
                        try{
                            new TeacherController().start(primaryStage);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    });
                }
            }else {
                //登录失败
                fail.setVisible(true);
            }
        }else {
            NoRegister.setVisible(true);
        }
    }
}
