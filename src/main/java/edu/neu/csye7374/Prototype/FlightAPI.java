package main.java.edu.neu.csye7374.Prototype;

import main.java.edu.neu.csye7374.Prototype.Flight;

public interface FlightAPI extends Cloneable{

    double getPrice();
    String getName();
    String getDescription();

    int getSeatsOccupied();
    void setSeatsOccupied(int seat);

    public Flight clone();
}
