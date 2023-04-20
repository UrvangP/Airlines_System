package main.java.edu.neu.csye7374.State;

import main.java.edu.neu.csye7374.FlightAPI;

public class Canceled implements FlightStatusAPI{

    private FlightAPI flight;

    public Canceled(FlightAPI f) {
        this.flight = f;
    }
    @Override
    public String scheduled() {
        flight.setState(flight.cancel());
        return "Flight is canceled";
    }

    @Override
    public String cancelled() {
        return "Flight is already canceled";
    }
}
