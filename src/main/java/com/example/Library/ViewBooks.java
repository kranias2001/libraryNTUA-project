package com.example.Library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ViewBooks {
    public void show() {
        Stage listofbooks = new Stage();
        listofbooks.setTitle("Όλα τα βιβλία");
        TextField searchbook = new TextField();
        Button searchButton = new Button("Αναζήτηση");

        ObservableList<Book> observableBooks = FXCollections.observableArrayList(BookDatabase.getBooksList());
        FilteredList<Book> filteredBooks= new FilteredList<>(observableBooks);
        ListView<Book> listView = new ListView<>(filteredBooks);

        ObservableList<Borrow> observableBorrowing = BorrowDatabase.getBorrowingsList();
        FilteredList<Borrow> filteredBorrowings= new FilteredList<>(observableBorrowing);
        User USER= UserDatabase.getLoggedIn();
        filteredBorrowings.setPredicate(borrow -> borrow.getuser().getUsername().equals(USER.getUsername()));

        searchButton.setOnAction(event -> {
            String searchText=searchbook.getText();
            filteredBooks.setPredicate(book->book.getTitle().contains(searchText));

        });

        Button borrowbookButton = new Button("Δανεισμός βιβλίου");
        borrowbookButton.setPrefWidth(130);

        borrowbookButton.setOnAction(action -> {
            User user=UserDatabase.getLoggedIn();
            Book book= listView.getSelectionModel().getSelectedItem();
            Borrow borrow=new Borrow(user,book,LocalDate.now());
            if(book.getNumberOfCopies()<1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Σφάλμα");
                alert.setHeaderText(null);
                alert.setContentText("Δεν υπάρχει κάποιο διαθέσιμο αντίτυπο για αυτό το βιβλίο.");
                alert.showAndWait();
            }
           else if(filteredBorrowings.size()>1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Σφάλμα");
                alert.setHeaderText(null);
                alert.setContentText("Έχεις δανειστεί ήδη 2 βιβλία.");
                alert.showAndWait();
            }
             else {
                book.setNumberOfCopies(book.getNumberOfCopies()-1);
                BorrowDatabase.addBorrowing(borrow);
            }} );

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(searchbook, searchButton,listView,borrowbookButton);
        Scene scene = new Scene(layout, 300, 400);
        listofbooks.setScene(scene);
        listofbooks.show();
}
}