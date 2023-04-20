package main.java.edu.neu.csye7374.Factories;

import main.java.edu.neu.csye7374.Flight;
import main.java.edu.neu.csye7374.FlightAPI;

public interface FlightFactoryAPI {
    FlightAPI getObject();
    public FlightAPI getObject(Flight.FlightBuilder b);
}
