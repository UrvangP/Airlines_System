package main.java.edu.neu.csye7374.Adapter;

import main.java.edu.neu.csye7374.Prototype.FlightAPI;

public interface TicketAPI {
    int getId();

    double getPrice();

    String getName();

    FlightAPI getFlight();

    void setFlight(FlightAPI fl);

    void setPrice(double newPrice);
}
