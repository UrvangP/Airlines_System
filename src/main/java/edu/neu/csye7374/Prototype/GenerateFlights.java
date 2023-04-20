package main.java.edu.neu.csye7374.Prototype;

import main.java.edu.neu.csye7374.Builder.FlightBuilder;
import main.java.edu.neu.csye7374.Factories.CloneFlightFacotryAPI;
import main.java.edu.neu.csye7374.Factories.CloneFlightFactory;
import main.java.edu.neu.csye7374.Factories.FlightFactoryAPI;
import main.java.edu.neu.csye7374.Factories.FlightFactoryLazy;
import main.java.edu.neu.csye7374.FlightAPI;

public class GenerateFlights {

    CloneFlightFacotryAPI factory = CloneFlightFactory.getInstance();
    FlightFactoryAPI flightFactory = FlightFactoryLazy.getInstance();

    public void generate() {

        FlightBuilder builder = new FlightBuilder();
        //TODO: Build the flight

        FlightAPI flight1 = flightFactory.getObject(builder);

        factory.load(0, flight1);
    }
}
