package businessLogic;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String routeName;
    private List<String> stops;

    // Constructor
    public Route(String routeName) {
        this.routeName = routeName;
        this.stops = new ArrayList<>();
    }

    // Add stop to the route
    public void addStop(String stop) {
        stops.add(stop);
    }

    // Getters
    public String getRouteName() {
        return routeName;
    }

    public List<String> getStops() {
        return stops;
    }

    // Method to display route details
    public void displayRoute() {
        System.out.println("Route: " + routeName);
        for (String stop : stops) {
            System.out.println(" - Stop: " + stop);
        }
    }
}