package main.java.edu.neu.csye7374.Decorator;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.FlightAPI;

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
    public FlightAPI getFlight() {
        return ticket.getFlight();
    }

    @Override
    public void setFlight(FlightAPI fl) {
        ticket.setFlight(fl);
    }

}
