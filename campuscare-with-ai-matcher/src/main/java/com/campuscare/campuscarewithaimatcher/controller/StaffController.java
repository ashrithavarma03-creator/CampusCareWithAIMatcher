package com.campuscare.campuscarewithaimatcher.controller;
import com.campuscare.campuscarewithaimatcher.model.Item;
import com.campuscare.campuscarewithaimatcher.service.ItemService;
import javafx.beans.property.SimpleStringProperty; import javafx.fxml.FXML; import javafx.fxml.FXMLLoader; import javafx.scene.Scene; import javafx.scene.control.*; import javafx.stage.Stage;
public class StaffController {
    @FXML private TableView<Item> table; @FXML private TableColumn<Item,String> nameCol,typeCol,contactCol;
    private final ItemService service=new ItemService();
    @FXML public void initialize(){
        nameCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getName()));
        typeCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getType()));
        contactCol.setCellValueFactory(d->new SimpleStringProperty(d.getValue().getContact()));
        table.setItems(service.getAllItems());
    }
    @FXML public void onLogout(){
        try{ FXMLLoader l=new FXMLLoader(getClass().getResource("/com/campuscare/campuscarewithaimatcher/login.fxml")); Stage s=(Stage)table.getScene().getWindow(); s.setScene(new Scene(l.load(),900,600)); }catch(Exception e){e.printStackTrace();}
    }
}