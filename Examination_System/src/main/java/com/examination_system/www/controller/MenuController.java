package com.examination_system.www.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button Register;

    @FXML
    private Button Login;

    @FXML
    private Button Exit;

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("欢迎来到考试系统!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ExitOnAction(ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void LoginOnAction(ActionEvent event) {
        Platform.runLater(() -> {
            //获取按钮所在窗口
            Stage primaryStage = (Stage) Login.getScene().getWindow();
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
    void RegisterOnAction(ActionEvent event) {
        Platform.runLater(() -> {
            //获取按钮所在窗口
            Stage primaryStage = (Stage) Register.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载目标窗口
            try{
                new RegisterController().start(primaryStage);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}

