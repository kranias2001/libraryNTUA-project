module com.example.logingpt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.Library to javafx.fxml;
    exports com.example.Library;
}