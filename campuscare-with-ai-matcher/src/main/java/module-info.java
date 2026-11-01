module com.campuscare.campuscarewithaimatcher {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.campuscare.campuscarewithaimatcher to javafx.fxml;
    exports com.campuscare.campuscarewithaimatcher;
    exports com.campuscare.campuscarewithaimatcher.controller;
    opens com.campuscare.campuscarewithaimatcher.controller to javafx.fxml;
}