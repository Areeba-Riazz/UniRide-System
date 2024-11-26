package controllers;

import businessLogic.Reservation;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReservationController {

    @FXML
    private TextField studentIdField;

    @FXML
    private TextField routeNameField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField cancelStudentIdField;

    @FXML
    private TextField cancelRouteNameField;

    @FXML
    private TextField cancelDateField;

    @FXML
    private TextField viewStudentIdField;

    @FXML
    private TextArea outputArea;

    @FXML
    private void handleReserveSeat() {
        String studentId = studentIdField.getText().trim();
        String routeName = routeNameField.getText().trim();
        String date = dateField.getText().trim();

        if (studentId.isEmpty() || routeName.isEmpty() || date.isEmpty()) {
            outputArea.setText("Error: Please fill in all fields for reserving a seat.");
            return;
        }

        String result = Reservation.reserveSeat(studentId, routeName, date);
        outputArea.setText(result);
    }

    @FXML
    private void handleCancelReservation() {
        String studentId = cancelStudentIdField.getText().trim();
        String routeName = cancelRouteNameField.getText().trim();
        String date = cancelDateField.getText().trim();

        if (studentId.isEmpty() || routeName.isEmpty() || date.isEmpty()) {
            outputArea.setText("Error: Please fill in all fields for canceling a reservation.");
            return;
        }

        String result = Reservation.cancelReservation(studentId, routeName, date);
        outputArea.setText(result);
    }

    @FXML
    private void handleViewReservations() {
        String studentId = viewStudentIdField.getText().trim();

        if (studentId.isEmpty()) {
            outputArea.setText("Error: Please provide a Student ID.");
            return;
        }

        outputArea.clear();
        Reservation.viewReservations(studentId); // Prints output to console; modify this as needed.
    }
}