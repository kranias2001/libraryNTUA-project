package com.example.Library;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RateBook   {
    public void show() {
        Stage ratebook = new Stage();
        ratebook.setTitle("Αξιολόγηση βιβλίου");
        Label rateLabel = new Label("Βαθμολογία(1-5)");
        TextField rateField = new TextField();
        Label commentLabel = new Label("Σχόλιο");
        TextArea commentField = new TextArea();
        Button verifyButton = new Button("Επιβεβαίωση");

        verifyButton.setOnAction(event -> {
            try {
                double number = Double.parseDouble(rateField.getText());

                if (number < 1 || number > 5) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Σφάλμα");
                    alert.setHeaderText(null);
                    alert.setContentText("Ο αριθμός πρέπει να είναι ανάμεσα στο 1 και το 5.");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Σφάλμα");
                alert.setHeaderText(null);
                alert.setContentText("Παρακαλώ εισάγετε αριθμό στην βαθμολογία.");
                alert.showAndWait();
            }
            Book book=BookDatabase.getBook();
           book.setcounter(book.getcounter()+1);
           book.setsum(book.getsum()+Double.parseDouble(rateField.getText()));
           book.setRating(book.getsum()/book.getcounter());
           ratebook.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(rateLabel,rateField,commentLabel,commentField,verifyButton);
        Scene scene = new Scene(layout, 300, 400);
        ratebook.setScene(scene);
        ratebook.show();
}
}

