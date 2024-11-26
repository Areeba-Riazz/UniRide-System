package businessLogic;


import java.util.*;


public class Reservation {
    private String studentId;
    private String routeName;
    private String busId;
    private String date;
    private int seatNumber;

    private static List<Reservation> reservations = new ArrayList<>();

    // Constructor
    public Reservation(String studentId, String routeName, String busId, String date, int seatNumber) {
        this.studentId = studentId;
        this.routeName = routeName;
        this.busId = busId;
        this.date = date;
        this.seatNumber = seatNumber;
    }

    // Reserve a seat
    public static String reserveSeat(String studentId, String routeName, String date) {
        for (Bus bus : ViewRoutes.getBuses()) {
            if (bus.getRoute() != null && bus.getRoute().getRouteName().equals(routeName)) {
                if (bus.getAvailableSeats() > 0) {
                    int seatNumber = bus.reserveSeat(); // Reduce available seats
                    Reservation newReservation = new Reservation(studentId, routeName, bus.getBusId(), date, seatNumber);
                    reservations.add(newReservation);
                    return "Reservation successful! Seat number: " + seatNumber + " on Bus " + bus.getBusId();
                } else {
                    return "No available seats on this route.";
                }
            }
        }
        return "Route not found.";
    }
    // Cancel a reservation
    public static String cancelReservation(String studentId, String routeName, String date) {
        for (Reservation res : reservations) {
            if (res.studentId.equals(studentId) && res.routeName.equals(routeName) && res.date.equals(date)) {
                for (Bus bus : ViewRoutes.getBuses()) {
                    if (bus.getBusId().equals(res.busId)) {
                        bus.releaseSeat(res.seatNumber); // Increase available seats
                    }
                }
                reservations.remove(res);
                return "Reservation canceled successfully.";
            }
        }
        return "No matching reservation found.";
    }
    // View all reservations for a student
    public static void viewReservations(String studentId) {
        System.out.println("Reservations for Student ID: " + studentId);
        boolean found = false;
        for (Reservation res : reservations) {
            if (res.studentId.equals(studentId)) {
                System.out.println("Route: " + res.routeName + ", Date: " + res.date + ", Bus: " + res.busId + ", Seat: " + res.seatNumber);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No reservations found.");
        }
    }
}