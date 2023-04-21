package main.java.edu.neu.csye7374.Builder;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.Adapter.TicketAdapter;
import main.java.edu.neu.csye7374.Prototype.FlightAPI;

public class TicketBuilder {
    private String name;
    private FlightAPI flight;

    public TicketBuilder() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setFlight(FlightAPI f) { this.flight = f; }

    public TicketAPI getItem() {
        return new TicketAdapter(name, flight);
    }

}
