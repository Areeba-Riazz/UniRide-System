package businessLogic;


public class Bus
{
    private String busId;
    private String model;
    private int capacity;
    private int availableSeats;
    private Route route;
    private boolean isAvailable;

    // Constructor
    public Bus(String busId, String model, int capacity) {
        this.busId = busId;
        this.model = model;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    public int reserveSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return capacity - availableSeats; // Return reserved seat number
        }
        return -1; // No seats available
    }

    public void releaseSeat(int seatNumber) {
        if (seatNumber > 0 && seatNumber <= capacity) {
            availableSeats++;
        }
    }
    // Getters and Setters
    public String getBusId() {
        return busId;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
    // Method to display bus details
    public void displayBusDetails() {
        System.out.println("Bus ID: " + busId);
        System.out.println("Model: " + model);
        System.out.println("Capacity: " + capacity);
        System.out.println("Available Seats: " + availableSeats);
    }

}