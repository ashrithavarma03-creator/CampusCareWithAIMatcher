package com.campuscare.campuscarewithaimatcher.Util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/campuscare?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","");
        }catch(Exception e){
            System.out.println("MySQL not connected - In-Memory tho run: "+e.getMessage());
            return null;
        }
    }
}