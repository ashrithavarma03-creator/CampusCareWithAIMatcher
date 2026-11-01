package com.campuscare.campuscarewithaimatcher;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.campuscare.campuscarewithaimatcher.service.ItemService;

public class HelloController {
    @FXML
    private Label welcomeText;

    // OOP Layer - Encapsulation
    private ItemService itemService = new ItemService();

    @FXML
    public void initialize() {
        // Application Logic Layer - App start ayinappudu welcome
        if (welcomeText != null) {
            welcomeText.setText("Welcome to CampusCare AI - Lost & Found!");
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        // README Feature - AI Matching Demo + Application Logic
        if (welcomeText != null) {
            // Collections & Data Structures - ObservableList nunchi count
            int total = itemService.getAllItems().size();

            // AI Layer - AIMatcher logic demo
            String status = "Total Items: " + total + " | AI Ready for Matching!";
            welcomeText.setText(status);
        }
    }
}