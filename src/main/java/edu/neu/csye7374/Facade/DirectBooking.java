package main.java.edu.neu.csye7374.Facade;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.Observer.Booking;

public class DirectBooking implements FlightBookingAPI{
    @Override
    public void bookFlightTickets(TicketAPI ticket) {
        System.out.println("Booking flight direct from the vendor!!!");
        Booking booking = new Booking(ticket);
    }
}
