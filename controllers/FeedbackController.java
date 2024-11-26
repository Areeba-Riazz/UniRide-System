package controllers;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class FeedbackController {

    @FXML
    private TextField nameTextField;

    @FXML
    private ComboBox<Integer> ratingComboBox;

    @FXML
    private TextArea feedbackTextArea;

    private static final List<FeedbackEntry> feedbackList = new ArrayList<>();

    @FXML
    public void initialize() {
        // Populate rating options (1-5 stars)
        ratingComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
    }

    @FXML
    private void onSubmitClicked() {
        String name = nameTextField.getText().trim();
        Integer rating = ratingComboBox.getValue();
        String feedback = feedbackTextArea.getText().trim();

        // Input validation
        if (name.isEmpty()) {
            showAlert("Error", "Name is required.");
            return;
        }

        if (rating == null) {
            showAlert("Error", "Rating is required.");
            return;
        }

        if (feedback.isEmpty()) {
            showAlert("Error", "Feedback is required.");
            return;
        }

        // Add feedback to the list
        feedbackList.add(new FeedbackEntry(name, feedback, rating));
        showAlert("Success", "Thank you for your feedback!");

        clearForm();
    }

    @FXML
    private void onClearClicked() {
        clearForm();
    }

    private void clearForm() {
        nameTextField.clear();
        ratingComboBox.setValue(null);
        feedbackTextArea.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // FeedbackEntry class to store feedback details
    private static class FeedbackEntry {
        private final String name;
        private final String feedback;
        private final int rating;

        public FeedbackEntry(String name, String feedback, int rating) {
            this.name = name;
            this.feedback = feedback;
            this.rating = rating;
        }
    }
}