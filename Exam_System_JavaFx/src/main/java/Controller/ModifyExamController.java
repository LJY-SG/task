package Controller;

import Utils.JDBCUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyExamController {

    @FXML
    private TextField name;

    @FXML
    private TextField subject;

    @FXML
    private TextField address;

    @FXML
    private TextField time;

    @FXML
    private TextField PaperName;

    @FXML
    private Button ModifyExam;

    @FXML
    private Button Return;

    @FXML
    private Label success;


    @FXML
    private Label fail;

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ModifyExam.fxml"));
        Scene scene = new Scene(root, 700, 600);//建立一个与初始化界面一样大的界面
//        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("修改考试表");
        primaryStage.setScene(scene);
        primaryStage.show();//展示
    }

    @FXML
    void ModifyExamOnAction(ActionEvent event) throws SQLException {
        boolean empty = isEmpty();
        if (empty) {
            Connection connection = JDBCUtil.getConnection();
            ResultSet rs = JDBCUtil.selectAll("exam", connection);

            //定义sql
            String sql = "update exam set name=?,time=?,address=?,PaperName=? where name = ?";

            while (rs.next()) {
                if (rs.getString("name").equals(name.getText())) {
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, name.getText());
                    ps.setString(2, time.getText());
                    ps.setString(3, address.getText());
                    ps.setString(4, PaperName.getText());
                    ps.setString(5, name.getText());

                    ps.execute();
                    ps.close();
                    break;
                }
            }
            JDBCUtil.closeAll(rs, null, connection);
                success.setVisible(true);
        }else {
            fail.setVisible(true);
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
                new ExamController().start(primaryStage);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    boolean isEmpty(){
        boolean flag = true;
        if (name.getText() != null && address.getText() != null && PaperName.getText() != null && time.getText() != null && subject.getText() != null){
            flag = false;
        }
        return flag;
    }

}
