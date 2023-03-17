package Controller;


import Utils.JDBCUtil;
import domain.bank;
import domain.exam;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class ExamController {

    @FXML
    private TableColumn<?, ?> time;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> address;

    @FXML
    private TableColumn<?, ?> subject;

    @FXML
    private TableColumn<?, ?> PaperName;

    @FXML
    private Button InsertExam;

    @FXML
    private Button DeleteExam;

    @FXML
    private Button ModifyExam;

    @FXML
    private Button Return;

    @FXML
    private TableView<exam> table;

    @FXML
    private void initialize() throws SQLException {
        getData();
    }

    private void getData() throws SQLException {
        List<exam> exams = JDBCUtil.checkExam();
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        PaperName.setCellValueFactory(new PropertyValueFactory<>("PaperName"));

        //向表中添加数据
        table.setItems(FXCollections.observableList(exams));
    }

    @FXML
    void DeleteExamOnAction(ActionEvent event) throws SQLException {
        exam exam =  table.getSelectionModel().getSelectedItem();
        if (exam != null){
            JDBCUtil.Delete("exam", exam.getName());
            getData();
        }
    }

    @FXML
    void InsertExamOnAction(ActionEvent event) {
        InsertExam.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
//                MenuApplication.changeView("menu.fxml");
                URL url = getClass().getResource("InsertExam.fxml");//得到压缩器界面的url
                Parent root = null;
                try {
                    root = FXMLLoader.load(url);//加载
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 700, 600);//建立一个与初始化界面一样大的界面
                Stage stage = new Stage();
                stage.setTitle("添加考试表内容");
                stage.initStyle(StageStyle.DECORATED);//该画面不能移动
                stage.setScene(scene);
                stage.show();//展示
            }
        });

    }

    @FXML
    void ModifyExamOnAction(ActionEvent event) {
        ModifyExam.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
//                MenuApplication.changeView("menu.fxml");
                URL url = getClass().getResource("ModifyExam.fxml");//得到压缩器界面的url
                Parent root = null;
                try {
                    root = FXMLLoader.load(url);//加载
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 700, 600);//建立一个与初始化界面一样大的界面
                Stage stage = new Stage();
                stage.setTitle("修改考试表内容");
                stage.initStyle(StageStyle.DECORATED);//该画面不能移动
                stage.setScene(scene);
                stage.show();//展示
            }
        });
    }

    @FXML
    void ReturnOnAction(ActionEvent event) {
        Platform.runLater(() -> {
            //获取按钮所在窗口
            Stage primaryStage = (Stage) Return.getScene().getWindow();
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

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("exam.fxml"));
        Scene scene = new Scene(root, 1000, 800);//建立一个与初始化界面一样大的界面
//        primaryStage.initStyle(StageStyle.DECORATED);//该画面不能移动
        primaryStage.setScene(scene);
        primaryStage.show();//展示
    }
}
