package com.example.Library;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginScreen {

    public void show() {
        Stage loginStage = new Stage();
        loginStage.setTitle("Σύνδεση");

        Label usernameLabel = new Label("Όνομα Χρήστη:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Κωδικός:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Σύνδεση");

        loginButton.setOnAction(event -> {
            User user = UserDatabase.searchUser(usernameField.getText());
                    if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Σφάλμα");
                        alert.setHeaderText(null);
                        alert.setContentText("Παρακαλώ συμπληρώστε όλα τα πεδία.");
                        alert.showAndWait();
                    }
                    else if(usernameField.getText().equals("medialab") && passwordField.getText().equals("medialab_2024")) {
                        loginStage.close();
                        AdminMenuScreen adminmenuScreen = new AdminMenuScreen();
                        adminmenuScreen.show();
                    }
                    else if (UserDatabase.searchUser(usernameField.getText()) == null ) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Σφάλμα");
                        alert.setHeaderText(null);
                        alert.setContentText("Δεν υπάρχει χρήστης με αυτά τα στοιχεία.");
                        alert.showAndWait();
                    }
                    else if (user.getPassword().equals(passwordField.getText()))
                    {
                        UserDatabase.setLoggedIn(user);
                        UserMenuScreen simplemenuScreen = new UserMenuScreen();
                        simplemenuScreen.show();
                        loginStage.close();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Σφάλμα");
                        alert.setHeaderText(null);
                        alert.setContentText("Δεν υπάρχει χρήστης με αυτά τα στοιχεία.");
                        alert.showAndWait();
                    }
                }
        );

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

        Scene scene = new Scene(layout, 300, 200);
        loginStage.setScene(scene);
        loginStage.initModality(Modality.APPLICATION_MODAL);
        loginStage.show();
    }
}