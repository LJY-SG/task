package com.examination_system.www.controller.Teacher;

import com.examination_system.www.controller.MenuApplication;
import com.examination_system.www.po.Bank;
import com.examination_system.www.service.InsertBankService;
import com.examination_system.www.util.JDBCUtil;
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

public class BankController {
        @FXML
        private TableView<Bank> table;

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
        private Button InsertBank;

        @FXML
        private Button ModifyBank;

        @FXML
        private Button Return;

        @FXML
        private Button DeleteBank;

        public static List<Bank> banks = new ArrayList<>();

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("Teacher/Bank.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("试题库");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize() throws SQLException {
        getData();
    }

    private void getData() throws SQLException {
        List<Bank> banks = InsertBankService.check();
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
        table.setItems(FXCollections.observableList(banks));
    }

        @FXML
        void DeleteBankOnAction(ActionEvent event) throws SQLException {
            Bank bank =  table.getSelectionModel().getSelectedItem();
            if (bank != null){
                JDBCUtil.DeleteAll("Bank",bank.getId());
                getData();
            }
        }

        @FXML
        void InsertBankOnAction(ActionEvent event) {
            InsertBank.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    URL url = getClass().getResource("InsertBank.fxml");
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
        void ModifyBankOnAction(ActionEvent event) {
            Bank bank = table.getSelectionModel().getSelectedItem();
            banks.add(bank);
            ModifyBank.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    URL url = getClass().getResource("ModifyBank.fxml");
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
            Stage stage = (Stage) Return.getScene().getWindow();
            stage.close();
        }

}
