package main.java.edu.neu.csye7374;

public interface FlightAPI extends Cloneable{

    double getPrice();
    String getName();
    String getDescription();

    int getSeatsOccupied();
    void setSeatsOccupied(int seat);

    public Flight clone();
}
