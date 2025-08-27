package com.example.Library;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewBooksAdmin {

    public void show() {
        Stage listofbooks = new Stage();
        listofbooks.setTitle("Όλα τα βιβλία");
        Button addButton = new Button("Προσθήκη");
        Button editButton= new Button("Τροποποίηση");
        Button deleteButton= new Button("Διαγραφή");

        ObservableList<Book> observableBooks = BookDatabase.getBooksList();
        FilteredList<Book> filteredBooks= new FilteredList<>(observableBooks);
        ListView<Book> listView = new ListView<>(filteredBooks);

        addButton.setOnAction(event -> {
                AddBookScreen addBookScreenScreen = new AddBookScreen();
                addBookScreenScreen.show();
        });

        editButton.setOnAction(event-> {
                EditBookScreen editbookscreen = new EditBookScreen(listView.getSelectionModel().getSelectedItem(),listView );
                editbookscreen.show();
        });

        deleteButton.setOnAction(event-> {
            Book book=listView.getSelectionModel().getSelectedItem();
            if(BorrowDatabase.searchBookBorrowing(book).size()>1){
                for(Borrow borrow: BorrowDatabase.searchBookBorrowing(book)){
                    borrow.getbook().setNumberOfCopies(borrow.getbook().getNumberOfCopies()+1);
                    BorrowDatabase.removeBorrowing(borrow);
                }
            }
            BookDatabase.removeBook(book);
    });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(listView,addButton,editButton,deleteButton);
        Scene scene = new Scene(layout, 300, 400);
        listofbooks.setScene(scene);
        listofbooks.show();
    }
}


