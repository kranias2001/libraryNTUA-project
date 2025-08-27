package com.example.Library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.ArrayList;

public class UserDatabase {
    private static final String USERS_FILE = "medialab/Users.txt";
    private static ObservableList<User> userlist = FXCollections.observableArrayList();
    public static ObservableList<User> getUsersList() {
        return userlist;
    }

    public static User connecteduser;
    public  static User getLoggedIn(){
        return connecteduser;
    }

    public static void setLoggedIn(User connecteduser){
        UserDatabase.connecteduser =connecteduser;
    }

    public static void saveUser() throws IOException {
        FileOutputStream fileOutputStream =new FileOutputStream(USERS_FILE);
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(new ArrayList<>(userlist));
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static void loadUser() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream =new FileInputStream(USERS_FILE);
        ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);
        userlist =FXCollections.observableArrayList((ArrayList<User>) objectInputStream.readObject());
        objectInputStream.close();

    }
    public static void addUser(User user) {
        userlist.add(user);
    }
    public static void removeUser(User user) {
        userlist.remove(user);
    }
    public static void editUser(User oldUser,String newusername,String newpassword,String newname,String newlastname,String newid,String newemail) {
        if(!newusername.isEmpty())          oldUser.setUsername(newusername);
        if(!newpassword.isEmpty())          oldUser.setPassword(newpassword);
        if(!newname.isEmpty())              oldUser.setName(newname);
        if(!newlastname.isEmpty())          oldUser.setLastname(newlastname);
        if(!newid.isEmpty())                oldUser.setEmail(newid);
        if(!newemail.isEmpty())             oldUser.setID(newemail);
    }
    public static User searchUser(String username) {
       return userlist.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null); //Αλλαγες για ID. ωστε να ειναι μοναδικος ο χρηστης
    }

    public static User searchUserID(String ID) {
        return userlist.stream().filter(user -> user.getID().equals(ID)).findAny().orElse(null);
    }

    public static User searchUserEmail(String Email) {
        return userlist.stream().filter(user -> user.getEmail().equals(Email)).findAny().orElse(null);
    }
}