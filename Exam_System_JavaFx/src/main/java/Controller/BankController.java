package Controller;

import Utils.JDBCUtil;
import domain.bank;
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

public class BankController {

    @FXML
    private Button InsertBank;

    @FXML
    private Button ModifyBank;

    @FXML
    private Button Return;

    @FXML
    private Button DeleteBank;


    @FXML
    private TableView<bank> table = new TableView<>();


    @FXML
    private TableColumn<bank, String> id;

    @FXML
    private TableColumn<bank, String> subject;

    @FXML
    private TableColumn<bank, String> type;

    @FXML
    private TableColumn<bank, String> title;

    @FXML
    private TableColumn<bank, String> tk;

    @FXML
    private TableColumn<bank, String> choiceA;

    @FXML
    private TableColumn<bank, String> choiceB;

    @FXML
    private TableColumn<bank, String> choiceC;

    @FXML
    private TableColumn<bank, String> choiceD;

    @FXML
    private TableColumn<bank, String> difficulty;

    @FXML
    private TableColumn<bank, String> result;


    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Bank.fxml"));
        Scene scene = new Scene(root, 1000, 800);//建立一个与初始化界面一样大的界面
//        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("试题库");
        primaryStage.setScene(scene);
        primaryStage.show();//展示
    }


    @FXML
    private void initialize() throws SQLException {
        getData();
    }

    private void getData() throws SQLException {
        List<bank> banks = JDBCUtil.check();
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
    void InsertBankOnAction(ActionEvent event) {
        InsertBank.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                URL url = getClass().getResource("InsertBank.fxml");//得到压缩器界面的url
                Parent root = null;
                try {
                    root = FXMLLoader.load(url);//加载
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 1000, 800);//建立一个与初始化界面一样大的界面
                Stage stage = new Stage();
                stage.setTitle("试题库");
                stage.initStyle(StageStyle.DECORATED);//该画面不能移动
                stage.setScene(scene);
                stage.show();//展示
                try {
                    getData();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    @FXML
    void ModifyBankOnAction(ActionEvent event) throws SQLException {
        ModifyBank.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                URL url = getClass().getResource("UpdateBank.fxml");//得到压缩器界面的url
                Parent root = null;
                try {
                    root = FXMLLoader.load(url);//加载
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 1000, 800);//建立一个与初始化界面一样大的界面
                Stage stage = new Stage();
                stage.setTitle("修改试题库");
                stage.initStyle(StageStyle.DECORATED);//该画面不能移动
                stage.setScene(scene);
                try {
                    getData();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                stage.show();//展示
            }
        });
    }

    @FXML
    void DeleteBankOnAction(ActionEvent event) throws SQLException {
        bank bank =  table.getSelectionModel().getSelectedItem();
        if (bank != null){
            JDBCUtil.Delete(bank.getId(),"test_question_bank");
            getData();
        }
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
}
