package controllers;

import businessLogic.ViewRoutes;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class StudentController
{

    @FXML
    private TextArea outputArea;

    @FXML
    private void handleViewRoutes() {
        outputArea.clear();
        ViewRoutes.addRoutesAndBuses(); // Populate data
        StringBuilder routesDetails = new StringBuilder("Available Routes:\n");
        ViewRoutes.getRoutes().forEach(route -> {
            routesDetails.append(route.getRouteName()).append(" - Stops: ").append(route.getStops()).append("\n");
        });
        outputArea.setText(routesDetails.toString());
    }

    @FXML
    private void handleReserveSeat() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reservation.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("Reservation.css").toExternalForm());
            stage.setTitle("Reservation Management");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleProvideFeedback() {
        // Show Feedback UI
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("feedback.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("feedback.css").toExternalForm());
            stage.setTitle("Provide Feedback");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLostAndFound() {
        // Show Lost and Found UI
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lostandfound.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("lostandfound.css").toExternalForm());
            stage.setTitle("Lost and Found");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//package org.example.sdaproject;
//
//import java.util.*;
//import javafx.application.Platform;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class StudentController {
//
//    public static void handleStudentOperations(Scanner scanner) {
//        boolean exit = false;
//        while (!exit) {
//            // Display available operations for a student
//            System.out.println("\n--- Student Operations ---");
//            System.out.println("1. View Routes");
//            System.out.println("2. Reserve a Seat");
//            System.out.println("3. Provide Feedback");
//            System.out.println("4. Report and Find Lost Items");
//            System.out.println("5. Exit");
//
//            System.out.print("Enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline character
//
//            switch (choice) {
//                case 1 -> handleViewRoutes();
//                case 2 -> handleReserveSeat(scanner);
//                case 3 -> showFeedbackScreen(); // Updated to display the Feedback UI
//                case 4 -> handleLostAndFound(scanner);
//                case 5 -> {
//                    System.out.println("Exiting Student Operations...");
//                    exit = true;
//                }
//                default -> System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    private static void handleReserveSeat(Scanner scanner) {
//        System.out.println("\n===== Reserve a Seat =====");
//
//        // Ensure routes and buses are initialized with dummy data
//        ViewRoutes.addRoutesAndBuses(); // Dummy data entry for routes and buses
//        ViewRoutes.View(); // Display all routes, buses, and schedules
//
//        // Get the list of routes and buses
//        List<Route> routes = ViewRoutes.getRoutes();
//        List<Bus> buses = ViewRoutes.getBuses();
//
//        // Check if routes are available
//        if (routes.isEmpty()) {
//            System.out.println("No routes available. Please add routes first.");
//            return;
//        }
//
//        // Display all buses with seat availability
//        System.out.println("\nAvailable Buses:");
//        for (int i = 0; i < buses.size(); i++) {
//            Bus bus = buses.get(i);
//            System.out.println((i + 1) + ". Bus ID: " + bus.getBusId() +
//                    " | Model: " + bus.getModel() +
//                    " | Available Seats: " + bus.getAvailableSeats() +
//                    " | Route: " + (bus.getRoute() != null ? bus.getRoute().getRouteName() : "No Route Assigned"));
//        }
//
//        // Get user choice for bus
//        System.out.print("Select a bus (by number): ");
//        int busIndex = scanner.nextInt() - 1;
//        scanner.nextLine(); // Consume newline character
//
//        if (busIndex < 0 || busIndex >= buses.size()) {
//            System.out.println("Invalid bus selection.");
//            return;
//        }
//
//        Bus selectedBus = buses.get(busIndex);
//
//        // Check if the bus has an assigned route
//        if (selectedBus.getRoute() == null) {
//            System.out.println("The selected bus does not have an assigned route.");
//            return;
//        }
//
//        // Collect additional reservation details
//        System.out.print("Enter travel date (YYYY-MM-DD): ");
//        String travelDate = scanner.nextLine();
//
//        // Check seat availability and reserve if possible
//        if (selectedBus.getAvailableSeats() > 0) {
//            selectedBus.reserveSeat();
//            System.out.println("\nReservation successful!");
//            System.out.println("Route: " + selectedBus.getRoute().getRouteName());
//            System.out.println("Bus: " + selectedBus.getBusId());
//            System.out.println("Date: " + travelDate);
//        } else {
//            System.out.println("No seats available on this bus.");
//        }
//    }
//
//    private static void handleViewRoutes() {
//        ViewRoutes.addRoutesAndBuses(); // Dummy data entry for routes and buses
//        ViewRoutes.View();
//    }
//    private static void handleLostAndFound(Scanner scanner) {
//        Platform.runLater(() -> {
//            try {
//                Stage stage = new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(StudentController.class.getResource("lostandfound.fxml"));
//                Scene scene = new Scene(fxmlLoader.load());
//
//                // Apply CSS
//                scene.getStylesheets().add(StudentController.class.getResource("lostandfound.css").toExternalForm());
//
//                stage.setTitle("Lost and Found");
//                stage.setScene(scene);
//                stage.show();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
//
//    private static void showFeedbackScreen() {
//        // Ensure UI operations are performed on the JavaFX Application thread
//        Platform.runLater(() -> {
//            try {
//                Stage stage = new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(StudentController.class.getResource("feedback.fxml"));
//                Scene scene = new Scene(fxmlLoader.load());
//                scene.getStylesheets().add(StudentController.class.getResource("Feedback.css").toExternalForm());
//                stage.setTitle("Feedback");
//                stage.setScene(scene);
//                stage.show();
//            } catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//        });
//    }
//}