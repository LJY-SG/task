package Controller;

import Utils.JDBCUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateBankController {

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
    private TextField B;

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
    private TextField id;

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
    void AdmitOnAction(ActionEvent event) throws SQLException {
        boolean empty = isEmpty();

        if (!empty) {
            //建立连接
            Connection connection = JDBCUtil.getConnection();
            //定义sql
            String sql = "update test_question_bank set subject = ?,type = ?,title = ?,tk = ?,choiceA = ?,choiceB = ?,choiceC = ?,choiceD = ?,difficulty = ?,result = ? where id = ? ";
            PreparedStatement ps = null;
            ResultSet rs = JDBCUtil.selectAll("test_question_bank", connection);
            boolean flag = false;

            while (rs.next()) {
                String idText = id.getText();
                Integer value = Integer.valueOf(idText);
                int id = value.intValue();

                if (rs.getInt("id") == id) {
                    ps = connection.prepareStatement(sql);
                    ps.setString(1, subject.getText());
                    ps.setString(2, Type.getValue());
                    ps.setString(3, title.getText());
                    if (Type.getValue().equals("单选题") || Type.getValue().equals("多选题")) {
                        ps.setString(4, null);
                        ps.setString(5, a.getText());
                        ps.setString(6, B.getText());
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
                    ps.setInt(11, id);

                    flag = true;
                    ps.executeUpdate();
                }
            }
            JDBCUtil.closeAll(rs, ps, connection);
                success.setVisible(true);
        }else {
            fail.setVisible(true);
        }
    }

    boolean isEmpty(){
        boolean empty = true;
        if (subject.getText() != null && Type.getValue() != null && title.getText() != null && a.getText() != null && B.getText() != null && c.getText()!=null && d.getText() != null && difficult.getValue() !=null && anwser.getText() !=null){
            empty = false;
        }
        return empty;
    }
}

