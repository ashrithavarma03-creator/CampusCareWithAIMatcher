package com.campuscare.campuscarewithaimatcher.controller;
import com.campuscare.campuscarewithaimatcher.HelloApplication;
import com.campuscare.campuscarewithaimatcher.model.User;
import com.campuscare.campuscarewithaimatcher.service.AuthService;
import javafx.fxml.FXML; import javafx.fxml.FXMLLoader; import javafx.scene.Scene; import javafx.scene.control.*;
import javafx.stage.Stage;
public class LoginController {
    @FXML TextField usernameField; @FXML PasswordField passwordField; @FXML Label errorLabel;
    @FXML protected void onLogin() throws Exception {
        AuthService auth = new AuthService();
        User u = auth.login(usernameField.getText(), passwordField.getText());
        if(u==null){ errorLabel.setText("Invalid! Use student/student"); return; }
        String fxml = u.getRole().equals("ADMIN") ? "admin-dashboard.fxml" : u.getRole().equals("STAFF") ? "staff-dashboard.fxml" : "student-dashboard.fxml";
        Stage stage = (Stage) usernameField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        stage.setScene(new Scene(loader.load(), 900, 600));
    }
}