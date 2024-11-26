package businessLogic;


import java.util.*;

public class Feedback {
    // Inner class to represent a feedback entry
    private static class FeedbackEntry {
        private String studentName;
        private String feedbackText;
        private int rating;

        public FeedbackEntry(String studentName, String feedbackText, int rating) {
            this.studentName = studentName;
            this.feedbackText = feedbackText;
            this.rating = rating;
        }

        public void displayFeedback() {
            System.out.println("Student: " + studentName);
            System.out.println("Feedback: " + feedbackText);
            System.out.println("Rating: " + rating + "/5");
        }
    }

    // List to store feedback entries
    private static List<FeedbackEntry> feedbackList = new ArrayList<>();

    // Method to add feedback
    public static void addFeedback(Scanner scanner) {
        System.out.print("Enter your name: ");
        scanner.nextLine();
        String studentName = scanner.nextLine();

        System.out.print("Enter your feedback: ");
        String feedbackText = scanner.nextLine();

        int rating = 0;
        boolean validRating = false;

        // Input validation for rating
        while (!validRating) {
            System.out.print("Rate our services (1 to 5): ");
            if (scanner.hasNextInt()) {
                rating = scanner.nextInt();
                if (rating >= 1 && rating <= 5) {
                    validRating = true; // Rating is valid, exit loop
                } else {
                    System.out.println("Invalid rating. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next();
            }
        }

        feedbackList.add(new FeedbackEntry(studentName, feedbackText, rating));
        System.out.println("Thank you for your feedback!");
    }

    // Method to display all feedback (optional for admins)
    public static void displayAllFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            System.out.println("=== All Feedback ===");
            for (FeedbackEntry feedback : feedbackList) {
                feedback.displayFeedback();
                System.out.println("-------------------");
            }
        }
    }
}