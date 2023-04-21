package main.java.edu.neu.csye7374.Adapter;


//Adapter Pattern

import main.java.edu.neu.csye7374.FlightAPI;

public class TicketAdapter implements TicketAPI {

    private FlightAPI flight;
    int id;
    String name;
    static int counter=1;

    public TicketAdapter(String n, FlightAPI f) {
        id = counter++;
        name = n;
        flight = f;
    }

    @Override
    public FlightAPI getFlight() {
        return flight;
    }

    @Override
    public void setFlight(FlightAPI flight) {
        this.flight = flight;
    }

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
    public String toString(){
        return "Ticket id: " + getId() + " ,Passenger Name: " + getName() + " ,Flight Name: " + getFlight().getName() +
                " ,Flight Price: " + getPrice();
    }

}