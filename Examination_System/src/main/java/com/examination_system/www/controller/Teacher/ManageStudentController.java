package com.examination_system.www.controller.Teacher;

import com.examination_system.www.controller.MenuApplication;
import com.examination_system.www.po.Student;
import com.examination_system.www.service.ManageStudentService;
import com.examination_system.www.util.JDBCUtil;
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

public class ManageStudentController {

        @FXML
        private TableColumn<Student, String> id;

        @FXML
        private TableColumn<Student, String> name;

        @FXML
        private TableColumn<Student, String> sex;

        @FXML
        private TableColumn<Student, String> team;

        @FXML
        private Button ModifyStudent;

        @FXML
        private Button DeleteStudent;

        @FXML
        private Button Exit;

        @FXML
        private TableView<Student> table;
        @FXML
        private Button QueryExam;

        public static List<Student> students = new ArrayList<>();

        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("ManageStudent.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 656, 664);
            stage.setTitle("学生信息");
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        private void initialize() throws SQLException {
            getData();
        }

        private void getData() throws SQLException {
            List<Student> students = ManageStudentService.GetData();

            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
            team.setCellValueFactory(new PropertyValueFactory<>("team"));

            //向表中添加数据
            table.setItems(FXCollections.observableList(students));
        }

        @FXML
        void DeleteStudentOnAction(ActionEvent event) throws SQLException {
            Student stu =  table.getSelectionModel().getSelectedItem();
            //将选中的学生对象添加至集合
            students.add(stu);
            if (stu != null){
                JDBCUtil.DeleteAll("student",stu.getId());
                JDBCUtil.DeleteAll("ExamInfo",stu.getId());
                getData();
            }
        }

        @FXML
        void ExitOnAction(ActionEvent event) {
            Stage stage = (Stage) Exit.getScene().getWindow();
            stage.close();
        }

        @FXML
        void ModifyStudentOnAction(ActionEvent event) {
            Student stu =  table.getSelectionModel().getSelectedItem();
            //将选中的学生对象添加至集合
            students.add(stu);
            ModifyStudent.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    URL url = getClass().getResource("ModifyStudent.fxml");
                    Parent root = null;
                    try{
                        root = FXMLLoader.load(url);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("修改学生信息");
                    stage.initStyle(StageStyle.DECORATED);//可以移动
                    stage.setScene(scene);
                    stage.show();//展示
                }
            });
        }

        @FXML
        void QueryExamOnAction(ActionEvent event) {
            Student selectedItem = table.getSelectionModel().getSelectedItem();
            students.add(selectedItem);
            QueryExam.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    URL url = getClass().getResource("ExamManage.fxml");
                    Parent root = null;
                    try{
                        root = FXMLLoader.load(url);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("学生考试安排");
                    stage.initStyle(StageStyle.DECORATED);//可以移动
                    stage.setScene(scene);
                    stage.show();//展示
                }
            });
        }
}
