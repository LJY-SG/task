package com.examination_system.www.controller.Student;

import com.examination_system.www.controller.LoginController;
import com.examination_system.www.controller.MenuApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class StudentController {

        @FXML
        private Button Information;

        @FXML
        private Button ExamInfo;

        @FXML
        private Button ExamSituation;

        @FXML
        private Button Exit;

        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("Student/Student.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 395, 300);
            stage.setTitle("学生端");
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        void ExamInfoOnAction(ActionEvent event) {
            ExamInfo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    URL url = getClass().getResource("ExamInfo.fxml");
                    Parent root = null;
                    try{
                        root = FXMLLoader.load(url);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("考试信息");
                    stage.initStyle(StageStyle.DECORATED);//可以移动
                    stage.setScene(scene);
                    stage.show();//展示
                }
            });
        }

        @FXML
        void ExamSituationOnAction(ActionEvent event) {
            ExamSituation.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    URL url = getClass().getResource("ExamSituation.fxml");
                    Parent root = null;
                    try{
                        root = FXMLLoader.load(url);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("考试情况");
                    stage.initStyle(StageStyle.DECORATED);//可以移动
                    stage.setScene(scene);
                    stage.show();//展示
                }
            });
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
        void InformationOnAction(ActionEvent event) {
            Information.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    URL url = getClass().getResource("Information.fxml");
                    Parent root = null;
                    try{
                        root = FXMLLoader.load(url);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("个人信息");
                    stage.initStyle(StageStyle.DECORATED);//可以移动
                    stage.setScene(scene);
                    stage.show();//展示
                }
            });
        }

}

