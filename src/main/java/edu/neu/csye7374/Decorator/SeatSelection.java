package main.java.edu.neu.csye7374.Decorator;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.FlightAPI;

public class SeatSelection extends TicketDecoratorAPI {

    private TicketAPI ticket;

    public SeatSelection(TicketAPI ticket) {
        this.ticket = ticket;
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + 25.00;
    }

    @Override
    public FlightAPI getFlight() {
        return ticket.getFlight();
    }

    @Override
    public void setFlight(FlightAPI fl) {
        ticket.setFlight(fl);
    }

    @Override
    public String toString(){
        return "Ticket id: " + ticket.getId() + " ,Passenger Name: " + ticket.getName() + " ,Flight Name: " +
                ticket.getFlight().getName() + " ,Flight Price: " + getPrice() + ", Seat Selection";
    }

    @Override
    public int getId() {
        return ticket.getId();
    }

    @Override
    public String getName() {
        return ticket.getName();
    }
}
