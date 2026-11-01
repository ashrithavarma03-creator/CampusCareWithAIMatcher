package com.campuscare.campuscarewithaimatcher.Util;

import com.campuscare.campuscarewithaimatcher.model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.stream.Collectors;

public class SearchAlgorithm {
    // Algorithm Layer - Linear Search O(n) - README Feature - Fast Search
    public static ObservableList<Item> linearSearch(ObservableList<Item> list, String key){
        if(key==null || key.trim().isEmpty()) return list;
        String lower = key.toLowerCase().trim();
        return FXCollections.observableArrayList(list.stream()
                .filter(i -> i.getName()!=null && i.getName().toLowerCase().contains(lower) ||
                        (i.getType()!=null && i.getType().toLowerCase().contains(lower)) ||
                        (i.getContact()!=null && i.getContact().contains(lower)))
                .collect(Collectors.toList()));
    }
}