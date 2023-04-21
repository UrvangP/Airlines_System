package main.java.edu.neu.csye7374.Facade;

public class DirectBooking implements FlightBookingAPI{
    @Override
    public void bookFlightTickets() {
        System.out.println("Booking flight direct from the vendor!!!");

    }
}
