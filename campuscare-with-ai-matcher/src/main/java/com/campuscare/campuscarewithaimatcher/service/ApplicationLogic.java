package com.campuscare.campuscarewithaimatcher.service;

import com.campuscare.campuscarewithaimatcher.model.Item;
import javafx.collections.ObservableList;

public class ApplicationLogic {
    public static String checkMatchAndNotify(ItemService service, Item newItem){
        ObservableList<Item> all = service.getAllItems();
        for(Item old: all){
            if(old!=newItem && AIMatcher.isMatch(old, newItem)){
                SmsService.sendSms(newItem.getContact(), "MATCH FOUND! Item: "+old.getName()+" Contact: "+old.getContact());
                SmsService.sendSms(old.getContact(), "MATCH FOUND! Item: "+newItem.getName()+" Contact: "+newItem.getContact());
                return "MATCH FOUND! SMS Sent to both!";
            }
        }
        return "Item Posted! Waiting for match...";
    }
}