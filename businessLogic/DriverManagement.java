package businessLogic;

import java.util.Scanner;

public class DriverManagement {

    // Driver login method
    public static void loginDriver(Scanner scanner) {
        boolean isLoginSuccessful = false;

        // Initialize dummy data (this will populate usersList with drivers)
        DriverDummyData.initializeData();

        // Keep trying to login until successful
        while (!isLoginSuccessful) {
            System.out.println("=== Driver Log in ===");
            System.out.print("Enter your Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter your Password: ");
            String password = scanner.nextLine();

            // Check if the entered credentials match any driver in the list
            for (Users user : DriverDummyData.usersList) {
                if (user instanceof Driver && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    System.out.println("Login successful! Welcome, " + user.getName());

                    // Cast to Driver and display driver-specific details
                    Driver driver = (Driver) user;
                    System.out.println("Allocated Bus Details:");
                    if (driver.getAllocatedBus() != null) {
                        System.out.println("Bus ID: " + driver.getAllocatedBus().getBusId());
                    } else {
                        System.out.println("No bus allocated yet.");
                    }

                    // Display schedule if available
                    if (driver.getSchedule() != null) {
                        System.out.println("Schedule:");
                        driver.getSchedule().displaySchedule();
                    } else {
                        System.out.println("No schedule assigned.");
                    }

                    isLoginSuccessful = true; // Exit the loop once login is successful
                    break;
                }
            }

            if (!isLoginSuccessful) {
                System.out.println("Login failed. Invalid email or password. Please try again.");
            }
        }
    }
}