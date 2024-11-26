package businessLogic;

import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicBoolean;

import java.io.IOException;
import javafx.scene.control.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/sdaproject/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Apply the CSS file
        scene.getStylesheets().add(getClass().getResource("/org/example/sdaproject/hello.css").toExternalForm());

        stage.setTitle("University Bus Management System");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args)
    {

        launch();
    }
}
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Welcome to the University Bus Management System");
//            System.out.println("Please select your role:");
//            System.out.println("1. Student");
//            System.out.println("2. Admin");
//            System.out.println("3. Driver");
//            System.out.println("4. Parent");
//
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    handleStudent(scanner);
//                    break;
//                case 2:
//                    handleAdmin(scanner);
//                    break;
//                case 3:
//                    handleDriver(scanner);
//                    break;
//                case 4:
//                    handleParent(scanner);
//                    break;
//            }
//            scanner.close();
//        }
//
//
//        public static void handleStudent(Scanner scanner) {
//
//            if (SignUpController.getUsersList().isEmpty()) {
//                Student s1 = new Student("Ali", "ali@abc.com", "+923001234567", "i221234", "1234", "Student");
//                Student s2 = new Student("Ahmed", "ahmed@abc.com", "+923001234567", "i221234", "1234", "Student");
//                SignUpController.getUsersList().add(s1);
//                SignUpController.getUsersList().add(s2);
//            }
//            System.out.println("Welcome, Student!");
//            System.out.println("1. Log in");
//            System.out.println("2. Sign up");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1 :
//                {
//                    AtomicBoolean isLoggedIn = new AtomicBoolean(false); // Use AtomicBoolean to track login status
//                    do {
//                        System.out.println("=== Student Login ===");
//                        Platform.runLater(() -> {
//                            try {
//                                Stage stage = new Stage();
//                                FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("login.fxml"));
//                                Scene scene = new Scene(fxmlLoader.load());
//                                scene.getStylesheets().add(LoginController.class.getResource("login.css").toExternalForm());
//
//                                // Retrieve the controller and check login status
//                                LoginController loginController = fxmlLoader.getController();
//
//                                stage.setTitle("Login");
//                                stage.setScene(scene);
//                                stage.showAndWait(); // Wait for the login window to close
//                                isLoggedIn.set(loginController.isLoggedIn()); // Update AtomicBoolean value
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        });
//
//                        if (isLoggedIn.get()) { // Check AtomicBoolean value
//                            // Successful login, proceed to student operations
//                            //StudentController.handleStudentOperations(scanner);
//                        } else {
//                           // StudentController.handleStudentOperations(scanner);
//                            Platform.runLater(() -> {
//                                try {
//                                    Stage stage = new Stage();
//                                    FXMLLoader fxmlLoader = new FXMLLoader(StudentController.class.getResource("studentoperations.fxml"));
//                                    Scene scene = new Scene(fxmlLoader.load());
//                                    scene.getStylesheets().add(StudentController.class.getResource("StudentOperations.css").toExternalForm());
//
//                                    // Retrieve the controller and check login status
//                                    LoginController loginController = fxmlLoader.getController();
//
//                                    stage.setTitle("Login");
//                                    stage.setScene(scene);
//                                    stage.showAndWait(); // Wait for the login window to close
//                                    isLoggedIn.set(loginController.isLoggedIn()); // Update AtomicBoolean value
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            });
//                            System.out.println("Would you like to try again? (yes/no)");
//                            String retryChoice = scanner.nextLine().trim().toLowerCase();
//
//                            if (!retryChoice.equals("yes")) {
//                                System.out.println("Exiting to main menu.");
//                                break; // Exit the loop if the user doesn't want to retry
//                            }
//                        }
//                    } while (!isLoggedIn.get());
//                }
//                case 2:
//                    // sign-up flow
//                    SignUpController.handleStudentSignUp(scanner);
//                    handleStudent(scanner); // Go back to login/signup after sign-up
//
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//                    break;
//            }
//        }
//
//        private static void handleParent(Scanner scanner) {
//            //time nhi
//        }
//
//        public static void handleDriver(Scanner scanner) {
//       //     LoginController.loginDriver(scanner);
//        }
//
//        private static void handleAdmin(Scanner scanner) {
//            //admin direct login data from sql
//            // admin can add driver like sign and also admin can verify all
//            // payments so that student can access dashboard
//        }
//
