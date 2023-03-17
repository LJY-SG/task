package Controller;

import Utils.JDBCUtil;
import domain.paper;
import domain.paperSource;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperSourceController {

    @FXML
    private Button InsertPaper;


    @FXML
    private TableView<paperSource> table;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> paperName;

    @FXML
    private Button ModifyPaper;

    @FXML
    private Button DeletePaper;

    @FXML
    private Button QueryPaper;

    @FXML
    private Button Return;
    public static TextArea textArea;
    @FXML
    void DeletePaperOnAction(ActionEvent event) throws SQLException {
        paperSource paperSource =  table.getSelectionModel().getSelectedItem();
        if (paperSource != null){
            JDBCUtil.Delete(paperSource.getId(),"PaperSource");
            Connection connection = JDBCUtil.getConnection();
            String sql = "drop table if exists "+paperSource.getPaperName();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            JDBCUtil.closeAll(null,ps,connection);
            getData();
        }
    }

    @FXML
    private void initialize() throws SQLException {
        getData();
    }
    private void getData() throws SQLException {
            List<paperSource> paperSourceList = JDBCUtil.checkPaperSource();
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            paperName.setCellValueFactory(new PropertyValueFactory<>("paperName"));
            //向表中添加数据
            table.setItems(FXCollections.observableList(paperSourceList));
    }

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PaperSource.fxml"));
        Scene scene = new Scene(root, 621, 438);//建立一个与初始化界面一样大的界面
//        primaryStage.initStyle(StageStyle.DECORATED);//该画面不能移动
        primaryStage.setScene(scene);
        primaryStage.show();//展示
    }

    @FXML
    void InsertPaperOnAction(ActionEvent event) {
        InsertPaper.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                URL url = getClass().getResource("InsertPaper.fxml");//得到压缩器界面的url
                Parent root = null;
                try {
                    root = FXMLLoader.load(url);//加载
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);//建立一个与初始化界面一样大的界面
                Stage stage = new Stage();
                stage.setTitle("添加");
                stage.initStyle(StageStyle.DECORATED);//该画面不能移动
                stage.setScene(scene);
                stage.show();//展示
            }
        });

    }
    String getPaperData() throws SQLException {
        paperSource paperSource =  table.getSelectionModel().getSelectedItem();

        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //获取查询返回对象
        ResultSet paper = JDBCUtil.selectAll(paperSource.getPaperName(), connection);

        //创建集合对象
        List<paper> papers = new ArrayList<>();

        while (paper.next()) {
            //创建paper对象
            paper b = new paper();

            b.setId(paper.getInt("id"));
            b.setType(paper.getString("type"));
            b.setSubject(paper.getString("subject"));
            b.setTitle(paper.getString("title"));
            b.setTk(paper.getString("tk"));
            b.setChoiceA(paper.getString("choiceA"));
            b.setChoiceB(paper.getString("choiceB"));
            b.setChoiceC(paper.getString("choiceC"));
            b.setChoiceD(paper.getString("choiceD"));
            b.setDifficulty(paper.getString("difficulty"));

            //添加到集合对象
            papers.add(b);
        }
        StringBuilder sb = new StringBuilder();
        for (paper b : papers) {
            if (b.getType().equals("单选题") || b.getType().equals("多选题")) {
                sb.append(b.toString1());
            }
            if (b.getType().equals("填空题")) {
                sb.append(b.toString2());
            }
        }
        return sb.toString();
    }

    @FXML
    void QueryPaperOnAction(ActionEvent event){
            //输出到界面
            QueryPaper.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        startPaper(new Stage());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

    @FXML
    void startPaper(Stage primaryStage) throws Exception {
        AnchorPane ap = new AnchorPane();

        TextArea textArea = new TextArea();
        ap.getChildren().addAll(textArea);
        textArea.setText(getPaperData());//设置一个初始值
        textArea.setFont(Font.font(20));//字体大小
        textArea.setWrapText(true);//是否自动换行
        textArea.setPrefHeight(800);
        textArea.setPrefWidth(1000);

        Scene scene = new Scene(ap);


        primaryStage.setScene(scene);
        primaryStage.setTitle("查看试卷");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);
        primaryStage.show();

        //左右滚动监听
        textArea.scrollLeftProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("左右移动" + newValue);
            }
        });
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
