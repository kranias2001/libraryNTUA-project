package com.example.Library;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MyBooks {

    public void show(){
        Stage mybooks = new Stage();
        mybooks.setTitle("Τα βιβλία μου");

        ObservableList<Borrow> observableBorrowing = BorrowDatabase.getBorrowingsList();
        FilteredList<Borrow> filteredBorrowings= new FilteredList<>(observableBorrowing);
        ListView<Borrow> listView = new ListView<>(filteredBorrowings);

        User user= UserDatabase.getLoggedIn();
        filteredBorrowings.setPredicate(borrow -> borrow.getuser().getUsername().equals(user.getUsername()));

        Button returnbookButton = new Button("Επιστροφή βιβλίου");
        returnbookButton.setPrefWidth(120);

        returnbookButton.setOnAction(event ->
         { Borrow borrow= listView.getSelectionModel().getSelectedItem();
             borrow.getbook().setNumberOfCopies(borrow.getbook().getNumberOfCopies()+1);
            BorrowDatabase.removeBorrowing(borrow);

        });
        Button ratebookButton=new Button("Αξιολόγηση");
        ratebookButton.setPrefWidth(100);
        ratebookButton.setOnAction(event-> {
            Borrow borrow= listView.getSelectionModel().getSelectedItem();
            BookDatabase.setBook(BookDatabase.searchBook(borrow.getbook().getIsbn()));
            RateBook ratebook=new RateBook();
            ratebook.show();

        });
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(listView,returnbookButton,ratebookButton);
        Scene scene = new Scene(layout, 300, 400);
        mybooks.setScene(scene);
        mybooks.show();
    }
}
