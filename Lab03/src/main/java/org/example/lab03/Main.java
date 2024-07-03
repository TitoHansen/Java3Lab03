package org.example.lab03;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
        import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField nameField;
    private TextField contactField;
    private TextField postalField;
    private Label validationLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Contact Information Validator");

        // Create UI components
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        nameField = new TextField();
        nameField.setPromptText("Enter name");

        contactField = new TextField();
        contactField.setPromptText("Enter contact number");

        postalField = new TextField();
        postalField.setPromptText("Enter postal code");

        Button validateButton = new Button("Validate");
        validateButton.setOnAction(e -> validateInput());

        validationLabel = new Label();

        // Add components to the grid
        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Contact Number:"), 0, 1);
        grid.add(contactField, 1, 1);
        grid.add(new Label("Postal Code:"), 0, 2);
        grid.add(postalField, 1, 2);
        grid.add(validateButton, 0, 3, 2, 1); // span 2 columns
        grid.add(validationLabel, 0, 4, 2, 1); // span 2 columns

        // Create scene and set on stage
        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void validateInput() {
        String name = nameField.getText().trim();
        String contact = contactField.getText().trim();
        String postal = postalField.getText().trim();

        boolean isNameValid = validateName(name);
        boolean isContactValid = validateContact(contact);
        boolean isPostalValid = validatePostal(postal);

        if (isNameValid && isContactValid && isPostalValid) {
            validationLabel.setText("All fields are valid!");
        } else {
            validationLabel.setText("Invalid input detected.");
        }
    }

    private boolean validateName(String name) {
        // First character uppercase, rest can be letters
        return name.matches("[A-Z][a-zA-Z]*");
    }

    private boolean validateContact(String contact) {
        // 10 digits with optional formats XXX XXX XXXX or (XXX) XXX XXXX
        return contact.matches("\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})");
    }

    private boolean validatePostal(String postal) {
        // Canadian postal code format A1A 1A1 or A1A-1A1
        return postal.matches("[a-zA-Z]\\d[a-zA-Z] ?\\d[a-zA-Z]\\d");
    }

    public static void main(String[] args) {
        launch(args);
    }
}