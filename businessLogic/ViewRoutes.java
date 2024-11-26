package businessLogic;

import java.util.*;

public class ViewRoutes {
    // List to store all routes
    private static List<Route> routes = new ArrayList<>();
    // List to store all buses
    private static List<Bus> buses = new ArrayList<>();

    private static Schedule schedule;

    public static void addRoutesAndBuses() {
        // Creating and adding routes
         Route route1 = new Route("Route 1");
        route1.addStop("G-11 Markaz");
        route1.addStop("F-10 Markaz");
        route1.addStop("Blue Area");
        route1.addStop("Faisal Mosque");
        routes.add(route1);

        Route route2 = new Route("Route 2");
        route2.addStop("Rawalpindi Saddar");
        route2.addStop("I-8 Markaz");
        route2.addStop("Zero Point");
        route2.addStop("G-11 Markaz");
        routes.add(route2);

        // Creating bus objects and assigning them to routes
        Bus bus1 = new Bus("FAST101", "Toyota Coaster", 40);
        bus1.setRoute(route1);
        buses.add(bus1);

        Bus bus2 = new Bus("FAST102", "Hino", 35);
        bus2.setRoute(route2);
        buses.add(bus2);

        // Adding schedules
        schedule = new Schedule();
        schedule.addSchedule(route1.getRouteName(), "08:00 AM");
        schedule.addSchedule(route2.getRouteName(), "09:00 AM");

        // Adding maintenance tasks
        ScheduleMaintenance maintenance = new ScheduleMaintenance();
        maintenance.addMaintenance(bus1.getBusId(), "2024-11-25");
        maintenance.addMaintenance(bus2.getBusId(), "2024-11-30");
    }

    public static void View() {
        // Displaying all routes
        System.out.println("========== R O U T E S ============");
        if (!routes.isEmpty()) {
            for (Route route : routes) {
                route.displayRoute();
            }
        } else {
            System.out.println("No routes available.");
        }
        System.out.println("===================================");

        // Displaying bus details with routes
        System.out.println("============ BUSES =============");
        if (!buses.isEmpty()) {
            for (Bus bus : buses) {
                bus.displayBusDetails();
                System.out.println("Assigned Route: " + (bus.getRoute() != null ? bus.getRoute().getRouteName() : "No Route Assigned"));
            }
        } else {
            System.out.println("No buses available.");
        }
        System.out.println("===================================");

        // Displaying schedule
        System.out.println("============ SCHEDULE =============");
        if (schedule != null) {
            schedule.displaySchedule();
        } else {
            System.out.println("No schedules available.");
        }
        System.out.println("===================================");



        //for manage reservation
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to manage reservations? (yes/no)");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("yes")) {
            System.out.println("1. Reserve a Seat");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. View Reservations");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter your Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Route Name: ");
                    String routeName = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.println(Reservation.reserveSeat(studentId, routeName, date));
                    break;
                case 2:
                    System.out.print("Enter your Student ID: ");
                    studentId = scanner.nextLine();
                    System.out.print("Enter Route Name: ");
                    routeName = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    date = scanner.nextLine();
                    System.out.println(Reservation.cancelReservation(studentId, routeName, date));
                    break;
                case 3:
                    System.out.print("Enter your Student ID: ");
                    studentId = scanner.nextLine();
                    Reservation.viewReservations(studentId);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static List<Route> getRoutes() {
        return routes;
    }

    public static List<Bus> getBuses() {
        return buses;
    }

    public static Schedule getSchedule() {
        return schedule;
    }
}