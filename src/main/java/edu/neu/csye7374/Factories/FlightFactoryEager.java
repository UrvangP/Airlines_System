package main.java.edu.neu.csye7374.Factories;


//Factory and Singleton Pattern

import main.java.edu.neu.csye7374.Flight;
import main.java.edu.neu.csye7374.FlightAPI;

public class FlightFactoryEager implements FlightFactoryAPI{
    private static FlightFactoryAPI instance = new FlightFactoryEager();

    private FlightFactoryEager() {
    }

    public static FlightFactoryAPI getInstance() {
        return instance;
    }

    @Override
    public FlightAPI getObject() {
        return new Flight.FlightBuilder().getItem();
    }

    @Override
    public FlightAPI getObject(Flight.FlightBuilder b) {
        return b.getItem();
    }

}
