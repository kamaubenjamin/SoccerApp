package com.example.soccerapp.Methods;

public class TeamsModel {
    Integer Id;
    String name;
    String position;
    String age;

//Calls During addPLAYER function
    public TeamsModel(Integer Id, String name, String position) {
        this.Id = Id;
        this.name = name;
        this.position = position;

    }
//Accessed during UpdatePLAYER function
    public TeamsModel(String name, String position, String age) {
        this.age = age;
        this.name = name;
        this.position = position;


    }
   // Calls During Viewing function
    public TeamsModel(Integer Id, String name, String position, String age) {
        this.age = age;
        this.name = name;
        this.position = position;
        this.Id= Id;


    }


    public Integer getID() {
        return Id;
    }


    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }


}

