package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

import businessLogic.Student;
import businessLogic.Users;

import java.util.List;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label feedbackLabel;

    private static List<Users> usersList = SignUpController.getUsersList(); // Accessing users list from SignUpController

    private boolean isLoggedIn = false; // Track login status

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    @FXML
    private void handleLogin() {
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();

        // Validate inputs
        if (email.isEmpty() || password.isEmpty()) {
            feedbackLabel.setText("Please fill in both email and password.");
            feedbackLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Check credentials
        for (Users user : usersList) {
            if (user instanceof Student && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                feedbackLabel.setText("Login successful! Welcome, " + user.getName());
                feedbackLabel.setStyle("-fx-text-fill: green;");
                isLoggedIn = true;// Set login status to true
                // Navigate to Student Operations UI
                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentoperations.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(loader.load());
                        scene.getStylesheets().add(getClass().getResource("StudentOperations.css").toExternalForm());
                        stage.setTitle("Lost and Found");
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                return;
            }
        }

        // If login fails
        feedbackLabel.setText("Login failed. Invalid email or password.");
        feedbackLabel.setStyle("-fx-text-fill: red;");
    }
}