package com.campuscare.campuscarewithaimatcher.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SmsService {
    public static ObservableList<String> logs = FXCollections.observableArrayList();
    public static void sendSms(String phone, String msg){
        String log = "SMS to "+phone+" : "+msg+" | "+java.time.LocalTime.now();
        System.out.println(log);
        logs.add(log);
    }
}