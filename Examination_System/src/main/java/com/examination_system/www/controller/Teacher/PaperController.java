package com.examination_system.www.controller.Teacher;

import com.examination_system.www.controller.MenuApplication;
import com.examination_system.www.dao.Check;
import com.examination_system.www.po.Paper;
import com.examination_system.www.po.PaperSource;
import com.examination_system.www.util.JDBCUtil;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class PaperController {

    @FXML
    private TableView<Paper> table;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> subject;

    @FXML
    private TableColumn<?, ?> type;

    @FXML
    private TableColumn<?, ?> title;

    @FXML
    private TableColumn<?, ?> tk;

    @FXML
    private TableColumn<?, ?> choiceA;

    @FXML
    private TableColumn<?, ?> choiceB;

    @FXML
    private TableColumn<?, ?> choiceC;

    @FXML
    private TableColumn<?, ?> choiceD;

    @FXML
    private TableColumn<?, ?> difficulty;

    @FXML
    private TableColumn<?, ?> result;

    @FXML
    private Button InsertTitle;

    @FXML
    private Button ModifyTitle;

    @FXML
    private Button Return;

    @FXML
    private Label Name;

    public static List<Paper> paperList = new ArrayList<>();

    @FXML
    private void initialize() throws SQLException {
        getData();
    }

    private void getData() throws SQLException {
        //获取选中的试卷名称
        List<PaperSource> list =  PaperSourceController.paperSources;
        PaperSource paperSource = list.get(list.size()-1);
        String paperName = paperSource.getPaperName();

        Name.setText(paperName);
        List<Paper> papers = Check.checkPaper(paperName);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        tk.setCellValueFactory(new PropertyValueFactory<>("tk"));
        choiceA.setCellValueFactory(new PropertyValueFactory<>("choiceA"));
        choiceB.setCellValueFactory(new PropertyValueFactory<>("choiceB"));
        choiceC.setCellValueFactory(new PropertyValueFactory<>("choiceC"));
        choiceD.setCellValueFactory(new PropertyValueFactory<>("choiceD"));
        difficulty.setCellValueFactory(new PropertyValueFactory<>("difficulty"));
        result.setCellValueFactory(new PropertyValueFactory<>("result"));

        //向表中添加数据
        table.setItems(FXCollections.observableList(papers));
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("Teacher/Paper.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("编辑试卷");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void DeleteTitleOnAction(ActionEvent event) throws SQLException {
        //获取选中的试卷名称
        List<PaperSource> list =  PaperSourceController.paperSources;
        PaperSource paperSource = list.get(0);
        String paperName = paperSource.getPaperName();

        Paper paper = table.getSelectionModel().getSelectedItem();
        //将选中的题目对象添加至集合
        paperList.add(paper);
        if (paperList != null){
            JDBCUtil.DeleteAll(paperName,paper.getId());
            getData();
        }
    }

    @FXML
    void InsertTitleOnAction(ActionEvent event) {
        InsertTitle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                URL url = getClass().getResource("InsertTitle.fxml");
                Parent root = null;
                try{
                    root = FXMLLoader.load(url);
                }catch (IOException e){
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("添加试题");
                stage.initStyle(StageStyle.DECORATED);//可以移动
                stage.setScene(scene);
                stage.show();//展示
            }
        });
    }

    @FXML
    void ModifyTitleOnAction(ActionEvent event) {
        Paper paper = table.getSelectionModel().getSelectedItem();
        paperList.add(paper);
        ModifyTitle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                URL url = getClass().getResource("ModifyTitle.fxml");
                Parent root = null;
                try{
                    root = FXMLLoader.load(url);
                }catch (IOException e){
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("修改试题");
                stage.initStyle(StageStyle.DECORATED);//可以移动
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
                new PaperSourceController().start(primaryStage);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
