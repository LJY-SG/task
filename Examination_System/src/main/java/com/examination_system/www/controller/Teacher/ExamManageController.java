package com.examination_system.www.controller.Teacher;

import com.examination_system.www.controller.Student.ExamInfoController;
import com.examination_system.www.controller.Student.QueryController;
import com.examination_system.www.dao.Check;
import com.examination_system.www.po.ExamInfo;
import com.examination_system.www.po.Student;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamManageController {

    @FXML
    private TableView<ExamInfo> table;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> time;

    @FXML
    private TableColumn<?, ?> address;

    @FXML
    private TableColumn<?, ?> subject;

    @FXML
    private TableColumn<?, ?> PaperName;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    private Button Enter;

    @FXML
    private Button ModifyExam;

    @FXML
    private Button Exit;

    @FXML
    private Button CorrectPaper;

    public static List<ExamInfo> examInfos = new ArrayList<>();

    @FXML
    private void initialize() throws SQLException {
        getData();
    }

    private void getData() throws SQLException {
        List<ExamInfo> examInfoList = Check.CheckExamInfo();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        PaperName.setCellValueFactory(new PropertyValueFactory<>("paperName"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        //向表中添加数据
        table.setItems(FXCollections.observableList(examInfoList));
    }

    @FXML
    void CorrectPaperOnAction(ActionEvent event) {
        //获取被选学生信息
        ExamInfo selectedItem = table.getSelectionModel().getSelectedItem();
        examInfos.add(selectedItem);
        if (selectedItem.getStatus().equals("已考")) {
            //输出到界面
            Platform.runLater(() -> {
                //获取按钮所在窗口
                Stage primaryStage = (Stage) CorrectPaper.getScene().getWindow();
                //当前窗口隐藏
                primaryStage.hide();
                //加载目标窗口
                try {
                    new CorrectController().start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @FXML
    void EnterOnAction(ActionEvent event) {
        ExamInfo selectedItem = table.getSelectionModel().getSelectedItem();
        examInfos.add(selectedItem);

        Enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                URL url = getClass().getResource("EnterExam.fxml");
                Parent root = null;
                try{
                    root = FXMLLoader.load(url);
                }catch (IOException e){
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("录入考试信息");
                stage.initStyle(StageStyle.DECORATED);//可以移动
                stage.setScene(scene);
                stage.show();//展示
            }
        });
    }

    @FXML
    void ExitOnAction(ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void ModifyExamOnAction(ActionEvent event) {
        ExamInfo selectedItem = table.getSelectionModel().getSelectedItem();
        examInfos.add(selectedItem);

        ModifyExam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                URL url = getClass().getResource("ModifyExam.fxml");
                Parent root = null;
                try{
                    root = FXMLLoader.load(url);
                }catch (IOException e){
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("修改考试信息");
                stage.initStyle(StageStyle.DECORATED);//可以移动
                stage.setScene(scene);
                stage.show();//展示
            }
        });
    }
}

