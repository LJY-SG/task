package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class FileCopyController {

        @FXML
        private Button choose1;

        @FXML
        private TextField Path1;

        @FXML
        private TextField Path2;

        @FXML
        private Button Sure;

        @FXML
        private Button Exit;

        @FXML
        private Button choose2;

        @FXML
        private Label success;

        @FXML
        private Button chooseD;

        @FXML
        void ExitOnAction(ActionEvent event) {
            Stage stage = (Stage) Exit.getScene().getWindow();
            stage.close();
        }

        @FXML
        void SureOnAction(ActionEvent event) throws IOException {
            File file1 = new File(Path1.getText());
            File file2 = new File(Path2.getText());
            boolean empty = isEmpty();
            copyFolder(file1, file2);
            if (empty) {
                success.setVisible(true);
            }
        }

        @FXML
        void choose1OnAction(ActionEvent event) {
            Stage stage = new Stage();
            File file = new FileChooser().showOpenDialog(stage);
            Path1.setText(String.valueOf(file));
        }

    @FXML
    void chooseDOnAction(ActionEvent event) {
        Stage stage = new Stage();
        File dialog = new DirectoryChooser().showDialog(stage);
        Path1.setText(String.valueOf(dialog));
    }

    @FXML
        void choose2OnAction(ActionEvent event) {
            Stage stage = new Stage();
//            File file = new FileChooser().showOpenDialog(stage);
            File dialog = new DirectoryChooser().showDialog(stage);
            Path2.setText(String.valueOf(dialog));
        }


    //复制文件夹
    void copyFolder(File srcFile, File destFile) throws IOException {
            boolean flag = false;
                if (srcFile.isDirectory()) {
                    //在目的地下创建和数据源File一样的目录
                    String srcFileName = srcFile.getName();
                    File newFolder = new File(destFile, srcFileName);
                    if (!newFolder.exists()) {
                        newFolder.mkdir();
                    }
                    //获取数据源File下所有文件或者目录的File数组
                    File[] fileArray = srcFile.listFiles();

                    //遍历该File数组，得到每一个File对象
                    for (File file : fileArray) {
                        //把该File作为数据源File对象，递归调用复制文件夹的方法
                        copyFolder(file, newFolder);
                    }
                } else {
                    //说明是文件，直接复制，用字节流
                    File newFile = new File(destFile, srcFile.getName());
                    copyFile(srcFile, newFile);
                }
    }

    //字节流复制文件
     void copyFile(File srcFile, File destFile) throws IOException {
            if (srcFile.exists()) {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

                byte[] bys = new byte[1024];
                int len;
                while ((len = bis.read(bys)) != -1) {
                    bos.write(bys, 0, len);
                }
                bos.close();
                bis.close();
            }
    }

    boolean isEmpty(){
            boolean flag = false;
            if (Path1.getText() != null && Path2.getText() != null){
                flag = true;
            }
            return flag ;
    }

}