package main.java.edu.neu.csye7374.Decorator;

import main.java.edu.neu.csye7374.TicketAPI;

public class SeatSelection extends BookingDecoratorAPI{

    private TicketAPI ticket;

    public SeatSelection(TicketAPI ticket) {
        this.ticket = ticket;
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + 25.00;
    }

    @Override
    public String getFlightDetails() {
        return ticket.getFlightDetails() + " Seat Selection";
    }
}
