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

public class UserMenuScreen {
    public void show() {
        Stage menuStage = new Stage();
        menuStage.setTitle("Hello user");

        Label welcomeLabel = new Label("Welcome User");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        StackPane welcomePane = new StackPane(welcomeLabel);
        welcomePane.setAlignment(Pos.TOP_CENTER);
        welcomePane.setPadding(new Insets(20, 0, 0, 0));
        Button searchbookButton = new Button("Εμφάνιση βιβλίων");
        searchbookButton.setPrefWidth(120);
        searchbookButton.setOnAction(event ->
                {
                    ViewBooks listofbooksScreen = new ViewBooks();
                    listofbooksScreen.show();
                });
        Button myBorrowing = new Button("Οι κρατήσεις μου");
        myBorrowing.setPrefWidth(120);
        myBorrowing.setOnAction(event -> {
            MyBooks listofbooks= new MyBooks();
            listofbooks.show();
        });

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getChildren().addAll(welcomePane,searchbookButton,myBorrowing);
        Scene scene = new Scene(layout, 300, 200);
        menuStage.setScene(scene);
        menuStage.show();
    }
}
