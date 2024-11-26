package controllers;

import businessLogic.PaymentRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FeeVerificationController
{
    @FXML
    private TableView<PaymentRecord> paymentTable;
    @FXML
    private TableColumn<PaymentRecord, String> transactionIdColumn;
    @FXML
    private TableColumn<PaymentRecord, String> dateColumn;
    @FXML
    private TableColumn<PaymentRecord, Double> amountColumn;
    @FXML
    private TableColumn<PaymentRecord, String> statusColumn;

    private ObservableList<PaymentRecord> paymentRecords;

    @FXML
    public void initialize() {
        // Initialize payment records
        paymentRecords = FXCollections.observableArrayList(
                new PaymentRecord("TXN123", "2024-01-01", 500.0, "Completed"),
                new PaymentRecord("TXN124", "2024-01-10", 250.0, "Pending"),
                new PaymentRecord("TXN125", "2024-01-15", 300.0, "Failed")
        );

        // Bind data to table
        paymentTable.setItems(paymentRecords);

        // Set up columns
        transactionIdColumn.setCellValueFactory(data -> data.getValue().transactionIdProperty());
        dateColumn.setCellValueFactory(data -> data.getValue().dateProperty());
        amountColumn.setCellValueFactory(data -> data.getValue().amountProperty().asObject());
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty());
    }

    @FXML
    private void onVerifyClicked() {
        PaymentRecord selectedPayment = paymentTable.getSelectionModel().getSelectedItem();
        if (selectedPayment == null) {
            showAlert("Error", "Please select a payment transaction to verify.");
            return;
        }

        switch (selectedPayment.getStatus()) {
            case "Completed":
                showAlert("Verification Successful", "The payment of " + selectedPayment.getAmount() +
                        " for Transaction ID: " + selectedPayment.getTransactionId() + " has been successfully verified.");
                break;
            case "Pending":
                showAlert("Verification Failed", "The payment for Transaction ID: " + selectedPayment.getTransactionId() +
                        " is still pending. Please complete the payment.");
                break;
            case "Failed":
                showAlert("Verification Failed", "The payment for Transaction ID: " + selectedPayment.getTransactionId() +
                        " has failed. Please retry or contact support.");
                break;
            default:
                showAlert("Error", "An unexpected error occurred during payment verification.");
                break;
        }
    }

    @FXML
    private void onBackClicked() {
        showAlert("Navigation", "Returning to the previous screen.");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }



}