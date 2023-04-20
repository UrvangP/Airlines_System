package main.java.edu.neu.csye7374.Prototype;

import main.java.edu.neu.csye7374.Builder.FlightBuilder;
import main.java.edu.neu.csye7374.Flight;
import main.java.edu.neu.csye7374.FlightAPI;

public class CloneFlight extends Flight implements Cloneable{

    FlightAPI flight;

    public CloneFlight(String name, double price, String desc) {
        super(name, price, desc);
        FlightBuilder builder = new FlightBuilder();
        builder.setName(name);
        builder.setPrice(price);
        builder.setDescription(desc);
        flight = builder.getItem();
    }

    @Override
    public CloneFlight clone() throws CloneNotSupportedException {
        return (CloneFlight) super.clone();
    }
}
