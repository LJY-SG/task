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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertExamController {

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
    private Button Add;

    @FXML
    private Button Return;

    @FXML
    private Label success;

    @FXML
    private Label fail;

    public Date convert(String s) {
        Date date;
        //实现将字符串转成⽇期类型(格式是yyyy-MM-dd)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = (Date) dateFormat.parse(s);
            return date;
        } catch (ParseException e) {
            date = null;
        }
        return date; //如果参数绑定失败返回null
    }
    @FXML
    void AddOnAction(ActionEvent event) throws SQLException {
        boolean empty = isEmpty();

        if (empty) {
            //连接数据库
            Connection connection = JDBCUtil.getConnection();
            //定义sql
            String sql = "insert into exam (name, time, address, subject, PaperName) values (?,?,?,?,?)";
            //执行sql
            PreparedStatement ps = connection.prepareStatement(sql);
            //给变量赋值
            ps.setString(1, name.getText());
            String timeText = time.getText();
            Date date = convert(timeText);
            ps.setDate(2, date);
            ps.setString(3, address.getText());
            ps.setString(4, subject.getText());
            ps.setString(5, PaperName.getText());

            ps.execute();

            //关闭资源
            JDBCUtil.closeAll(null, ps, connection);

            //显示成功句子
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

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InsertExam.fxml"));
        Scene scene = new Scene(root, 700, 600);//建立一个与初始化界面一样大的界面
//        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("添加考试表");
        primaryStage.setScene(scene);
        primaryStage.show();//展示
    }
}
