package main.java.edu.neu.csye7374.Factories;


//Factory and Singleton Pattern

import main.java.edu.neu.csye7374.Builder.FlightBuilder;
import main.java.edu.neu.csye7374.Prototype.FlightAPI;

public class FlightFactoryEager implements FlightFactoryAPI{
    private static FlightFactoryAPI instance = new FlightFactoryEager();

    private FlightFactoryEager() {
    }

    public static FlightFactoryAPI getInstance() {
        return instance;
    }

    @Override
    public FlightAPI getObject() {
        return new FlightBuilder().getItem();
    }

    @Override
    public FlightAPI getObject(FlightBuilder b) {
        return b.getItem();
    }

}
