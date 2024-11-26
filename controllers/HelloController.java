package controllers;


import businessLogic.Student;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Label outputLabel;  // Output label for displaying text in UI

    // Handler for Student button click
    @FXML
    private void handleStudentClick() {
                    if (SignUpController.getUsersList().isEmpty())
                    {
                Student s1 = new Student("Ali", "ali@abc.com", "+923001234567", "i221234", "1234", "Student");
                Student s2 = new Student("Ahmed", "ahmed@abc.com", "+923001234567", "i221234", "1234", "Student");
                SignUpController.getUsersList().add(s1);
                SignUpController.getUsersList().add(s2);
                    }
        outputLabel.setText("You selected Student. Please log in or sign up.");
        Platform.runLater(() -> {
            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("login.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                scene.getStylesheets().add(LoginController.class.getResource("login.css").toExternalForm());

                // Retrieve the controller and check login status
                LoginController loginController = fxmlLoader.getController();

                stage.setTitle("Login");
                stage.setScene(scene);
                stage.showAndWait(); // Wait for the login window to close
               // isLoggedIn.set(loginController.isLoggedIn()); // Update AtomicBoolean value
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    // Handler for Admin button click
    @FXML
    private void handleAdminClick() {
        outputLabel.setText("You selected Admin. Please log in.");
    }

    // Handler for Driver button click
    @FXML
    private void handleDriverClick() {
        outputLabel.setText("You selected Driver. Please log in.");
    }

    // Handler for Parent button click
    @FXML
    private void handleParentClick() {
        outputLabel.setText("You selected Parent. Please check your student's schedule.");
    }
}