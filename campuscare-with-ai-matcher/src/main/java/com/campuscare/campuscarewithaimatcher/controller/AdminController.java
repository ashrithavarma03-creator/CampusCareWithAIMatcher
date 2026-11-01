package com.campuscare.campuscarewithaimatcher.controller;

import com.campuscare.campuscarewithaimatcher.model.Item;
import com.campuscare.campuscarewithaimatcher.service.ItemService;
import com.campuscare.campuscarewithaimatcher.service.SmsService;
import com.campuscare.campuscarewithaimatcher.Util.SearchAlgorithm;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AdminController {
    @FXML private TableView<Item> table;
    @FXML private TableColumn<Item,String> nameCol,typeCol,contactCol,dateCol,statusCol;
    @FXML private TextField searchField;
    @FXML private Label totalLabel,lostLabel,foundLabel;
    @FXML private ListView<String> smsList;
    private ItemService service=new ItemService();

    @FXML public void initialize(){
        nameCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getName()));
        typeCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getType()));
        contactCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getContact()));
        dateCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getDate().toString()));
        statusCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getStatus()));
        table.setItems(service.getAllItems());
        updateStats();
        smsList.setItems(SmsService.logs);
        searchField.textProperty().addListener((o,old,n)-> table.setItems(SearchAlgorithm.linearSearch(service.getAllItems(), n)));
    }
    private void updateStats(){
        long total=service.getAllItems().size();
        long lost=service.getAllItems().stream().filter(i->i.getType().equalsIgnoreCase("LOST")).count();
        totalLabel.setText("Total: "+total);
        lostLabel.setText("LOST: "+lost);
        foundLabel.setText("FOUND: "+(total-lost));
    }
    @FXML public void onDelete(){
        Item sel=table.getSelectionModel().getSelectedItem();
        if(sel!=null){ service.delete(sel); updateStats(); }
    }

    // LOGOUT ADDED MAMA - 100% WORKING
    @FXML public void onLogout(){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/campuscare/campuscarewithaimatcher/login.fxml"));
            Stage stage=(Stage)totalLabel.getScene().getWindow();
            stage.setScene(new Scene(loader.load(),900,600));
            stage.setTitle("CampusCare AI - Login");
        }catch(Exception e){ e.printStackTrace(); }
    }
}