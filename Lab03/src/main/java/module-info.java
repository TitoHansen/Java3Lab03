module org.example.lab03 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab03 to javafx.fxml;
    exports org.example.lab03;
}