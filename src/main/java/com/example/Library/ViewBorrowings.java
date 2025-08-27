package com.example.Library;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewBorrowings {

    public void show(){
        Stage listborrowings = new Stage();
        listborrowings.setTitle("Όλοι οι δανεισμοί");
        Button deleteButton = new Button("Διαγραφή");

        ObservableList<Borrow> observableBorrowings = BorrowDatabase.getBorrowingsList();
        FilteredList<Borrow> filteredBorrowings = new FilteredList<>(observableBorrowings);
        ListView<Borrow> listView = new ListView<>(filteredBorrowings);

        deleteButton.setOnAction(actionEvent ->{
            listView.getSelectionModel().getSelectedItem().getbook().setNumberOfCopies(listView.getSelectionModel().getSelectedItem().getbook().getNumberOfCopies()+1);
            BorrowDatabase.removeBorrowing(listView.getSelectionModel().getSelectedItem());
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(listView, deleteButton);
        Scene scene = new Scene(layout, 300, 400);
        listborrowings.setScene(scene);

        listborrowings.show();
    }
    }

