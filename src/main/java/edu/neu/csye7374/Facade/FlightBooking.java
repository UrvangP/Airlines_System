package main.java.edu.neu.csye7374.Facade;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;

public class FlightBooking {

    private FlightBookingAPI direct;
    private FlightBookingAPI thidrPaty;
    private TicketAPI ticket;

    public FlightBooking(TicketAPI ticket) {
        direct = new DirectBooking();
        thidrPaty = new ThirdPartyBooking();
        this.ticket = ticket;
    }

    public void bookDirect() {
        direct.bookFlightTickets(ticket);
    }

    public void bookThirdParty() {
        thidrPaty.bookFlightTickets(ticket);
    }
}
