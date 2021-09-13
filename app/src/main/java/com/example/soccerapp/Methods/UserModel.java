package com.example.soccerapp.Methods;

public class UserModel {

    Integer id;
    String name;
    String email;
    String pass;
    String phone;

    public UserModel(Integer id, String name, String email ,String phone)  {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;

    }
    public UserModel(String name, String email, String pass ,String phone) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
    }

    public UserModel(Integer id, String name, String email, String pass ,String phone)  {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
    }

    public UserModel(String stringEmail, String stringPassword) {
        this.email = email;
        this.pass = pass;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getEmail() {


        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
    public String getPass(){

        return pass;
    }
    public void setPass(){

        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(){
        this.phone =phone;
    }
}
