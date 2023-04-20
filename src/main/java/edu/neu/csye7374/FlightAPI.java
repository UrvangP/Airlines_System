package main.java.edu.neu.csye7374;

import main.java.edu.neu.csye7374.State.FlightStatusAPI;

public interface FlightAPI {

    double getPrice();
    String getName();
    String getDescription();

    void setState(FlightStatusAPI status);

    FlightStatusAPI schedule();
    FlightStatusAPI cancel();
}
