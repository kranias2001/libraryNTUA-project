package com.example.Library;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditBookScreen {
    private ListView<Book> listview;
    private Book book;

    public EditBookScreen(Book book,ListView<Book> listview) {
        this.book=book;
        this.listview=listview;
    }
    public void show() {
        Stage editbookstage = new Stage();
        editbookstage.setTitle("Επεξεργασία Βιβλίου");

        Label TitleLabel = new Label("Τίτλος:");
        TextField TitleField = new TextField();
        Label AuthorLabel = new Label("Συγγραφέας:");
        TextField AuthorField = new TextField();
        Label publisherTitle = new Label("Εκδοτικός Οίκος:");
        TextField publisherField = new TextField();
        Label ISBNLabel = new Label("ISBN:");
        TextField ISBNField = new TextField();
        Label PublicationYearLabel = new Label("Έτος Έκδοσης:");
        TextField PublicationYearField = new TextField();
        Label CategoryLabel = new Label("Κατηγορία:");
        TextField CategoryField = new TextField();
        Label numberOfCopiesLabel = new Label("Αριθμός Αντιτύπων:");
        TextField numberOfCopiesField = new TextField();



        Button addButton = new Button("Προσθήκη");
        addButton.setOnAction(actionEvent -> {
            if (BookDatabase.searchBook(ISBNField.getText())!=null ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Σφάλμα");
                alert.setHeaderText(null);
                alert.setContentText("Υπάρχει ήδη αυτό το βιβλίο");
                alert.showAndWait();
            }
            else {
                BookDatabase.editBook(book,TitleField.getText(),AuthorField.getText(),CategoryField.getText(),
                        ISBNField.getText(),Integer.parseInt(PublicationYearField.getText()),
                        Integer.parseInt(numberOfCopiesField.getText()),publisherField.getText());
                listview.refresh();
                editbookstage.close();
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(TitleLabel, TitleField, AuthorLabel, AuthorField, publisherTitle,publisherField , ISBNLabel,ISBNField , PublicationYearLabel,PublicationYearField ,
                CategoryLabel  , CategoryField,numberOfCopiesLabel, numberOfCopiesField,addButton );

        ScrollPane scrollPane= new ScrollPane(layout);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 400, 300);
        editbookstage.setScene(scene);
        editbookstage.initModality(Modality.APPLICATION_MODAL);
        editbookstage.showAndWait();
    }
}

