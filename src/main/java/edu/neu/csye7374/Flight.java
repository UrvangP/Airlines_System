package main.java.edu.neu.csye7374;

import main.java.edu.neu.csye7374.State.Canceled;
import main.java.edu.neu.csye7374.State.FlightStatusAPI;
import main.java.edu.neu.csye7374.State.Scheduled;

public class Flight implements FlightAPI{

    private String name;
    private double price;
    private String description;

    private FlightStatusAPI scheduledState;
    private FlightStatusAPI canceledState;
    private FlightStatusAPI currectState;


    public Flight(String name, double price, String desc) {
        this.name = name;
        this.price = price;
        this.description = desc;
        this.scheduledState = new Scheduled(this);
        this.canceledState = new Canceled(this);
        this.currectState = new Scheduled(this);
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    public void setState(FlightStatusAPI state) { this.currectState = state; }

    public FlightStatusAPI schedule() { return scheduledState; }

    public FlightStatusAPI cancel() { return canceledState; }
}
