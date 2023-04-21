package main.java.edu.neu.csye7374.Builder;

import main.java.edu.neu.csye7374.Flight;
import main.java.edu.neu.csye7374.FlightAPI;

public class FlightBuilder {

    private double price;
    private String name;
    private String description;
    private int seatsOccupied;

    public FlightBuilder() {
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) { this.description = desc; }

    public FlightAPI getItem() {
        return new Flight(name, price, description, seatsOccupied);
    }

    public void setSeatsOccupied(int s) { this.seatsOccupied = s; }
}