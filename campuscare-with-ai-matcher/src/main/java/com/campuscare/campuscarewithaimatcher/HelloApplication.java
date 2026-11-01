package com.campuscare.campuscarewithaimatcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class HelloApplication extends Application {
    @Override public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml")); // hello-view.fxml KAADU!
        stage.setScene(new Scene(loader.load(), 900, 600));
        stage.setTitle("CampusCare AI - Lost & Found");
        stage.show();
    }
    public static void main(String[] args){ launch(); }
}