package controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;
import java.util.stream.Collectors;

import businessLogic.LostItem;

public class LostAndFoundController {

    @FXML
    private TextField reporterNameField;

    @FXML
    private TextField itemDescriptionField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField searchField;

    @FXML
    private ListView<String> searchResultsList;

    private final ObservableList<LostItem> lostItems = FXCollections.observableArrayList();

    @FXML
    private void handleReportLostItem() {
        String reporterName = reporterNameField.getText().trim();
        String itemDescription = itemDescriptionField.getText().trim();
        String location = locationField.getText().trim();

        if (reporterName.isEmpty() || itemDescription.isEmpty() || location.isEmpty()) {
            showAlert("Error", "Please fill out all fields to report a lost item.");
            return;
        }

        // Add the lost item to the list
        LostItem lostItem = new LostItem(reporterName, itemDescription, location);
        lostItems.add(lostItem);

        // Clear input fields
        reporterNameField.clear();
        itemDescriptionField.clear();
        locationField.clear();

        showAlert("Success", "Lost item reported successfully!");
    }

    @FXML
    private void handleSearchLostItems() {
        String keyword = searchField.getText().trim().toLowerCase();

        if (keyword.isEmpty()) {
            showAlert("Error", "Please enter a keyword to search.");
            return;
        }

        // Search for items matching the keyword
        List<String> results = lostItems.stream()
                .filter(item -> item.getItemDescription().toLowerCase().contains(keyword)
                        || item.getLocation().toLowerCase().contains(keyword))
                .map(LostItem::toString)
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            showAlert("No Results", "No items found matching the keyword.");
        }

        // Update the ListView with the results
        searchResultsList.setItems(FXCollections.observableArrayList(results));
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
//import java.util.*;
//
//public class LostAndFound {
//    // A list to store reported lost items
//    private static List<LostItem> lostItems = new ArrayList<>();
//
//    // Method to report a lost item
//    public static void reportLostItem(Scanner scanner) {
//        System.out.println("===== Report Lost Item =====");
//        System.out.print("Enter your name: ");
//        String reporterName = scanner.nextLine();
//
//        System.out.print("Enter item description: ");
//        String itemDescription = scanner.nextLine();
//
//        System.out.print("Enter the bus ID or location where the item was lost: ");
//        String location = scanner.nextLine();
//
//        // Add the lost item to the list
//        lostItems.add(new LostItem(reporterName, itemDescription, location));
//        System.out.println("Lost item reported successfully!");
//    }
//
//    // Method to search for lost items
//    public static void searchLostItems(Scanner scanner) {
//        System.out.println("===== Search Lost Items =====");
//        if (lostItems.isEmpty()) {
//            System.out.println("No lost items reported yet.");
//            return;
//        }
//
//        System.out.println("Enter a keyword to search for lost items (e.g., 'bag', 'book'): ");
//        String keyword = scanner.nextLine().toLowerCase();
//
//        // Search for items matching the keyword
//        boolean found = false;
//        for (LostItem item : lostItems) {
//            if (item.getItemDescription().toLowerCase().contains(keyword) ||
//                    item.getLocation().toLowerCase().contains(keyword)) {
//                System.out.println("Found Item:");
//                System.out.println(item);
//                found = true;
//            }
//        }
//
//        if (!found) {
//            System.out.println("No items found matching the keyword.");
//        }
//    }
//}