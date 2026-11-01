package com.campuscare.campuscarewithaimatcher.service;
import com.campuscare.campuscarewithaimatcher.model.User;
public class AuthService {
    public User login(String u, String p){
        if(u.equals("student")&&p.equals("student")) return new User(u,p,"STUDENT");
        if(u.equals("admin")&&p.equals("admin")) return new User(u,p,"ADMIN");
        if(u.equals("staff")&&p.equals("staff")) return new User(u,p,"STAFF");
        return null;
    }
}