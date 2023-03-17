package Controller;

import Utils.JDBCUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBankController {

    @FXML
    private AnchorPane choice;

    @FXML
    private TextField subject;

    @FXML
    private ChoiceBox<String> Type;

    @FXML
    private TextField a;

    @FXML
    private TextField d;

    @FXML
    private TextField c;

    @FXML
    private TextField b;

    @FXML
    private ChoiceBox<String> difficult;

    @FXML
    private TextField anwser;

    @FXML
    private Button Admit;
    @FXML
    private Label success;
    @FXML
    private TextArea title;

    @FXML
    private Label fail;
    String[] s = {"单选题", "多选题", "填空题"};

    @FXML
    private void initialize() {
        for (String s1 : s) {
            Type.getItems().add(s1);
        }
        difficult.getItems().addAll("*", "**", "***", "****", "*****");
    }

    @FXML
    void AdmitOnAction(ActionEvent event) {
                boolean empty = isEmpty();

                if (!empty) {
                    Connection connection = JDBCUtil.getConnection();
                    PreparedStatement ps = null;
                    String sql = "insert into test_question_bank (subject, type, title, tk, choiceA, choiceB, choiceC, choiceD, difficulty, result) values (?,?,?,?,?,?,?,?,?,?)";
                    try {
                        ps = connection.prepareStatement(sql);
                        //给变量赋值，存进数据库
                        ps.setString(1, subject.getText());
                        ps.setString(2, Type.getValue());
                        ps.setString(3, title.getText());
                        if (Type.getValue().equals("单选题") || Type.getValue().equals("多选题")) {
                            ps.setString(4, null);
                            ps.setString(5, a.getText());
                            ps.setString(6, b.getText());
                            ps.setString(7, c.getText());
                            ps.setString(8, d.getText());
                        }
                        if (Type.getValue().equals("填空题")) {
                            ps.setString(4, "_______");
                            ps.setString(5, null);
                            ps.setString(6, null);
                            ps.setString(7, null);
                            ps.setString(8, null);
                        }
                        ps.setString(9, difficult.getValue());
                        ps.setString(10, anwser.getText());
                        //执行sql
                        ps.execute();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } finally {
                        //关闭资源
                        JDBCUtil.closeAll(null, ps, connection);
                    }
                    success.setVisible(true);
                }else {
                    fail.setVisible(true);
                }
    }

    boolean isEmpty(){
        boolean empty = true;
        if (subject.getText() != null && Type.getValue() != null && title.getText() != null && a.getText() != null && b.getText() != null && c.getText()!=null && d.getText() != null && difficult.getValue() !=null && anwser.getText() !=null){
            empty = false;
        }
        return empty;
    }
}
