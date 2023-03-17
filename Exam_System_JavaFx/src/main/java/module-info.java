module Controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens Controller to javafx.fxml;
    exports Controller;
    exports domain;
}