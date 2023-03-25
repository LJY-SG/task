package com.examination_system.www.controller.Student;

import com.examination_system.www.controller.LoginController;
import com.examination_system.www.controller.MenuApplication;
import com.examination_system.www.service.RegisterService;
import com.examination_system.www.util.JDBCUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformationController {

    @FXML
    private Button Sure;

    @FXML
    private Button Exit;

    @FXML
    private TextField Name;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup SexGroup;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton Student;

    @FXML
    private ToggleGroup StatusGroup;

    @FXML
    private RadioButton Teacher;

    @FXML
    private ChoiceBox<String> choiceClass;

    @FXML
    private Button ModifyPassWord;

    public static List<String> names = new ArrayList<>();

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("Information.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 498, 550);
        stage.setTitle("个人信息");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize() throws SQLException {
        List<String> arr = LoginController.arr;
        String LoginName = arr.get(arr.size()-1);
        Name.setText(LoginName);
        names.add(LoginName);
        //老师身份被选中
        Student.setSelected(true);
        choiceClass.getItems().addAll("一班","二班","三班");

        ResultSet rs = JDBCUtil.SelectAll("student");
        while (rs.next()){
            if (rs.getString("name").equals(LoginName)){
                if (rs.getString("sex").equals("男")){
                    male.setSelected(true);
                }else {
                    female.setSelected(true);
                }
                String team = rs.getString("team");
                choiceClass.setValue(team);
            }
        }
    }

    @FXML
    void ExitOnAction(ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void ModifyPassWordOnAction(ActionEvent event) {
        ModifyPassWord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                URL url = getClass().getResource("ModifyPassWord.fxml");
                Parent root = null;
                try{
                    root = FXMLLoader.load(url);
                }catch (IOException e){
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("修改密码");
                stage.initStyle(StageStyle.DECORATED);//可以移动
                stage.setScene(scene);
                stage.show();//展示
            }
        });
    }

    @FXML
    void SureOnAction(ActionEvent event) throws SQLException {
        //获取个人信息
        String nameText = Name.getText();
        //判断性别
        String judgeSex = RegisterService.JudgeSex(male.isSelected());
        //身份
        String status = "学生";
        //获取执教班级
        String classValue = choiceClass.getValue();

        //将数据改入数据库
        JDBCUtil.Modify(nameText,judgeSex,classValue,"student");
    }

}

