package businessLogic;

import java.util.ArrayList;
import java.util.List;

public class ScheduleMaintenance {
    private List<String> maintenanceSchedule;

    // Constructor
    public ScheduleMaintenance() {
        maintenanceSchedule = new ArrayList<>();
    }

    // Add a maintenance task
    public void addMaintenance(String busId, String date) {
        maintenanceSchedule.add("Bus ID: " + busId + " - Maintenance Date: " + date);
    }

    // Display maintenance schedule
    public void displayMaintenanceSchedule() {
        System.out.println("Maintenance Schedule:");
        for (String task : maintenanceSchedule) {
            System.out.println(task);
        }
    }
}