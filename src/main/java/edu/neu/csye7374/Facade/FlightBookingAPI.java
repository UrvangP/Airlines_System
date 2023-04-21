package main.java.edu.neu.csye7374.Facade;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;

public interface FlightBookingAPI{
    public void bookFlightTickets(TicketAPI ticket);
}
