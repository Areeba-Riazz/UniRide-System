package controllers;

import java.util.*;

import businessLogic.FeePayment;
import businessLogic.Student;
import businessLogic.Users;

public class SignUpController {
    // Define the list of users at the class level
    private static List<Users> usersList = new ArrayList<>();
    public static List<Users> getUsersList() {return usersList;}
    public static void setUsersList(List<Users> usersList) {
        SignUpController.usersList = usersList;
    }

    public static void handleStudentSignUp(Scanner scanner) {
        System.out.println("=== User Registration ===");

        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Enter your Title (e.g., Student): ");
        String title = scanner.nextLine();

        System.out.print("Enter your Phone Number: ");
        String phoneNumber = scanner.nextLine();
        while(!isValidPhoneNumber(phoneNumber)) {
            System.out.print("Enter in format (+92xxxxxxxxxx): ");
            phoneNumber = scanner.nextLine();
        }

        if (isStudentExists(email, studentID)) {
            System.out.println("Email/Student ID already exists. Please Log In.");
        } else {
            Student student = new Student(name, email, phoneNumber, studentID, password, title);
            usersList.add(student); // Add the student to the users list
            System.out.println("Registration successful!");

            // Generate Challan after successful registration
            FeePayment.generateChallan(student.getUserId(), student.getName(), 20000.0);
            boolean feeStatus = FeePayment.verifyPayment(student);
//            if(feeStatus)
//                StudentController.handleStudentOperations(scanner);
//            else {
//                System.out.println("Please wait for admin verify your Fee.");
//                //--------------------------------------
//                //admin verification
//                // break;
//                //----------------------------------------
//            }
        }
    }

    private static boolean isStudentExists(String email, String studentID) {
        for (Users user : usersList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
            // Check if the user is a Student and compare the studentID
            if (user instanceof Student) {
                Student student = (Student) user; // Cast to Student
                if (student.getStudentID().equals(studentID)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        // Valid phone number (can be with country code)
        return phoneNumber.matches("^\\+?92\\d{9,12}$");
    }
}