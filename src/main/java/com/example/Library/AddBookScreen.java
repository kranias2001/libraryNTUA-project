package com.example.Library;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddBookScreen {
    /**
     * Δεν παίρνει κάποια παράμετρο και καλείται από την την κλάση ViewBooksAdmin
     * AddBookScreen addBookScreenScreen = new AddBookScreen();
     * addBookScreenScreen.show();
     * η λειτουργία της κλάσης AddBookScreen είναι να εμφανίζει μία φόρμα για τον ορισμό αντικειμένων της κλάσης Book (ορίζονται τα βιβλία)
     * και επιλέγοντας το κουμπί "Προσθήκη" ελέγχονται τα πεδία που αντιστοιχούν στις παραμέτρους του αντικείμενου(βιβλίου) που θέλουμε
     * να ορίσουμε ενώ η searchBook έχει οριστεί στην κλάση BookDatabase και επιστρέφει την λίστα με όλα τα βιβλία με φίλτρο
     * να εντοπίσει και να επιστρέψει μόνο ένα βιβλίο με το isbn που του ζητήσαμε.
     */
    public void show() {
        Stage addbookstage = new Stage();
        addbookstage.setTitle("Προσθήκη Βιβλίου");

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
            if (TitleField.getText().isEmpty() || AuthorField.getText().isEmpty() ||
                    publisherField.getText().isEmpty() || ISBNField.getText().isEmpty() ||
                    PublicationYearField.getText().isEmpty() || CategoryField.getText().isEmpty()
                    || numberOfCopiesField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Σφάλμα");
                alert.setHeaderText(null);
                alert.setContentText("Παρακαλώ συμπληρώστε όλα τα πεδία.");
                alert.showAndWait();
            }
            else if (BookDatabase.searchBook(ISBNField.getText())!=null ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Σφάλμα");
                alert.setHeaderText(null);
                alert.setContentText("Υπάρχει ήδη αυτό το βιβλίο");
                alert.showAndWait();
            }
            else if (!isInteger(PublicationYearField.getText()) || !isInteger(numberOfCopiesField.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Σφάλμα");
                alert.setHeaderText(null);
                alert.setContentText("Ελέγξτε ότι τα πεδία είναι σωστά.");
                alert.showAndWait();
            }
            else {
                Book newBook = new Book(TitleField.getText(), AuthorField.getText(),
                        publisherField.getText(), ISBNField.getText(),
                        Integer.parseInt(PublicationYearField.getText()), CategoryField.getText(), Integer.parseInt(numberOfCopiesField.getText()),0.0,0);  // Μετατροπη publicationYear και numberOfCopies σε int .
                BookDatabase.addBook(newBook);
                addbookstage.close();
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(TitleLabel, TitleField, AuthorLabel, AuthorField, publisherTitle,publisherField , ISBNLabel,ISBNField , PublicationYearLabel,PublicationYearField ,
                CategoryLabel  , CategoryField,numberOfCopiesLabel, numberOfCopiesField,addButton );

        ScrollPane scrollPane= new ScrollPane(layout);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 400, 300);
        addbookstage.setScene(scene);
        addbookstage.initModality(Modality.APPLICATION_MODAL);
        addbookstage.showAndWait();
    }
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
}
}

