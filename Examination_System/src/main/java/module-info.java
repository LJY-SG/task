module com.example.examination_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports com.examination_system.www.controller.Student;
    opens com.examination_system.www.po;
    opens com.examination_system.www.controller.Student to javafx.fxml;

    exports com.examination_system.www.controller.Teacher;
    opens com.examination_system.www.controller.Teacher to javafx.fxml;

    exports com.examination_system.www.controller;
    opens com.examination_system.www.controller to javafx.fxml;
}