package com.example.Library;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUpScreen {
    public void show() {
        Stage signUpStage = new Stage();
        signUpStage.setTitle("Sign Up");

        Label usernameLabel = new Label("Όνομα Χρήστη:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Κωδικός:");
        PasswordField passwordField = new PasswordField();
        Label nameLabel = new Label("Όνομα:");
        TextField nameField = new TextField();
        Label lastNameLabel = new Label("Επώνυμο:");
        TextField lastNameField = new TextField();
        Label idLabel = new Label("Αριθμός Δελτίου Ταυτότητας:");
        TextField idField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Button signUpButton = new Button("Εγγραφή");

        signUpButton.setOnAction(event -> {
            if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty() ||
                    nameField.getText().isEmpty() || lastNameField.getText().isEmpty() ||
                    idField.getText().isEmpty() || emailField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Σφάλμα");
                alert.setHeaderText(null);
                alert.setContentText("Παρακαλώ συμπληρώστε όλα τα πεδία.");
                alert.showAndWait();
            }
             else if (UserDatabase.searchUser(usernameField.getText())!=null ||
                    UserDatabase.searchUserID(idField.getText())!=null ||
                    UserDatabase.searchUserEmail(emailField.getText())!=null || usernameField.getText().equals("medialab")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Σφάλμα");
                    alert.setHeaderText(null);
                    alert.setContentText("Υπάρχει ήδη αυτός ο χρήστης");
                    alert.showAndWait();
            }
            else {
                User newUser = new User(usernameField.getText(), passwordField.getText(),
                    nameField.getText(), lastNameField.getText(),
                    idField.getText(), emailField.getText());
                UserDatabase.addUser(newUser);
            signUpStage.close();
        }});

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField,
                nameLabel, nameField, lastNameLabel, lastNameField, idLabel, idField,
                emailLabel, emailField, signUpButton);

        ScrollPane scrollPane= new ScrollPane(layout);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 400, 300);
        signUpStage.setScene(scene);
        signUpStage.initModality(Modality.APPLICATION_MODAL);
        signUpStage.showAndWait();
    }
}