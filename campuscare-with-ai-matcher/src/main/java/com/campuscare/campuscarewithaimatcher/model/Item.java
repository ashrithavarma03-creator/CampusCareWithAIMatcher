package com.campuscare.campuscarewithaimatcher.model;

import java.time.LocalDate;

public class Item {
    private int id;
    private static int COUNT=1;
    private String name, type, imagePath, contact, description, place, owner, status;
    private LocalDate date;
    private User reportedBy;

    public Item(){
        id=COUNT++;
        date=LocalDate.now();
        status="PENDING";
        place="Campus";
        owner="student";
    }


    public Item(String name, String type, String imagePath, String contact, String description){
        id=COUNT++;
        this.name=name;
        this.type=type;
        this.imagePath=imagePath;
        this.contact=contact;
        this.description=description;
        this.place="Campus";
        this.owner="student";
        this.status="PENDING";
        this.date=LocalDate.now();
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public void setName(String s){name=s;}
    public String getType(){return type;}
    public void setType(String s){type=s;}
    public String getImagePath(){return imagePath;}
    public void setImagePath(String s){imagePath=s;}
    public String getContact(){return contact;}
    public void setContact(String s){contact=s;}
    public String getDescription(){return description;}
    public void setDescription(String s){description=s;}
    public String getPlace(){return place;}
    public void setPlace(String s){place=s;}
    public String getOwner(){return owner;}
    public void setOwner(String s){owner=s;}
    public String getStatus(){return status;}
    public void setStatus(String s){status=s;}
    public LocalDate getDate(){return date;}
    public User getReportedBy(){return reportedBy;}
    public void setReportedBy(User u){reportedBy=u;}
}