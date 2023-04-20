package main.java.edu.neu.csye7374.Decorator;

//Decorator Pattern

import main.java.edu.neu.csye7374.TicketAPI;

public abstract class BookingDecoratorAPI implements TicketAPI {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public String getName(){
        return "";
    }

    @Override
    public String getFlightDetails(){
        return "";
    }

}
