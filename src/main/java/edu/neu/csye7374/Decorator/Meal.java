package main.java.edu.neu.csye7374.Decorator;

import main.java.edu.neu.csye7374.FlightAPI;
import main.java.edu.neu.csye7374.TicketAPI;

public class Meal extends BookingDecoratorAPI{

    private TicketAPI ticket;

    public Meal(TicketAPI ticket) {
        this.ticket = ticket;
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + 50.00;
    }

    @Override
    public String getFlightDetails() {
        return ticket.getFlightDetails() + " Meal";
    }
}
