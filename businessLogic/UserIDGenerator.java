package businessLogic;

public class UserIDGenerator {
    // Static counter to keep track of the userID
    private static int counter = 100; // Start from user101

    // Function to generate a sequential userID
    public static String generateUserID() {
        counter++;  // Increment the counter to generate the next userID
        return "user" + counter;
    }
}