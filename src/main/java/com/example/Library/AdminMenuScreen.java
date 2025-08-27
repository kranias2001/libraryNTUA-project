package com.example.Library;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AdminMenuScreen {
    public void show() {
        Stage menuStage = new Stage();
        menuStage.setTitle("Hello admin");

        Label welcomeLabel = new Label("Welcome admin");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        StackPane welcomePane = new StackPane(welcomeLabel);
        welcomePane.setAlignment(Pos.TOP_CENTER);
        welcomePane.setPadding(new Insets(20, 0, 0, 0));

        Button searchbookButton = new Button("Εμφάνιση βιβλίων");
        searchbookButton.setPrefWidth(130);
        searchbookButton.setOnAction(event ->
         {
            ViewBooksAdmin editbooks = new ViewBooksAdmin();
            editbooks.show();
        }
        );

        Button viewusersButton = new Button("Εμφάνιση Χρηστών");
        viewusersButton.setPrefWidth(140);
        viewusersButton.setOnAction(actionEvent ->
         {
            ViewUsers viewusers = new ViewUsers();
            viewusers.show();
        }
        );

        Button viewBorrowingsButton = new Button("Εμφάνιση Δανεισμών");
        viewBorrowingsButton.setPrefWidth(140);
        viewBorrowingsButton.setOnAction(event ->
                {
                    ViewBorrowings editborrowings = new ViewBorrowings();
                    editborrowings.show();
                }
        );

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getChildren().addAll(welcomePane,searchbookButton,viewusersButton,viewBorrowingsButton);
        Scene scene = new Scene(layout, 300, 200);
        menuStage.setScene(scene);
        menuStage.showAndWait();
    }
}