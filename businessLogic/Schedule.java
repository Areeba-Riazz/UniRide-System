package businessLogic;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    // Nested class to store route and time
    public static class ScheduleEntry {
        private String routeName;
        private String time;

        public ScheduleEntry(String routeName, String time) {
            this.routeName = routeName;
            this.time = time;
        }

        public String getRouteName() {
            return routeName;
        }

        public String getTime() {
            return time;
        }
    }

    // List to store schedule entries
    private List<ScheduleEntry> schedule;

    // Constructor
    public Schedule() {
        schedule = new ArrayList<>();
    }

    // Add a schedule for a route
    public void addSchedule(String routeName, String time) {
        schedule.add(new ScheduleEntry(routeName, time));
    }

    // Method to retrieve all schedule entries
    public List<ScheduleEntry> getScheduleEntries() {
        return schedule;
    }

    // Display the schedule
    public void displaySchedule() {
        if (schedule.isEmpty()) {
            System.out.println("No schedule assigned.");
        } else {
            System.out.println("Bus Schedule:");
            for (ScheduleEntry entry : schedule) {
                System.out.println("Route: " + entry.getRouteName() + " - Time: " + entry.getTime());
            }
        }
    }
}