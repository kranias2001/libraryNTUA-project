package com.example.Library;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewUsers {
    public void show() {
        Stage listusers = new Stage();
        listusers.setTitle("Όλοι οι χρήστες");
        Button editButton = new Button("Τροποποίηση");
        Button deleteButton = new Button("Διαγραφή");

        ObservableList<User> observableUsers = UserDatabase.getUsersList();
        FilteredList<User> filteredUsers = new FilteredList<>(observableUsers);
        ListView<User> listView = new ListView<>(filteredUsers);

        editButton.setOnAction(event -> {
                EditUserScreen edituserscreen = new EditUserScreen(listView.getSelectionModel().getSelectedItem(),listView);
                edituserscreen.show();
        });

        deleteButton.setOnAction(event -> {
            User user=listView.getSelectionModel().getSelectedItem();
            if(BorrowDatabase.searchUserBorrowing(user).size()>1){
            for(Borrow borrow: BorrowDatabase.searchUserBorrowing(user)) {
                borrow.getbook().setNumberOfCopies(borrow.getbook().getNumberOfCopies()+1);
                BorrowDatabase.removeBorrowing(borrow);
            }
            }
            UserDatabase.removeUser(user);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(listView, editButton, deleteButton);
        Scene scene = new Scene(layout, 300, 400);
        listusers.setScene(scene);
        listusers.show();
    }
}
