package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class MenuController {

    @FXML
    private Button Bank;

    @FXML
    private Button Paper;

    @FXML
    private Button exam;

    @FXML
    void BankOnAction(ActionEvent event) {
        Bank.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                URL url = getClass().getResource("Bank.fxml");//得到压缩器界面的url
                Parent root = null;
                try {
                    root = FXMLLoader.load(url);//加载
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 1000, 800);//建立一个与初始化界面一样大的界面
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);//该画面不能移动
                stage.setScene(scene);
                stage.show();//展示
            }
        });
    }

    @FXML
    void PaperOnAction(ActionEvent event) {
        Paper.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                URL url = getClass().getResource("PaperSource.fxml");//得到压缩器界面的url
                Parent root = null;
                try {
                    root = FXMLLoader.load(url);//加载
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 621, 438);//建立一个与初始化界面一样大的界面
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                stage.setScene(scene);
                stage.show();//展示
            }
        });
}

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root, 1000, 800);//建立一个与初始化界面一样大的界面
//        primaryStage.initStyle(StageStyle.DECORATED);//该画面不能移动
        primaryStage.setScene(scene);
        primaryStage.show();//展示
    }

    @FXML
    void examOnAction(ActionEvent event) {
        exam.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                URL url = getClass().getResource("exam.fxml");//得到压缩器界面的url
                Parent root = null;
                try {
                    root = FXMLLoader.load(url);//加载
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 1000, 800);//建立一个与初始化界面一样大的界面
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);//该画面不能移动
                stage.setScene(scene);
                stage.show();//展示
            }
        });

    }

}