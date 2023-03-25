package com.examination_system.www.controller.Student;

import com.examination_system.www.dao.Check;
import com.examination_system.www.po.ExamInfo;
import com.examination_system.www.po.Paper;
import com.examination_system.www.util.JDBCUtil;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamInfoController {

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
    private TableColumn<?, ?> paperName;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    private Button Begin;

    @FXML
    private Button Exit;

    @FXML
    private Button Query;

    @FXML
    private TableView<ExamInfo> table;

    private RadioButton r1 = new RadioButton();
    private RadioButton r2 = new RadioButton();
    private RadioButton r3 = new RadioButton();
    private RadioButton r4 = new RadioButton();

    private Button NextPage = new Button();
    private Button Admit = new Button();
    private Button AgoPage = new Button();

    private TextField field = new TextField();

    public static List<ExamInfo> names = new ArrayList<>();

    private int i = 0;

    AnchorPane page = new AnchorPane();

    AnchorPane root = new AnchorPane();

    @FXML
    private void initialize() throws SQLException {
        getData();
    }

    private void getData() throws SQLException {
        List<ExamInfo> examInfoList = Check.GetExamInfoData();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        paperName.setCellValueFactory(new PropertyValueFactory<>("paperName"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        //向表中添加数据
        table.setItems(FXCollections.observableList(examInfoList));
    }

    @FXML
    void BeginOnAction(ActionEvent event) throws SQLException {
        ExamInfo selectedItem = table.getSelectionModel().getSelectedItem();
        String selectedItemPaperName = selectedItem.getPaperName();
        names.add(selectedItem);
        String selectedItemStatus = selectedItem.getStatus();

        if (selectedItemStatus.equals("未考")){
            Platform.runLater(() -> {
                //获取按钮所在窗口
                Stage primaryStage = (Stage) Begin.getScene().getWindow();
                //当前窗口隐藏
                primaryStage.hide();
                //加载目标窗口
                try{
                    new ExamController().start(primaryStage);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
    }

        @FXML
        void ExitOnAction (ActionEvent event){
            Stage stage = (Stage) Exit.getScene().getWindow();
            stage.close();
        }

        @FXML
        void QueryOnAction (ActionEvent event){
            ExamInfo selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem.getStatus().equals("已考")) {
                names.add(selectedItem);
                //输出到界面
                Platform.runLater(() -> {
                    //获取按钮所在窗口
                    Stage primaryStage = (Stage) Query.getScene().getWindow();
                    //当前窗口隐藏
                    primaryStage.hide();
                    //加载目标窗口
                    try{
                        new QueryController().start(primaryStage);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                });
            }
        }

        @FXML
        void startPaper (Stage primaryStage) throws Exception {
            AnchorPane ap = new AnchorPane();

            TextArea textArea = new TextArea();
            ap.getChildren().addAll(textArea);
            textArea.setText(Check.GetPaperData());//设置一个初始值
            textArea.setFont(Font.font(20));//字体大小
            textArea.setWrapText(true);//是否自动换行
            textArea.setPrefHeight(800);
            textArea.setPrefWidth(1000);

            Scene scene = new Scene(ap);

            primaryStage.setScene(scene);
            primaryStage.setTitle("查看试卷");
            primaryStage.setWidth(1000);
            primaryStage.setHeight(800);
            primaryStage.show();

            //左右滚动监听
            textArea.scrollLeftProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    System.out.println("左右移动" + newValue);
                }
            });
        }

    }


