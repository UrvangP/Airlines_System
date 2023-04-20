package main.java.edu.neu.csye7374.State;

import main.java.edu.neu.csye7374.FlightAPI;

public class Scheduled implements FlightStatusAPI{

    private FlightAPI flight;

    public Scheduled(FlightAPI f) {
        this.flight = f;
    }

    @Override
    public String scheduled() {
        return "Flight is already Scheduled";
    }

    @Override
    public String cancelled() {
        flight.setState(flight.schedule());
        return "Flight is scheduled";
    }
}
