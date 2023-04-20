package main.java.edu.neu.csye7374.Adapter;


//Adapter Pattern

import main.java.edu.neu.csye7374.FlightAPI;
import main.java.edu.neu.csye7374.TicketAPI;

public class Booking implements TicketAPI {

    private FlightAPI flight;
    int id;
    String name;


    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public double getPrice() {
        return flight.getPrice();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getFlightDetails() {
        return flight.getName() + " - " + flight.getDescription();
    }
}
