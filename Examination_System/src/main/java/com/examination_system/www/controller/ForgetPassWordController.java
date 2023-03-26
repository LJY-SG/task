package com.examination_system.www.controller;

import com.examination_system.www.service.LoginService;
import com.examination_system.www.service.RegisterService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class ForgetPassWordController {

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Button Sure;

    @FXML
    private Button Exit;

    @FXML
    private Label success;

    @FXML
    private Label fail;

    @FXML
    private RadioButton student;

    @FXML
    private ToggleGroup StatusGroup;

    @FXML
    private RadioButton teacher;

    @FXML
    private Label NoRegister;

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("ForgetPassWord.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("忘记密码");
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
                new LoginController().start(primaryStage);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    @FXML
    void SureOnAction(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
        //获取输入框内容
        String nameText = name.getText();
        String passwordText = password.getText();

        //判断身份
        String judgeStatus = RegisterService.JudgeStatus(student.isSelected());

        //判断用户是否注册
        boolean register = RegisterService.isRegister(nameText, judgeStatus);

        if (register) {
            success.setVisible(true);
            LoginService.ForgetPassWord(nameText, passwordText, judgeStatus);
        }else {
            fail.setVisible(true);
            Platform.runLater(() -> {
                //获取按钮所在窗口
                Stage primaryStage = (Stage) Sure.getScene().getWindow();
                //当前窗口隐藏
                primaryStage.hide();
                //加载目标窗口
                try{
                    new ForgetPassWordController().start(primaryStage);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }

    }

}
