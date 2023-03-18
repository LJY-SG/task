module com.example.filecopy {
    requires javafx.controls;
    requires javafx.fxml;

    exports Controller;
    opens Controller to javafx.fxml;
}