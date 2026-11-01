package com.campuscare.campuscarewithaimatcher.service;

import com.campuscare.campuscarewithaimatcher.model.Item;
import com.campuscare.campuscarewithaimatcher.Util.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

public class ItemService {

    // COLLECTIONS LAYER - README
    private static final ObservableList<Item> items = FXCollections.observableArrayList();
    // DATA STRUCTURES LAYER - O(1) fast
    private static final HashMap<String, Item> itemMap = new HashMap<>();

    public ObservableList<Item> getAllItems(){ return items; }

    @SuppressWarnings({"SqlNoDataSourceInspection", "SqlResolve", "SqlDialectInspection"})
    public void add(Item i){
        items.add(i);
        itemMap.put(i.getName().toLowerCase(), i);



        try{
            Connection con = DBConnection.getConnection();
            if(con != null){
                // noinspection SqlNoDataSourceInspection,SqlResolve
                String sql = "INSERT INTO items(name,type,imagePath,contact,description,date) VALUES(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, i.getName());
                ps.setString(2, i.getType());
                ps.setString(3, i.getImagePath());
                ps.setString(4, i.getContact());
                ps.setString(5, i.getDescription());
                ps.setString(6, i.getDate().toString());
                ps.executeUpdate();
                ps.close();
                con.close();
                System.out.println("Saved to MySQL! - " + i.getName());
            }
        }catch(Exception e){
            System.out.println("MySQL skip - in-memory ok: "+e.getMessage());
        }
    }

    public void delete(Item i){
        items.remove(i);
        itemMap.remove(i.getName().toLowerCase());
    }
}