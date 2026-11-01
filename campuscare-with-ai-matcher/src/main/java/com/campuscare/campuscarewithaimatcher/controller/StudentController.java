package com.campuscare.campuscarewithaimatcher.controller;

import com.campuscare.campuscarewithaimatcher.model.Item;
import com.campuscare.campuscarewithaimatcher.service.ApplicationLogic;
import com.campuscare.campuscarewithaimatcher.service.ItemService;
import com.campuscare.campuscarewithaimatcher.Util.SearchAlgorithm;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class StudentController {
    @FXML private TextField itemNameField, contactField, descField, searchField;
    @FXML private ComboBox<String> typeCombo;
    @FXML private Label matchLabel;
    @FXML private TableView<Item> table;
    @FXML private TableColumn<Item,String> nameCol,typeCol,contactCol,dateCol;
    @FXML private ImageView itemImageView;
    private String currentImagePath=null;
    private final ItemService service=new ItemService();

    @FXML public void initialize(){
        typeCombo.getItems().addAll("LOST","FOUND");
        nameCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getName()));
        typeCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getType()));
        contactCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getContact()));
        dateCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getDate().toString()));
        table.setItems(service.getAllItems());
        searchField.textProperty().addListener((o,old,n)-> table.setItems(SearchAlgorithm.linearSearch(service.getAllItems(), n)));
    }
    @FXML public void onChooseImage(){
        FileChooser fc=new FileChooser(); fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images","*.png","*.jpg","*.jpeg"));
        File f=fc.showOpenDialog(table.getScene().getWindow());
        if(f!=null){
            try{
                File destDir=new File("uploads"); if(!destDir.exists()) destDir.mkdirs();
                File dest=new File(destDir, f.getName()); Files.copy(f.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                currentImagePath=dest.getAbsolutePath(); itemImageView.setImage(new Image(f.toURI().toString()));
            }catch(Exception e){ currentImagePath=f.getAbsolutePath(); itemImageView.setImage(new Image(f.toURI().toString())); }
        }
    }
    @FXML public void onAddClick(){
        if(itemNameField.getText().isEmpty()||contactField.getText().isEmpty()){ matchLabel.setText("Name & Mobile Required!"); return; }
        String type=typeCombo.getValue(); if(type==null) type="LOST";
        Item newItem=new Item(itemNameField.getText(),type,currentImagePath,contactField.getText(),descField.getText());
        service.add(newItem);
        String result=ApplicationLogic.checkMatchAndNotify(service, newItem);
        matchLabel.setText(result);
        new Alert(Alert.AlertType.INFORMATION, result).show();
    }
    @FXML public void onLogout(){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/campuscare/campuscarewithaimatcher/login.fxml"));
            Stage stage=(Stage)table.getScene().getWindow();
            stage.setScene(new Scene(loader.load(),900,600));
            stage.setTitle("CampusCare AI - Login");
        }catch(Exception e){ e.printStackTrace(); }
    }
}