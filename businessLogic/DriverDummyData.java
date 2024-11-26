package businessLogic;

import java.util.ArrayList;
import java.util.List;

public class DriverDummyData {
    // List to hold all users, including drivers
    public static List<Users> usersList = new ArrayList<>();

    // Method to initialize dummy driver and bus data
    public static void initializeData() {
        // Create a dummy driver
        Driver driver = new Driver("Driver1", "d1@abc.com", "1234567890", "1234", "Driver");

        // Create a dummy bus and allocate to the driver
        Bus bus = new Bus("Bus123","Suzuki",10);
        driver.setAllocatedBus(bus);

        // Create and assign a schedule to the driver
        Schedule schedule = new Schedule();
        schedule.addSchedule("Route 1", "8:00 AM");
        schedule.addSchedule("Route 2", "9:30 AM");
       driver.setSchedule(schedule);

        /* Add the driver to the users list */
        usersList.add(driver);
    }
}
