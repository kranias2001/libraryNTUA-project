package com.example.Library;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditUserScreen {
    private User user;
    private ListView<User> listview;


    public EditUserScreen(User user,ListView<User> listview) {
        this.user=user;
        this.listview=listview;
    }

    public void show() {
        Stage edituserstage = new Stage();
        edituserstage.setTitle("Τροποποίηση Χρήστη");

        Label UsernameLabel = new Label("Username :");
        TextField UsernameField = new TextField();
        Label PasswordLabel = new Label("Password :");
        TextField PasswordField = new TextField();
        Label NameTitle = new Label("Όνομα :");
        TextField NameField = new TextField();
        Label LastnameLabel = new Label("Επώνυμο :");
        TextField LastnameField = new TextField();
        Label IDLabel = new Label("Αριθμός Δελτίου Ταυτότητας :");
        TextField IDField = new TextField();
        Label emailLabel = new Label("Email :");
        TextField emailField = new TextField();

        Button addButton = new Button("Προσθήκη");
        addButton.setOnAction(actionEvent -> {
                 if (UserDatabase.searchUser(IDField.getText())!=null ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Σφάλμα");
                alert.setHeaderText(null);
                alert.setContentText("Υπάρχει ήδη αυτός ο χρήστης");
                alert.showAndWait();
            }

            else {
                UserDatabase.editUser(user,UsernameField.getText(),PasswordField.getText(),NameField.getText(),LastnameField.getText(),IDField.getText(),emailField.getText());
                listview.refresh();
                edituserstage.close();
            }
      });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(UsernameLabel, UsernameField,PasswordLabel , PasswordField,NameTitle,NameField,LastnameLabel,LastnameField,
                IDLabel,IDField,emailLabel,emailField, addButton );

        ScrollPane scrollPane= new ScrollPane(layout);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 400, 300);
        edituserstage.setScene(scene);
        edituserstage.initModality(Modality.APPLICATION_MODAL);
        edituserstage.showAndWait();

    }
}
