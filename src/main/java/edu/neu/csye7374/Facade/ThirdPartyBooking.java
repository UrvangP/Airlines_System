package main.java.edu.neu.csye7374.Facade;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.Observer.Booking;

public class ThirdPartyBooking implements FlightBookingAPI{
    @Override
    public void bookFlightTickets(TicketAPI ticket) {
        System.out.println("Booking flight using third party applications!!!");
        Booking booking = new Booking(ticket);
    }
}
