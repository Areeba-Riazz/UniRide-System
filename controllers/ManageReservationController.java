package controllers;

//package org.example.sdaproject;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//
//public class ManageReservationController
//{
//
//  @FXML
//  private TableView<Route> reservationTable;
//  @FXML
//  private TableColumn<Route, String> routeNumberColumn;
//  @FXML
//  private TableColumn<Route, String> departureTimeColumn;
//  @FXML
//  private TableColumn<Route, Integer> seatsAvailableColumn;
//  @FXML
//  private TableColumn<Route, String> statusColumn;
//  @FXML
//  private DatePicker datePicker;
//  @FXML
//  private ComboBox<String> timePicker;
//
//  private ObservableList<Route> Routes;
//
//  @FXML
//  public void initialize()
//  {
//      // Populate the time picker with example times
//      timePicker.setItems(FXCollections.observableArrayList("08:00 AM", "10:00 AM", "12:00 PM", "02:00 PM", "04:00 PM"));
//
//      // Initialize columns
//      routeNumberColumn.setCellValueFactory(data -> data.getValue().routeNumberProperty());
//      departureTimeColumn.setCellValueFactory(data -> data.getValue().departureTimeProperty());
//      seatsAvailableColumn.setCellValueFactory(data -> data.getValue().seatsAvailableProperty().asObject());
//      statusColumn.setCellValueFactory(data -> data.getValue().statusProperty());
//
//      // Example data for table
//      busRoutes = FXCollections.observableArrayList(
//              new Route("R101", "08:00 AM", 5, "Available"),
//              new Route("R102", "10:00 AM", 0, "Full"),
//              new Route("R103", "12:00 PM", 3, "Available")
//      );
//
//      reservationTable.setItems(busRoutes);
//  }
//
//  @FXML
//  private void onReserveClicked() {
//      Route selectedRoute = reservationTable.getSelectionModel().getSelectedItem();
//      if (selectedRoute == null || datePicker.getValue() == null || timePicker.getValue() == null) {
//          showAlert("Error", "Please select a route, date, and time to reserve.");
//          return;
//      }
//
//      if (selectedRoute.getSeatsAvailable() > 0) {
//          selectedRoute.setSeatsAvailable(selectedRoute.getSeatsAvailable() - 1);
//          showAlert("Reservation Successful", "You have reserved a seat for route " + selectedRoute.getRouteNumber()
//                  + " on " + datePicker.getValue() + " at " + timePicker.getValue());
//      } else {
//          showAlert("Reservation Failed", "No seats available for this route.");
//      }
//  }
//
//  @FXML
//  private void onModifyClicked() {
//      showAlert("Modify Reservation", "Feature to modify reservations is coming soon.");
//  }
//
//  @FXML
//  private void onCancelClicked() {
//      Route selectedRoute = reservationTable.getSelectionModel().getSelectedItem();
//      if (selectedRoute != null) {
//          selectedRoute.setSeatsAvailable(selectedRoute.getSeatsAvailable() + 1);
//          showAlert("Reservation Canceled", "Your reservation for route " + selectedRoute.getRouteNumber() + " has been canceled.");
//      } else {
//          showAlert("Error", "No reservation selected to cancel.");
//      }
//  }
//
//  private void showAlert(String title, String content) {
//      Alert alert = new Alert(Alert.AlertType.INFORMATION);
//      alert.setTitle(title);
//      alert.setHeaderText(null);
//      alert.setContentText(content);
//      alert.showAndWait();
//  }
//}