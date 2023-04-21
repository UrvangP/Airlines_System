package main.java.edu.neu.csye7374;

import main.java.edu.neu.csye7374.FlightAPI;

public class Flight implements FlightAPI, Cloneable {

    private String name;
    private double price;
    private String description;
    private int seatsOccupied;


    public Flight(String name, double price, String desc, int s) {
        this.name = name;
        this.price = price;
        this.description = desc;
        this.seatsOccupied = s;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getSeatsOccupied() {
        return seatsOccupied;
    }


    @Override
    public void setSeatsOccupied(int seatsOccupied) {
        this.seatsOccupied = seatsOccupied;
    }

    @Override
    public String toString() {
        return  "Flight Name: " + getName() + " ,Description: " + getDescription() + " ,Price: "+ getPrice();
    }

    @Override
    public Flight clone() {
        // TODO Auto-generated method stub
        Flight clone = null;

        try {
            clone = (Flight) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
