package main.java.edu.neu.csye7374.Adapter;


//Adapter Pattern

import main.java.edu.neu.csye7374.Prototype.FlightAPI;

public class TicketAdapter implements TicketAPI {

    private FlightAPI flight;
    int id;
    String name;
    static int counter=1;
    double price;

    public TicketAdapter(String n, FlightAPI f) {
        id = counter++;
        name = n;
        flight = f;
        price = flight.getPrice();
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
        return this.price;
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

    @Override
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

}
