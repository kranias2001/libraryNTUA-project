package com.example.Library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Comparator;

public class ViewTopBooks {
    public void show(){
        Stage loginStage = new Stage();
        loginStage.setTitle("Top 5 rated books");

        ObservableList<Book> observableBooks = FXCollections.observableArrayList(BookDatabase.getBooksList());
        SortedList<Book> sortedBooks= new SortedList<>(observableBooks, Comparator.comparing(Book::getRating).reversed());

        ObservableList<Book> firstFiveBooks = FXCollections.observableArrayList(sortedBooks.subList(0, Math.min(5, sortedBooks.size())));
        ListView<Book> listView = new ListView<>(firstFiveBooks);


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(listView);

        Scene scene = new Scene(layout, 300, 200);
        loginStage.setScene(scene);
        loginStage.initModality(Modality.APPLICATION_MODAL);
        loginStage.show();
    }
    }
