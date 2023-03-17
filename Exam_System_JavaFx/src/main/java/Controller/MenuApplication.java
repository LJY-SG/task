package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public class MenuApplication extends Application {
    private static Stage stage;
    @Override
    public void start(Stage stage) {
                MenuApplication.stage = stage;
                URL url = getClass().getResource("Menu.fxml");//得到压缩器界面的url
                Parent root = null;
                try {
                    root = FXMLLoader.load(url);//加载
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 1000, 800);//建立一个与初始化界面一样大的界面
                stage.setTitle("试题管理系统");
                stage.initStyle(StageStyle.DECORATED);//该画面不能移动
                stage.setScene(scene);
                stage.show();
    }

//    public static void changeView(String fxml)  {
//        Parent root;
//        try {
//            root = FXMLLoader.load((MenuApplication.class.getResource(fxml)));
//            stage.setScene(new Scene(root));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//    public static Initializable replaceSceneContent(String fxml) throws Exception {
//        FXMLLoader loader = new FXMLLoader();
//        InputStream in = MenuApplication.class.getResourceAsStream(fxml);
//        loader.setBuilderFactory(new JavaFXBuilderFactory());
//        loader.setLocation(MenuApplication.class.getResource(fxml));
//        AnchorPane page;
//        try {
//            page = (AnchorPane) loader.load(in);
//        } finally {
//            in.close();
//        }
//        Scene scene = new Scene(page, 800, 600);
//        stage.setScene(scene);
//        stage.sizeToScene();
//        return (Initializable) loader.getController();
//    }


    public static void main(String[] args) {
        launch(args);
    }
}