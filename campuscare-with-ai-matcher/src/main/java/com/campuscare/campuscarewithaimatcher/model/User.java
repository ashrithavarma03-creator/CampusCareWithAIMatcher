package com.campuscare.campuscarewithaimatcher.model;
public class User {
    private String username, password, role;
    public User(){} public User(String u,String p,String r){username=u; password=p; role=r;}
    public String getUsername(){return username;} public String getPassword(){return password;} public String getRole(){return role;}
    public void setUsername(String s){username=s;} public void setPassword(String s){password=s;} public void setRole(String s){role=s;}
}