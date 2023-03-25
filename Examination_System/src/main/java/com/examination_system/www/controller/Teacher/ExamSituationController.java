package com.examination_system.www.controller.Teacher;

import com.examination_system.www.controller.MenuApplication;
import com.examination_system.www.dao.Calculate;
import com.examination_system.www.dao.Check;
import com.examination_system.www.po.PaperSource;
import com.examination_system.www.po.Student;
import com.examination_system.www.service.ManageStudentService;
import com.examination_system.www.service.PaperSourceService;
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

public class ExamSituationController {
        @FXML
        private TableView<Student> table;
        @FXML
        private TableColumn<?, ?> id;

        @FXML
        private TableColumn<?, ?> name;

        @FXML
        private TableColumn<?, ?> chinese;

        @FXML
        private TableColumn<?, ?> math;

        @FXML
        private TableColumn<?, ?> english;

        @FXML
        private Button Enter;

        @FXML
        private Button ModifyMark;

        @FXML
        private Button Exit;

        @FXML
        private TableColumn<?, ?> team;
        @FXML
        private Label average1;

        @FXML
        private Label average3;

        @FXML
        private Label average2;

        public static List<Student> students = new ArrayList<>();

        @FXML
        private void initialize() throws SQLException {
            getData();
        }

        private void getData() throws SQLException {
            List<Student> studentList = ManageStudentService.GetData();

            average1.setText("语文平均分:" + String.format("%.2f", Calculate.AverageChinese()));
            average2.setText("数学平均分:" + String.format("%.2f",Calculate.AverageMath()));
            average3.setText("英语平均分:" + String.format("%.2f", Calculate.AverageEnglish()));
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            team.setCellValueFactory(new PropertyValueFactory<>("team"));
            chinese.setCellValueFactory(new PropertyValueFactory<>("chinese"));
            math.setCellValueFactory(new PropertyValueFactory<>("math"));
            english.setCellValueFactory(new PropertyValueFactory<>("english"));

            //向表中添加数据
            table.setItems(FXCollections.observableList(studentList));
        }

        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("Teacher/ExamSituation.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("考试情况");
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        void EnterOnAction(ActionEvent event) {
            Student selectedItem = table.getSelectionModel().getSelectedItem();
            students.add(selectedItem);

            Enter.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    URL url = getClass().getResource("EnterMark.fxml");
                    Parent root = null;
                    try{
                        root = FXMLLoader.load(url);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("录入成绩");
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
}
