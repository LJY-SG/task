package com.examination_system.www.controller.Student;


import com.examination_system.www.dao.Modify;
import com.examination_system.www.service.RegisterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class ModifyPassWordController {

    @FXML
    private Button Sure;

    @FXML
    private Button Exit;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Label success;

    @FXML
    private Label fail;

    @FXML
    private void initialize() {
        List<String> names = InformationController.names;
        String s = names.get(0);
        name.setText(s);
    }

    @FXML
    void ExitOAction(ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void SureOnAction(ActionEvent event) throws SQLException {
        //获取输入框的值
        String nameText = name.getText();
        String passwordText = password.getText();

        //判断用户是否存在
        boolean register = RegisterService.isRegister(nameText, "学生");

        if (register){
            //修改密码
            Modify.ModifyPassWord(passwordText,nameText,"Student");
            success.setVisible(true);
        }else {
            fail.setVisible(true);
        }
    }

}

