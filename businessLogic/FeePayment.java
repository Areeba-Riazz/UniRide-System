package businessLogic;

import java.text.SimpleDateFormat;
import java.util.*;

public class FeePayment {

    public static void generateChallan(String userId, String name, double feeAmount) {
        String challanNumber = "CH-" + System.currentTimeMillis(); // Simple unique number based on time
        String dueDate = new SimpleDateFormat("yyyy-MM-dd")
                .format(new Date(System.currentTimeMillis() + 7L * 24 * 60 * 60 * 1000));

        System.out.println("=== Challan Details ===");
        System.out.println("Challan Number: " + challanNumber);
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Fee Amount: PKR " + feeAmount);
        System.out.println("Due Date: " + dueDate);
        System.out.println("=======================");
    }

    public static boolean verifyPayment(Student student) {
        return student.isPaymentStatus();
    }
}