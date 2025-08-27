package com.example.Library;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class Main extends Application {
    Stage primaryStage;
    public void stop() throws IOException {
        UserDatabase.saveUser();
        BookDatabase.saveBook();
        BorrowDatabase.saveBorrow();
    }
    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        UserDatabase.loadUser();
        BookDatabase.loadBook();
        BorrowDatabase.loadBorrow();

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Main menu");

        Label welcomeLabel = new Label("Welcome");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        StackPane welcomePane = new StackPane(welcomeLabel);
        welcomePane.setAlignment(Pos.TOP_CENTER);
        welcomePane.setPadding(new Insets(20, 0, 0, 0));

        Button loginButton = new Button("Σύνδεση");
        loginButton.setPrefWidth(80);
        loginButton.setOnAction(event ->
                {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.show();
        });

        Button signUpButton = new Button("Εγγραφή");
        signUpButton.setPrefWidth(80);
        signUpButton.setOnAction(event ->
        {
            SignUpScreen signUpScreen = new SignUpScreen();
            signUpScreen.show();
        });

        Button ViewBooksButtom = new Button("Εμφάνιση καλύτερων βιβλίων");
        ViewBooksButtom.setPrefWidth(180);
        ViewBooksButtom.setOnAction(event ->{
            ViewTopBooks viewtopbooks=new ViewTopBooks();
            viewtopbooks.show();
        });

        VBox layout = new VBox(20);
        Region region= new Region();
        region.setPrefHeight(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getChildren().addAll(welcomePane, region, loginButton, signUpButton,ViewBooksButtom);

        ScrollPane scrollPane= new ScrollPane(layout);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}