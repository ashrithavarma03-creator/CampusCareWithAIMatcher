package com.campuscare.campuscarewithaimatcher.service;

import com.campuscare.campuscarewithaimatcher.model.Item;

public class AIMatcher {
    public static boolean isMatch(Item old, Item newItem){
        if(old.getName()==null || newItem.getName()==null) return false;
        if(old.getType().equalsIgnoreCase(newItem.getType())) return false;
        String a = old.getName().toLowerCase().split(" ")[0];
        String b = newItem.getName().toLowerCase().split(" ")[0];
        return old.getName().toLowerCase().contains(b) || newItem.getName().toLowerCase().contains(a) || a.equals(b);
    }
    public static boolean ismatch(Item old, Item newItem){ return isMatch(old, newItem); }
}