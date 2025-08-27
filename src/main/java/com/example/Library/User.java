package com.example.Library;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String ID;
    private String email;

    public User (String username, String password, String name
            , String lastname, String ID, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.ID= ID;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public String getID() {
        return ID;
    }
    public void setUsername(String username) {
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String toString(){
        return "Username: " + username + "\n" + "password: " + password + "\n" + "Όνομα: "+ name + "\n" +  "Επώνυμο: "  + lastname +  "\n" + "ID: "+ ID+"\n"+  "Email: "  + email ;
    }
}


