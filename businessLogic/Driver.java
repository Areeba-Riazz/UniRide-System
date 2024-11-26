package businessLogic;

public class Driver extends Users {
    private Bus allocatedBus; // Allocated bus to the driver
    private Schedule schedule; // Schedule for the driver

    public Driver(String name, String email, String phoneNo, String password, String title) {
        super(name, email, phoneNo, password, title);
        this.schedule = new Schedule(); // Initialize the schedule
    }

    public Bus getAllocatedBus() {
        return allocatedBus;
    }

    public void setAllocatedBus(Bus allocatedBus) {
        this.allocatedBus = allocatedBus;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}